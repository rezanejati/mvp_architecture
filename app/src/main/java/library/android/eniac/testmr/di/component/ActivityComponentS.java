package library.android.eniac.testmr.di.component;

import dagger.Component;
import library.android.eniac.testmr.di.module.ActivityModule;
import library.android.eniac.testmr.ui.main.activity.MainActivity;
import library.android.eniac.testmr.ui.main.adapter.CategoriesAdapter;
import library.android.eniac.testmr.ui.main.adapter.ProductAdapter;
import library.android.eniac.testmr.ui.main.fragment.category.CategoriesFragment;
import library.android.eniac.testmr.viewholders.CategoriesViewHolder;

/**
 * Created by RezaNejati on 12/11/2018.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponentS {
    void inject(MainActivity mainActivity);
    void inject(CategoriesFragment categoriesFragment);
    void inject(ProductAdapter productAdapter);
    void inject(CategoriesViewHolder categoriesViewHolder);



}
