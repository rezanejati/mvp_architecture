package library.android.eniac.testmr.ui.base.mvp;

/**
 * Created by RezaNejati on 12/11/2018.
 */
public interface MvpPresenter<V extends MvpView> {

    void onAttach(V mvpView);
    void onResume();
    void onDestroy();
    void onStart();
    void onPause();


}