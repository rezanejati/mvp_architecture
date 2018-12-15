package library.android.eniac.testmr.ui.main.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.aakira.expandablelayout.ExpandableLayout;
import com.github.aakira.expandablelayout.ExpandableLayoutListener;
import com.github.aakira.expandablelayout.ExpandableLinearLayout;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import library.android.eniac.testmr.R;
import library.android.eniac.testmr.di.component.ActivityComponent;
import library.android.eniac.testmr.model.CategoryModel;
import library.android.eniac.testmr.ui.base.BaseViewHolder;

/**
 * Created by RezaNejati on 12/11/2018.
 */
public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder> {


    private List<CategoryModel> categoryModelList;
    private SparseBooleanArray expandState = new SparseBooleanArray();
    private ActivityComponent component;

    public void addItems(List<CategoryModel> categoryModels) {
        if (categoryModelList.size() != 0)
            categoryModelList.clear();

        categoryModelList.addAll(categoryModels);

        for (int i = 0; i < categoryModels.size(); i++) {
            expandState.append(i, false);
        }

        notifyDataSetChanged();
    }

    public void setComponent(ActivityComponent component) {
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

    public class CategoriesViewHolder extends BaseViewHolder implements ExpandableLayoutListener {
        private List<CategoryModel> categoryModels;
        private SparseBooleanArray expandState;
        private int position;
        @Inject
        ProductAdapter productAdapter;
        @BindView(R.id.category_name)
        TextView tvCategoryName;
        @BindView(R.id.expandable_layout)
        ExpandableLinearLayout expandableLinearLayout;
        @BindView(R.id.product_recycler_view)
        RecyclerView rvProduct;

        @OnClick(R.id.categoty_container)
        void onCatContainerClick() {
            expandState(expandableLinearLayout);
        }


        public CategoriesViewHolder(View itemView, List<CategoryModel> categoryModels,SparseBooleanArray expandState) {
            super(itemView);

            ButterKnife.bind(this, itemView);
            this.categoryModels = categoryModels;
            this.expandState = expandState;
            expandableLinearLayout.setInRecyclerView(true);
            expandableLinearLayout.setListener(this);

        }


        @Override
        public void onBind(int position) {
            super.onBind(position);
            this.position = position;
            rvProduct.setLayoutManager(new LinearLayoutManager(itemView.getContext()));
            expandableLinearLayout.setExpanded(expandState.get(position));
            tvCategoryName.setText(categoryModels.get(position).getCategoryName());
        }

        @Override
        public void onAnimationStart() {

        }

        @Override
        public void onAnimationEnd() {

        }

        @Override
        public void onPreOpen() {
            expandState.put(position, true);


        }

        @Override
        public void onPreClose() {
            expandState.put(position, false);


        }

        @Override
        public void onOpened() {

        }

        @Override
        public void onClosed() {

        }

        private void expandState(final ExpandableLayout expandableLayout) {
            expandableLayout.toggle();
        }

        public void setComponent(ActivityComponent component) {
            component.inject(this);
            rvProduct.setAdapter(productAdapter);
            productAdapter.addItems(categoryModels.get(position).getProductDtos());
            productAdapter.setComponent(component);
        }
    }

}
