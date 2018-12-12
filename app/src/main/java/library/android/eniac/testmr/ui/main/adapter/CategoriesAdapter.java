package library.android.eniac.testmr.ui.main.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import library.android.eniac.testmr.R;
import library.android.eniac.testmr.di.component.ActivityComponentS;
import library.android.eniac.testmr.model.CategoryModel;
import library.android.eniac.testmr.viewholders.CategoriesViewHolder;

/**
 * Created by RezaNejati on 12/11/2018.
 */
public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesViewHolder> {


    private List<CategoryModel> categoryModelList;
    private SparseBooleanArray expandState = new SparseBooleanArray();
    private ActivityComponentS component;

    public void addItems(List<CategoryModel> categoryModels) {
        if (categoryModelList.size() != 0)
            categoryModelList.clear();

        categoryModelList.addAll(categoryModels);

        for (int i = 0; i < categoryModels.size(); i++) {
            expandState.append(i, false);
        }

        notifyDataSetChanged();
    }

    public void setComponent(ActivityComponentS component) {
        this.component=component;


    }

    public CategoriesAdapter(List<CategoryModel> categoryModelList) {
        this.categoryModelList = categoryModelList;



    }

    @NonNull
    @Override
    public CategoriesViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType) {
        return new CategoriesViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.categories_item, parent, false), categoryModelList,expandState);
    }


    @Override
    public void onBindViewHolder(@NonNull final CategoriesViewHolder holder, final int position) {
        holder.onBind(position);
        holder.setComponent(component);



    }

    @Override
    public int getItemCount() {
        return categoryModelList.size();
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
