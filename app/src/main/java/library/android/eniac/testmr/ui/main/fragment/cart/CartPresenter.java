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


import android.os.CountDownTimer;
import android.os.Handler;

import javax.inject.Inject;

import library.android.eniac.testmr.model.ProductDto;
import library.android.eniac.testmr.ui.base.BasePresenter;


public class CartPresenter<V extends CartMvpView> extends BasePresenter<V>
        implements CartMvpPresenter<V> {
    private Handler h;


    @Inject
    public CartPresenter() {
        super();
    }


    @Override
    public void onUpdateData(ProductDto productDto,Double lat,Double lng,Double currentLat,Double currentLng) {
        getMvpView().addProduct(productDto,lat,lng,currentLat,currentLng);

    }

    @Override
    public void updateStatus() {
        if (h!=null){
            h.removeCallbacksAndMessages(null);

        }


         h = new Handler();
        h.postDelayed(new Runnable()
        {

            @Override
            public void run()
            {

                getMvpView().statusChange();




                h.postDelayed(this, 5000);
            }
        }, 5000);


    }


    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onPause() {

    }
}
