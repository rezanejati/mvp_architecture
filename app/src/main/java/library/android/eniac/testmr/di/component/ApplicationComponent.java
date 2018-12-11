package library.android.eniac.testmr.di.component;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import library.android.eniac.testmr.di.module.AppModule;
import library.android.eniac.testmr.ui.base.BaseApplication;

/**
 * Created by RezaNejati on 12/11/2018.
 */
@Singleton
@Component(modules = AppModule.class)
public interface ApplicationComponent {

    void inject(BaseApplication app);


}