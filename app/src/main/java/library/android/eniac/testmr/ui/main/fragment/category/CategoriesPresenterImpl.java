package library.android.eniac.testmr.ui.main.fragment.category;

import java.util.List;

import library.android.eniac.testmr.data.product.CategoriesImpl;
import library.android.eniac.testmr.data.product.CategoriesInteractor;
import library.android.eniac.testmr.model.CategoryModel;
import library.android.eniac.testmr.ui.base.mvp.MvpPresenter;
import library.android.eniac.testmr.ui.base.mvp.MvpView;

/**
 * Created by RezaNejati on 12/11/2018.
 */
public class CategoriesPresenterImpl implements CategoriesPresenter ,CategoriesInteractor.OnFinishedListener {
    CategoriesView categoriesView;

    public CategoriesPresenterImpl(CategoriesView categoriesView, CategoriesImpl categories) {
        this.categoriesView=categoriesView;
        categories.findCategoriesData(this);
    }

    @Override
    public void onAttach(MvpView mvpView) {

    }

    @Override
    public void onDetach() {

    }




    @Override
    public void onCategoriesFinished(List<CategoryModel> response) {
        categoriesView.categoryData(response);

    }

    @Override
    public void onCategoriesError(String error) {

    }
}
