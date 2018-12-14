package library.android.eniac.testmr.ui.map;

import javax.inject.Inject;

import library.android.eniac.testmr.ui.base.BasePresenter;
import library.android.eniac.testmr.ui.base.mvp.MvpView;
import library.android.eniac.testmr.ui.main.fragment.cart.CartMvpPresenter;
import library.android.eniac.testmr.ui.main.fragment.cart.CartMvpView;
import library.android.eniac.testmr.ui.main.fragment.category.CategoriesMvpPresenter;
import library.android.eniac.testmr.ui.main.fragment.category.CategoriesMvpView;

/**
 * Created by RezaNejati on 12/12/2018.
 */
public class MapPresenter<V extends MapMvpView> extends BasePresenter<V>
        implements MapMvpPresenter<V> {
    @Inject
    public MapPresenter() {
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


}
