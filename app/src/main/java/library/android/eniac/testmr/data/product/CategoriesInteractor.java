package library.android.eniac.testmr.data.product;

import android.content.Context;

import java.util.List;

import library.android.eniac.testmr.model.CategoryModel;

/**
 * Authors:
 * Reza Nejati <reza.n.j.t.i@gmail.com>
 * Copyright © 2017
 */
public interface CategoriesInteractor {
    interface OnFinishedListener {
        void onCategoriesFinished(List<CategoryModel> response);
        void onCategoriesError(String error);
    }

    void findCategoriesData(OnFinishedListener listener);
}
