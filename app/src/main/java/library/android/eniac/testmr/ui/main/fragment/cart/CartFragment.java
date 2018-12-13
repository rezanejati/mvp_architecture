package library.android.eniac.testmr.ui.main.fragment.cart;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import butterknife.BindView;
import library.android.eniac.testmr.R;
import library.android.eniac.testmr.di.component.ActivityComponent;
import library.android.eniac.testmr.model.ProductDto;
import library.android.eniac.testmr.ui.base.BaseFragment;
import library.android.eniac.testmr.ui.main.adapter.CartAdapter;

/**
 * Created by RezaNejati on 12/11/2018.
 */
public class CartFragment extends BaseFragment implements CartMvpView {
    private View view;

    @Inject
    CartMvpPresenter<CartMvpView> mPresenter;
    @Inject
    CartAdapter cartAdapter;
    @BindView(R.id.cart_recycler_view)
    RecyclerView rvCart;
    /**
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        if (view != null)
            return view;
        view = inflater.inflate(R.layout.fragment_cart, container, false);
        ActivityComponent component = getActivityComponent();

        if (component != null) {
            component.inject(this);
            mPresenter.onAttach(this);


        }

        return view;
    }


    @Override
    protected void initializeView(View view) {
        rvCart.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvCart.setAdapter(cartAdapter);


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

    @Override
    public void addProduct(ProductDto productDto,Double lat,Double lng) {
        productDto.setLat(lat);
        productDto.setLng(lng);



        cartAdapter.addItems(productDto);
        mPresenter.updateStatus();



    }

    @Override
    public void statusChange() {
        cartAdapter.updateStatus();


    }
}
