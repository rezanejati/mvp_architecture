package library.android.eniac.testmr.ui.main.activity;

import javax.inject.Inject;

import library.android.eniac.testmr.ui.base.BasePresenter;
import library.android.eniac.testmr.ui.base.mvp.MvpView;
import library.android.eniac.testmr.ui.main.fragment.cart.CartMvpPresenter;
import library.android.eniac.testmr.ui.main.fragment.cart.CartMvpView;

/**
 * Created by RezaNejati on 12/11/2018.
 */
public class MainActivityPresenterImpl <V extends MainActivityView> extends BasePresenter<V>
        implements MainActivityPresenter<V> {


    @Inject
    public MainActivityPresenterImpl() {
        super();
    }



}
