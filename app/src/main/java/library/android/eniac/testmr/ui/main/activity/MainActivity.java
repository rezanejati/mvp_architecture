package library.android.eniac.testmr.ui.main.activity;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;

import com.ogaclejapan.smarttablayout.SmartTabLayout;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import library.android.eniac.testmr.R;
import library.android.eniac.testmr.ui.base.BaseActivity;
import library.android.eniac.testmr.ui.base.mvp.MvpView;
import library.android.eniac.testmr.ui.main.adapter.CategoriesAdapter;

public class MainActivity extends BaseActivity implements MainActivityView, SmartTabLayout.TabProvider {

    @Inject
    FragmentPagerItemAdapter mPagerAdapter;
    @Inject
    MainActivityPresenter<MainActivityView> mPresenter;

    @BindView(R.id.main_view_pager)
    ViewPager vpMain;
    @BindView(R.id.tab_layout)
    SmartTabLayout mTabLayout;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getActivityComponent().inject(this);
        initializeView();
        mPresenter.onAttach(this);
    }

    private void initializeView() {

        vpMain.setAdapter(mPagerAdapter);
        mTabLayout.setCustomTabView(this);
        mTabLayout.setViewPager(vpMain);



    }




    @Override
    public View createTabView(ViewGroup container, int position, PagerAdapter adapter) {
        LayoutInflater inflater = LayoutInflater.from(container.getContext());
        View tab = inflater.inflate(R.layout.custom_tab, container, false);
        TextView customText = (TextView) tab.findViewById(R.id.tvTitle);
        switch (position) {
            case 0:
           //  customText.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/MadisonStreetSans-Regular.ttf"));

                customText.setText(adapter.getPageTitle(position));
                break;
            case 1:
               // customText.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/MadisonStreetSans-Regular.ttf"));

                customText.setText(adapter.getPageTitle(position));
                break;

            default:
                throw new IllegalStateException("Invalid position: " + position);
        }
        return tab;
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void onError(String error) {

    }

    @Override
    public void onMessage(String message) {

    }
    protected void onDestroy() {
        super.onDestroy();
    }
}