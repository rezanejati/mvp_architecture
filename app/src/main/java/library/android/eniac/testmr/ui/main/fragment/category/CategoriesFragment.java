package library.android.eniac.testmr.ui.main.fragment.category;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import library.android.eniac.testmr.R;
import library.android.eniac.testmr.di.component.ActivityComponentS;
import library.android.eniac.testmr.ui.base.BaseFragment;
import library.android.eniac.testmr.ui.main.adapter.CategoriesAdapter;

/**
 * Created by RezaNejati on 12/11/2018.
 */
public class CategoriesFragment extends BaseFragment {
    @Inject
    CategoriesAdapter categoriesAdapter;

    @BindView(R.id.categories_recycler_view)
    RecyclerView rvCategoriesAdapter;
    private View view;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.fragment_categories, container, false);

        ActivityComponentS component = getActivityComponent();
        if (component != null) {
            component.inject(this);

        }

        return view;
    }

    @Override
    protected void initializeView(View view) {
        rvCategoriesAdapter.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvCategoriesAdapter.setAdapter(categoriesAdapter);


    }
}
