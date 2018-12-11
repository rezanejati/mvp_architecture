package library.android.eniac.testmr.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import butterknife.ButterKnife;
import library.android.eniac.testmr.di.component.ActivityComponentS;

/**
 * Created by RezaNejati on 12/11/2018.
 */
public abstract class BaseFragment extends Fragment {
    private BaseActivity baseActivity;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        initializeView(view);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            this.baseActivity = (BaseActivity) context;
        }
    }
    protected abstract void initializeView(View view);
    public ActivityComponentS getActivityComponent() {
        if (baseActivity != null) {
            return baseActivity.getActivityComponent();
        }
        return null;
    }



}
