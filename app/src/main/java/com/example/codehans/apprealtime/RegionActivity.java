package com.example.codehans.apprealtime;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class RegionActivity extends AppCompatActivity implements OnMapReadyCallback {

    private Toolbar toolbar;
    private GoogleMap mapregion;
    private int cont = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_region);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //toolbar = (Toolbar) findViewById(R.id.);
        //setSupportActionBar(toolbar);
        //getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        MapFragment fragment = (MapFragment) getFragmentManager().findFragmentById(R.id.mapregion);
        fragment.getMapAsync(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapregion = googleMap;
        //movimiento a cierto punto del mapa
        CameraUpdate camupd = CameraUpdateFactory.newLatLngZoom(new LatLng(-13.53195, -71.96746259999998), 10);
        mapregion.moveCamera(camupd);
        mapregion.addMarker(new MarkerOptions().position(new LatLng(-13.53195, -71.96746259999998)).title("Cuzco").snippet("Emergencia Alta"));
        mapregion.addMarker(new MarkerOptions().position(new LatLng(-13.570574, -71.9910049)).title("Huallapampa").snippet("Emergencia Media").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
        mapregion.addMarker(new MarkerOptions().position(new LatLng(-13.527852, -71.986198)).title("Villa Rosales").snippet("Emergencia Baja").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        mapregion.addMarker(new MarkerOptions().position(new LatLng(-13.43437, -71.846809)).title("El Bosque").snippet("Emergencia Alta"));
        mapregion.addMarker(new MarkerOptions().position(new LatLng(-13.447059, -71.85161590576172)).title("Pisac").snippet("Emergencia Alta"));
        mapregion.addMarker(new MarkerOptions().position(new LatLng(-13.48579, -71.73831939697266)).title(("Taucamarca")).snippet("Emergencia media").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        mapregion.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {

                cont = cont + 1;
                if (cont % 2 == 1) {
                    Intent intent = new Intent(RegionActivity.this, RegionDetailActivity.class);
                    startActivity(intent);
                }
                return false;
            }
        });

    }
}
