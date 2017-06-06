package com.example.codehans.apprealtime;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.example.codehans.apprealtime.Fragment_01;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.w3c.dom.Text;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {

    private Toolbar appbar;
    private GoogleMap mapa;
    private DrawerLayout drawerLayout;

    private Button btn_map;

    int mapinteger = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        appbar = (Toolbar) findViewById(R.id.appbar);
        setSupportActionBar(appbar);

        //para la aparicion del menu dentro de toolbar
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        final MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        FloatingActionButton fabMap = (FloatingActionButton) findViewById(R.id.fab_map);
        fabMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //marcadores con sus respectivos estados y colores
                mapa.addMarker(new MarkerOptions().position(new LatLng(-12.046373, -77.042754)).title("Lima").snippet("Grado de Alerta Medio").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
                mapa.addMarker(new MarkerOptions().position(new LatLng(-12.068636, -75.210298)).title("Huancayo").snippet("Grado de Alerta Alto"));
                mapa.addMarker(new MarkerOptions().position(new LatLng(-13.53195, -71.96746259999998)).title("Cuzco"));
                mapa.addMarker(new MarkerOptions().position(new LatLng(-18.0065679, -70.2462741)).title("Cuerto marcador"));
                mapa.addMarker(new MarkerOptions().position(new LatLng(-3.5564921, -80.42708849999997)).title("el quinto marcador").icon(BitmapDescriptorFactory.defaultMarker(98)));
                mapa.addMarker(new MarkerOptions().position(new LatLng(-18.0065679, -70.2462741)).title("el sexto marcador"));
                mapa.addMarker(new MarkerOptions().position(new LatLng(-15.8402218, -70.02188050000001)).title("el septimo marcador").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
                mapa.addMarker(new MarkerOptions().position(new LatLng(-16.4090474, -71.53745099999998)).title("el octavo marcador"));
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onMapReady(final GoogleMap map) {
        mapa = map;
        CameraUpdate camupd = CameraUpdateFactory.newLatLngZoom(new LatLng(-9.189967, -75.015152), 5);
        mapa.moveCamera(camupd);
        mapa.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                mapinteger = mapinteger + 1;
                if (mapinteger % 2 == 1) {
                    Intent i = new Intent(MapActivity.this, RegionActivity.class);
                    startActivity(i);
                }

                return false;
            }
        });
    }
}
