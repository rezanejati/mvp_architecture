package library.android.eniac.testmr.di.module;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import library.android.eniac.testmr.R;
import library.android.eniac.testmr.ui.base.BaseApplication;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by RezaNejati on 12/11/2018.
 */
@Module
public class AppModule {

    private final BaseApplication mApplication;

    public AppModule(BaseApplication application) {
        mApplication = application;
    }


    @Provides
    Application provideApplication() {
        return mApplication;
    }


    @Provides
    @Singleton
    CalligraphyConfig calligraphyConfig() {
        return new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Montserrat-Italic.otf")
                .setFontAttrId(R.attr.fontPath)
                .build();
    }
}
