package library.android.eniac.testmr.ui.main.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.List;

import library.android.eniac.testmr.R;
import library.android.eniac.testmr.viewholders.CategoriesViewHolder;

/**
 * Created by RezaNejati on 12/11/2018.
 */
public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesViewHolder> {





    public CategoriesAdapter() {

    }

    @NonNull
    @Override
    public CategoriesViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType) {
        return new CategoriesViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.categories_item, parent, false));
    }


    @Override
    public void onBindViewHolder(@NonNull final CategoriesViewHolder holder, final int position) {

      //  final Option item = data.get(position);

    }


    @Override
    public int getItemCount() {
        return 10;
    }




    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}
