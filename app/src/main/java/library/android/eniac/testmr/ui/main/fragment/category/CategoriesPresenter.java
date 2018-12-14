package library.android.eniac.testmr.ui.main.fragment.category;

import android.content.Context;

import java.util.List;

import javax.inject.Inject;

import library.android.eniac.testmr.data.product.CategoriesImpl;
import library.android.eniac.testmr.data.product.CategoriesInteractor;
import library.android.eniac.testmr.model.CategoryModel;
import library.android.eniac.testmr.ui.base.BasePresenter;
import library.android.eniac.testmr.ui.base.mvp.MvpPresenter;
import library.android.eniac.testmr.ui.base.mvp.MvpView;
import library.android.eniac.testmr.ui.main.fragment.cart.CartMvpPresenter;
import library.android.eniac.testmr.ui.main.fragment.cart.CartMvpView;

/**
 * Created by RezaNejati on 12/11/2018.
 */
public class CategoriesPresenter<V extends CategoriesMvpView> extends BasePresenter<V>
        implements CategoriesMvpPresenter<V> ,CategoriesImpl.OnFinishedListener {
    @Inject
    public CategoriesPresenter() {
        super();


    }






    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onCategoriesFinished(List<CategoryModel> response) {
        getMvpView().categoryData(response);

    }

    @Override
    public void onCategoriesError(String error) {
        getMvpView().onError(error);


    }

    @Override
    public void getData(CategoriesImpl categories) {
        categories.findCategoriesData(this);
    }
}
