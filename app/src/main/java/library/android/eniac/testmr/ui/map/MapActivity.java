package library.android.eniac.testmr.ui.map;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

import butterknife.ButterKnife;
import butterknife.OnClick;
import library.android.eniac.testmr.R;
import library.android.eniac.testmr.ui.base.BaseActivity;

public class MapActivity extends BaseActivity implements MapView , OnMapReadyCallback ,GoogleMap.OnCameraIdleListener{
    private GoogleMap googleMap;
    private Double lat,lng;


    @OnClick(R.id.confirm_address)
    void onAddressConfirm() {
        Intent returnIntent = new Intent();
        returnIntent.putExtra("product",getIntent().getStringExtra("product"));
        returnIntent.putExtra("lat",lat);
        returnIntent.putExtra("lng",lng);
        setResult(Activity.RESULT_OK,returnIntent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        ButterKnife.bind(this);

        initializeView();

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);


        assert mapFragment != null;
        mapFragment.getMapAsync(this);

    }

    private void initializeView() {
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap=googleMap;
        this.googleMap.setOnCameraIdleListener(this);

    }

    @Override
    public void onCameraIdle() {
        lat=googleMap.getCameraPosition().target.latitude;
        lng=googleMap.getCameraPosition().target.longitude;


    }
}
