package com.nyameh.kmitlnavi;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.akexorcist.googledirection.DirectionCallback;
import com.akexorcist.googledirection.GoogleDirection;
import com.akexorcist.googledirection.constant.TransportMode;
import com.akexorcist.googledirection.model.Direction;
import com.akexorcist.googledirection.model.Step;
import com.akexorcist.googledirection.util.DirectionConverter;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback
{
    private final String SERVER_KEY_STRING = "AIzaSyBBGuCfAogsyCRV7idBn2bdfPifaOiqIfE";
    private String errorMessage;
    private List<Step> step;
    private Boolean firstNavigateFlag = true;

    private LatLng targetLatLng;
    private MarkerOptions targetMarker;
    private GoogleMap mMap;
    private LatLng user = new LatLng(0, 0);
    private LocationManager locationManager;
    private String locationProvider;
    private Boolean navigateMode = false;
    private LocationListener locationListener = new LocationListener()
    {
        @Override
        public void onLocationChanged(Location location)
        {
            user = new LatLng(location.getLatitude(), location.getLongitude());
            if(navigateMode)
            {
                if(firstNavigateFlag)
                {
                    firstNavigateFlag = false;
                    Toast.makeText(MapsActivity.this, "Now Loading \nPlease wait...", Toast.LENGTH_SHORT).show();
                    callPath();
                    LatLngBounds.Builder builder = new LatLngBounds.Builder();
                    builder.include(user);
                    builder.include(targetLatLng);
                    LatLngBounds bounds = builder.build();
                    mMap.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, 100));
                    Toast.makeText(MapsActivity.this, "Finished", Toast.LENGTH_SHORT).show(); //if errorMessage == "OK"
                }
            }
            else
            {
                CameraUpdate locate = CameraUpdateFactory.newLatLng(user);
                mMap.animateCamera(locate);
            }
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {}

        @Override
        public void onProviderEnabled(String provider) {}

        @Override
        public void onProviderDisabled(String provider) {}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        targetLatLng = new LatLng(getIntent().getDoubleExtra("Lat", 0), getIntent().getDoubleExtra("Lng", 0));
        initializeLocationManager();
    }

    @Override
    public void onMapReady(GoogleMap googleMap)
    {
        mMap = googleMap;
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
            return;

        mMap.setMyLocationEnabled(true);
        mMap.animateCamera(CameraUpdateFactory.zoomTo(20));
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);
        if(targetLatLng.latitude != 0 && targetLatLng.longitude != 0)
        {
            navigateMode = true;
            targetMarker = new MarkerOptions().position(targetLatLng);
            mMap.addMarker(targetMarker);
        }
    }

    private void initializeLocationManager()
    {
        this.locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        this.locationProvider = locationManager.getBestProvider(criteria, false);
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
            return;

        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
    }


    private void callPath() /** connect to google ask for path, limit 2xxx per day. error message now can't call from other */
    {
        GoogleDirection.withServerKey(SERVER_KEY_STRING)
                .from(user)
                .to(targetLatLng)
                .transportMode(TransportMode.WALKING)
                .execute(new DirectionCallback() {
                    @Override
                    public void onDirectionSuccess(Direction direction, String rawBody)
                    {
                        if (direction.isOK()){
                            step = direction.getRouteList().get(0).getLegList().get(0).getStepList();
                        }
                        errorMessage = direction.getStatus();
                        drawPath(step, errorMessage);
                    }

                    @Override
                    public void onDirectionFailure(Throwable t) {errorMessage = "DirectionFailure";}
                });
    }

    private Boolean drawPath(List<Step> step, String errorMessage) /**return true if path can draw, but now not use*/
    {
        if(step != null && step.size() >= 1)
        {
            ArrayList<PolylineOptions> polylineOptionList = DirectionConverter.createTransitPolyline(this, step, 5, Color.RED, 3, Color.BLUE);
            for (PolylineOptions polylineOption : polylineOptionList) {
                mMap.addPolyline(polylineOption);
            }
            return true;
        }
        else{Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show(); return false;}
    }
}
