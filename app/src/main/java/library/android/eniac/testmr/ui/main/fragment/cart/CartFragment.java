package library.android.eniac.testmr.ui.main.fragment.cart;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import library.android.eniac.testmr.R;
import library.android.eniac.testmr.ui.base.BaseFragment;

/**
 * Created by RezaNejati on 12/11/2018.
 */
public class CartFragment extends BaseFragment {


    public static CartFragment newInstance() {
        Bundle args = new Bundle();
        CartFragment fragment = new CartFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_categories, container, false);

        return view;
    }

    @Override
    protected void initializeView(View view) {

    }
}
