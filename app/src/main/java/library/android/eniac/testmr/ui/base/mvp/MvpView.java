package library.android.eniac.testmr.ui.base.mvp;

/**
 * Created by RezaNejati on 12/11/2018.
 */
public interface MvpView {
    void showProgress();
    void hideProgress();
    void onError(String error);
    void onMessage(String message);
}
