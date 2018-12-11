package library.android.eniac.testmr.ui.base;

import android.app.Application;

import javax.inject.Inject;

import library.android.eniac.testmr.di.component.ApplicationComponent;
import library.android.eniac.testmr.di.component.DaggerApplicationComponent;
import library.android.eniac.testmr.di.module.AppModule;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by RezaNejati on 12/11/2018.
 */
public class BaseApplication extends Application {
    @Inject
    CalligraphyConfig calligraphyConfig;




    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApplicationComponent = DaggerApplicationComponent.builder()
                .appModule(new AppModule(this)).build();

        mApplicationComponent.inject(this);
        CalligraphyConfig.initDefault(calligraphyConfig);



    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }


    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }
}

