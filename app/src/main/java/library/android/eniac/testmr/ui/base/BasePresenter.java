package library.android.eniac.testmr.ui.base;

import javax.inject.Inject;

import library.android.eniac.testmr.ui.base.mvp.MvpPresenter;
import library.android.eniac.testmr.ui.base.mvp.MvpView;

/**
 * Created by RezaNejati on 12/11/2018.
 */
public class BasePresenter <V extends MvpView> implements MvpPresenter<V> {
    private V mMvpView;
    @Inject
    public BasePresenter() {

    }
    public V getMvpView() {
        return mMvpView;
    }
    @Override
    public void onAttach(V mvpView) {
        mMvpView = mvpView;
    }

    @Override
    public void onDetach() {
        mMvpView = null;
    }



    @Override
    public void handleApiError(Error error) {

    }

    @Override
    public void setUserAsLoggedOut() {

    }
}
