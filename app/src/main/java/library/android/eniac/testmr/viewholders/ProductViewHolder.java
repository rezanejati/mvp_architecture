/*
package library.android.eniac.testmr.viewholders;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import library.android.eniac.testmr.R;
import library.android.eniac.testmr.di.component.ActivityComponentS;
import library.android.eniac.testmr.model.ProductDto;
import library.android.eniac.testmr.ui.base.BaseViewHolder;
import library.android.eniac.testmr.ui.map.MapActivity;

*/
/**
 * Created by RezaNejati on 12/12/2018.
 *//*

public class ProductViewHolder extends BaseViewHolder {


    private List<ProductDto> productDtos;
    private int position;
    @BindView(R.id.product_title)
    TextView tvProductTitle;
    @BindView(R.id.button_buy)
    TextView tvButtonBuy;
    @OnClick(R.id.button_buy)
    void onBuyClick() {
        context.startActivity(new Intent(context, MapActivity.class)
        .putExtra("position",position));


        }

    public ProductViewHolder(View itemView, List<ProductDto> productDtos) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.productDtos = productDtos;

    }

    @Override
    public void onBind(int position) {
        super.onBind(position);
        tvProductTitle.setText(productDtos.get(position).getProductName());
    }

}
*/
