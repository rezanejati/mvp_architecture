package library.android.eniac.testmr.ui.main.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;

import com.ogaclejapan.smarttablayout.SmartTabLayout;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import library.android.eniac.testmr.R;
import library.android.eniac.testmr.model.ProductDto;
import library.android.eniac.testmr.ui.base.BaseActivity;
import library.android.eniac.testmr.ui.base.mvp.MvpView;
import library.android.eniac.testmr.ui.main.adapter.CategoriesAdapter;
import library.android.eniac.testmr.ui.main.fragment.cart.CartFragment;
import library.android.eniac.testmr.ui.main.fragment.cart.CartMvpPresenter;
import library.android.eniac.testmr.ui.main.fragment.cart.CartMvpView;

public class MainActivity extends BaseActivity implements MainActivityView, SmartTabLayout.TabProvider {

    @Inject
    FragmentPagerItemAdapter mPagerAdapter;
    @Inject
    MainActivityPresenterImpl<MainActivityView> mPresenter;

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
        mPresenter.onAttach(this);
        initializeView();
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
                customText.setText(adapter.getPageTitle(position));
                break;
            case 1:
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
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100&&resultCode == Activity.RESULT_OK) {
            ProductDto user= new Gson().fromJson(data.getStringExtra("product"), ProductDto.class);
            vpMain.setCurrentItem(1);
            Fragment page = getSupportFragmentManager().findFragmentByTag("android:switcher:" + R.id.main_view_pager + ":" + vpMain.getCurrentItem());
            if (vpMain.getCurrentItem() == 1 && page != null) {
                ((CartFragment)page).addProduct(user,
                        data.getDoubleExtra("lat",0),
                        data.getDoubleExtra("lng",0),
                        data.getDoubleExtra("currentLat",0),
                        data.getDoubleExtra("currentLng",0)

                );
            }


        }





    }



}
