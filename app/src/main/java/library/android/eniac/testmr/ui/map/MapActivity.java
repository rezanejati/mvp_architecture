package library.android.eniac.testmr.ui.map;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import library.android.eniac.testmr.R;
import library.android.eniac.testmr.di.component.ActivityComponent;
import library.android.eniac.testmr.ui.base.BaseActivity;
import library.android.eniac.testmr.ui.main.fragment.category.CategoriesMvpPresenter;
import library.android.eniac.testmr.ui.main.fragment.category.CategoriesMvpView;

public class MapActivity extends BaseActivity implements MapMvpView, OnMapReadyCallback, GoogleMap.OnCameraIdleListener {
    private GoogleMap googleMap;
    private Double lat, lng,currentLat=0.0,currentLng=0.0;
    private Location mLastLocation;
    @Inject
    MapMvpPresenter<MapMvpView> mPresenter;

    @OnClick(R.id.confirm_address)
    void onAddressConfirm() {
        if (googleMap.getMyLocation()!=null){
            currentLat= googleMap.getMyLocation().getLatitude();
            currentLng=googleMap.getMyLocation().getLongitude();

        }

        Intent returnIntent = new Intent();
        returnIntent.putExtra("product", getIntent().getStringExtra("product"));
        returnIntent.putExtra("lat", lat);
        returnIntent.putExtra("lng", lng);
        returnIntent.putExtra("currentLat",currentLat);
        returnIntent.putExtra("currentLng",currentLng);
        setResult(Activity.RESULT_OK, returnIntent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        ButterKnife.bind(this);

        initializeView();

        getActivityComponent().inject(this);
        mPresenter.onAttach(this);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);


        assert mapFragment != null;
        mapFragment.getMapAsync(this);

    }

    private void initializeView() {
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;
        this.googleMap.setOnCameraIdleListener(this);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
            return;

        this.googleMap.setMyLocationEnabled(true);

    }

    @Override
    public void onCameraIdle() {
        lat=googleMap.getCameraPosition().target.latitude;
        lng=googleMap.getCameraPosition().target.longitude;


    }


}
