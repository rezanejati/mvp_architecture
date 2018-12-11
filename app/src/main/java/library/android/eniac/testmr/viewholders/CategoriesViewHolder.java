package library.android.eniac.testmr.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import library.android.eniac.testmr.R;
import library.android.eniac.testmr.model.CategoryModel;
import library.android.eniac.testmr.ui.base.BaseViewHolder;

/**
 * Created by RezaNejati on 12/11/2018.
 */
public class CategoriesViewHolder extends BaseViewHolder {
    List<CategoryModel> categoryModels;
    @BindView(R.id.category_name)
    TextView tvCategoryName;

    public CategoriesViewHolder(View itemView, List<CategoryModel> categoryModels) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.categoryModels=categoryModels;

    }




    @Override
    protected void clear() {

    }

    @Override
    public void onBind(int position) {
        super.onBind(position);
        tvCategoryName.setText(categoryModels.get(position).getCategoryName());
    }
}
