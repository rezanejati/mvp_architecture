package library.android.eniac.testmr.ui.main.activity;

import javax.inject.Inject;

import library.android.eniac.testmr.ui.base.BasePresenter;
import library.android.eniac.testmr.ui.base.mvp.MvpView;

/**
 * Created by RezaNejati on 12/11/2018.
 */
public class MainActivityPresenterImpl implements MainActivityPresenter{




    MainActivityView mainActivityView;
    public MainActivityPresenterImpl(MainActivityView mainActivityView) {
        this.mainActivityView=mainActivityView;
    }



    @Override
    public void onDetach() {



    }

    @Override
    public void handleApiError(Error error) {

    }

    @Override
    public void setUserAsLoggedOut() {

    }
}
