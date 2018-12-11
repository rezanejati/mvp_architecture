package library.android.eniac.testmr.ui.main.fragment.category;

import java.util.List;

import library.android.eniac.testmr.model.CategoryModel;
import library.android.eniac.testmr.ui.base.mvp.MvpView;

/**
 * Created by RezaNejati on 12/11/2018.
 */
public interface CategoriesView extends MvpView{
    void categoryData(List<CategoryModel> categoryModels);

}
