package demomap.android.myapplicationdev.com.p08_locatingaplace;

import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.PermissionChecker;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3;
    private GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FragmentManager fm = getSupportFragmentManager();
        SupportMapFragment mapFragment = (SupportMapFragment)
                fm.findFragmentById(R.id.map);

        mapFragment.getMapAsync(new OnMapReadyCallback(){
            @Override
            public void onMapReady(GoogleMap googleMap) {
                map = googleMap;

                LatLng poi_CausewayPoint1 = new LatLng(1.352083, 103.819836);
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(poi_CausewayPoint1,
                        11));

                UiSettings ui = map.getUiSettings();
                ui.setCompassEnabled(true);

                UiSettings us = map.getUiSettings();
                us.setZoomControlsEnabled(true);

                int permissionCheck = ContextCompat.checkSelfPermission(MainActivity.this,
                        android.Manifest.permission.ACCESS_FINE_LOCATION);

                if (permissionCheck == PermissionChecker.PERMISSION_GRANTED) {
                    map.setMyLocationEnabled(true);
                } else {
                    Log.e("GMap - Permission", "GPS access has not been granted");
                }



                LatLng poi_North = new LatLng(1.461446, 103.813392);
                Marker cp = map.addMarker(new
                        MarkerOptions()
                        .position(poi_North)
                        .title("HQ North")
                        .snippet("Block 333, Admiralty Ave 3, 765654")
                        .icon(BitmapDescriptorFactory.fromResource(android.R.drawable.star_big_on)));

                LatLng point_Central = new LatLng(1.3015829, 103.83827050000002);
                Marker cp2 = map.addMarker(new
                        MarkerOptions()
                        .position(point_Central)
                        .title("HQ East")
                        .snippet("Block 3A, Orchard Ave 3, 134542")
                        .icon(BitmapDescriptorFactory.fromResource(android.R.drawable.star_big_on)));

                LatLng point_East = new LatLng(1.353784, 103.950901);
                Marker cp3 = map.addMarker(new
                        MarkerOptions()
                        .position(point_East)
                        .title("HQ East")
                        .snippet("Block 555, Tampines Ave 3, 287788 ")
                        .icon(BitmapDescriptorFactory.fromResource(android.R.drawable.star_big_on)));







            }
        });

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (map != null) {
                    map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                    LatLng poi_north = new LatLng(1.461446, 103.813392);
                    map.moveCamera(CameraUpdateFactory.newLatLngZoom(poi_north,
                            15));

                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (map != null){
                    map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                    LatLng poi_Central = new LatLng(1.3015829, 103.83827050000002);
                    map.moveCamera(CameraUpdateFactory.newLatLngZoom(poi_Central,
                            15));

                }




            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (map != null){
                    map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                    LatLng poi_East = new LatLng(1.353784, 103.950901);
                    map.moveCamera(CameraUpdateFactory.newLatLngZoom(poi_East,
                            15));

                }
            }
        });
    }
}
