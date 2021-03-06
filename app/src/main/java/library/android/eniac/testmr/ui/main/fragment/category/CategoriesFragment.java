package library.android.eniac.testmr.ui.main.fragment.category;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import library.android.eniac.testmr.R;
import library.android.eniac.testmr.data.product.CategoriesImpl;
import library.android.eniac.testmr.di.component.ActivityComponent;
import library.android.eniac.testmr.model.CategoryModel;
import library.android.eniac.testmr.ui.base.BaseFragment;
import library.android.eniac.testmr.ui.main.adapter.CategoriesAdapter;
import library.android.eniac.testmr.ui.main.fragment.cart.CartMvpPresenter;
import library.android.eniac.testmr.ui.main.fragment.cart.CartMvpView;

/**
 * Created by RezaNejati on 12/11/2018.
 */
public class CategoriesFragment extends BaseFragment implements CategoriesMvpView {
    @Inject
    CategoriesAdapter categoriesAdapter;
    @Inject
    CategoriesMvpPresenter<CategoriesMvpView> mPresenter;
    private ActivityComponent component;
    @BindView(R.id.categories_recycler_view)
    RecyclerView rvCategoriesAdapter;
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        if (view != null)
            return view;

        view = inflater.inflate(R.layout.fragment_categories, container, false);

         component = getActivityComponent();

        if (component != null) {
            component.inject(this);
            mPresenter.onAttach(this);
            mPresenter.getData(new CategoriesImpl(getActivity()));


        }
        return view;
    }

    @Override
    protected void initializeView(View view) {
        rvCategoriesAdapter.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvCategoriesAdapter.setAdapter(categoriesAdapter);
        categoriesAdapter.setComponent(component);


    }

    @Override
    public void categoryData(List<CategoryModel> categoryModels) {
        categoriesAdapter.addItems(categoryModels);

    }

    @Override
    public void openMapActivity() {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void onError(String error) {

    }

    @Override
    public void onMessage(String message) {

    }


}
