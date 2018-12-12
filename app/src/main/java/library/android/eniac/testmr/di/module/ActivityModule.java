package library.android.eniac.testmr.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;
import library.android.eniac.testmr.R;
import library.android.eniac.testmr.model.CategoryModel;
import library.android.eniac.testmr.model.ProductDto;
import library.android.eniac.testmr.ui.main.activity.MainActivityPresenter;
import library.android.eniac.testmr.ui.main.activity.MainActivityPresenterImpl;
import library.android.eniac.testmr.ui.main.activity.MainActivityView;
import library.android.eniac.testmr.ui.main.adapter.CategoriesAdapter;
import library.android.eniac.testmr.ui.main.adapter.ProductAdapter;
import library.android.eniac.testmr.ui.main.fragment.cart.CartFragment;
import library.android.eniac.testmr.ui.main.fragment.category.CategoriesFragment;

/**
 * Created by RezaNejati on 12/11/2018.
 */
@Module
public class ActivityModule {
    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    FragmentPagerItemAdapter fragmentPagerItemAdapter(AppCompatActivity mActivity) {
        return new FragmentPagerItemAdapter(mActivity.getSupportFragmentManager(), FragmentPagerItems.with(mActivity)
                .add(mActivity.getString(R.string.categories), CategoriesFragment.class)
                .add(mActivity.getString(R.string.cart), CartFragment.class)
                .create());
    }
    @Provides
    CategoriesAdapter categoriesAdapter() {
        return new CategoriesAdapter(new ArrayList<CategoryModel>());
    }
   @Provides
   ProductAdapter productAdapter() {
        return new ProductAdapter(new ArrayList<ProductDto>());
    }


}
