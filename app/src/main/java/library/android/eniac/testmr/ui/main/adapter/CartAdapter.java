package library.android.eniac.testmr.ui.main.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import library.android.eniac.testmr.R;
import library.android.eniac.testmr.model.ProductDto;
import library.android.eniac.testmr.ui.base.BaseViewHolder;

/**
 * Authors:
 * Reza Nejati <reza.n.j.t.i@gmail.com>
 * Copyright © 2017
 */
public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {


    private List<ProductDto> productDtos;


    public void addItems(ProductDto categoryModels) {
        productDtos.add(categoryModels);
        notifyDataSetChanged();
    }
    public void updateStatus() {



        for (ProductDto productDto:productDtos) {


            if (productDto.getStatus()==1){
                productDto.setStatus(2);

            }else
            if (productDto.getStatus()==2){
                productDto.setStatus(3);

            }
            if (productDto.getStatus()==3){
                productDto.setStatus(4);

            }




        }
        notifyDataSetChanged();


    }

    public CartAdapter(List<ProductDto> productDtos) {
        this.productDtos = productDtos;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType) {
        return new CartViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cart_item, parent, false));
    }


    @Override
    public void onBindViewHolder(@NonNull final CartViewHolder holder, final int position) {
        holder.onBind(position);


    }

    @Override
    public int getItemCount() {
        return productDtos.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public class CartViewHolder extends BaseViewHolder {


        @BindView(R.id.product_name)
        TextView tvProductName;
        @BindView(R.id.product_pricee)
        TextView tvProductPrice;
        @BindView(R.id.product_status)
        TextView tvProductStatus;
        @BindView(R.id.user_address)
        TextView tvUserAddress;
        @BindView(R.id.user_location)
        TextView tvUserLocation;


        CartViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);


        }

        @Override
        public void onBind(int position) {
            super.onBind(position);
            tvProductName.setText(productDtos.get(position).getProductName());

            //tvProductPrice.setText(String.valueOf(productDtos.get(position).getProductPrice()));
            StringBuilder priceBuilder=new StringBuilder();
            priceBuilder.append("Price: ");
            priceBuilder.append(productDtos.get(position).getProductPrice());
            priceBuilder.append(" Rial");
            tvProductPrice.setText(priceBuilder);
            StringBuilder addressBuilder= new StringBuilder();
            addressBuilder.append("UserAddress: ");
            addressBuilder.append(productDtos.get(position).getLat());
            addressBuilder.append(" , ");
            addressBuilder.append(productDtos.get(position).getLat());
            tvUserAddress.setText(addressBuilder);
            if (productDtos.get(position).getCurrentLat()==0.0||productDtos.get(position).getCurrentLng()==0.0){
                tvUserLocation.setText("UserLocation: Your Location Not Available");
            }else{
                StringBuilder locationBuilder= new StringBuilder();
                locationBuilder.append("UserLocation: ");
                locationBuilder.append(productDtos.get(position).getCurrentLat());
                locationBuilder.append(" , ");
                locationBuilder.append(productDtos.get(position).getCurrentLng());
                tvUserLocation.setText(locationBuilder);

            }



            switch (productDtos.get(position).getStatus()) {
                case 1:
                    tvProductStatus.setText(R.string.pending);
                    break;
                case 2:
                    tvProductStatus.setText(R.string.process);
                    break;
                case 3:
                    tvProductStatus.setText(R.string.delivery);
                    break;
                case 4:
                    tvProductStatus.setText(R.string.delivered);
                    break;
                default:


            }

        }

    }

}
