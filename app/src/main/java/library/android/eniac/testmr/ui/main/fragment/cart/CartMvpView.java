/*
 * Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://mindorks.com/license/apache-v2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package library.android.eniac.testmr.ui.main.fragment.cart;



import java.util.List;

import library.android.eniac.testmr.model.ProductDto;
import library.android.eniac.testmr.ui.base.mvp.MvpView;



public interface CartMvpView extends MvpView {
    void addProduct(ProductDto productDto,Double lat,Double lng);
    void statusChange();


}
