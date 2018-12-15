package library.android.eniac.testmr.ui.main.fragment.category;

import android.content.Context;

import library.android.eniac.testmr.data.product.CategoriesImpl;
import library.android.eniac.testmr.ui.base.mvp.MvpPresenter;

/**
 * Created by RezaNejati on 12/11/2018.
 */
public interface CategoriesMvpPresenter<V extends CategoriesMvpView>
        extends MvpPresenter<V> {
    void getData(CategoriesImpl categories);
}
