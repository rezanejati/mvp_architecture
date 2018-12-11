package library.android.eniac.testmr.ui.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;

import library.android.eniac.testmr.di.component.ActivityComponentS;
import library.android.eniac.testmr.di.component.DaggerActivityComponentS;
import library.android.eniac.testmr.di.module.ActivityModule;
import library.android.eniac.testmr.ui.base.mvp.MvpView;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by RezaNejati on 12/11/2018.
 */
@SuppressLint("Registered")
public class BaseActivity extends AppCompatActivity {
    private ActivityComponentS mActivityComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityComponent = DaggerActivityComponentS.builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(((BaseApplication) getApplication()).getComponent())
                .build();

    }

    public ActivityComponentS getActivityComponent() {
        return mActivityComponent;
    }

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        return super.onCreateView(name, context, attrs);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }


}
