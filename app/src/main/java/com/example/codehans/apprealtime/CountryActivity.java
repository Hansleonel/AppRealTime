package com.example.codehans.apprealtime;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Map;

public class CountryActivity extends AppCompatActivity implements OnMapReadyCallback {

    private Toolbar appbar_country;
    private DrawerLayout drawerLayout;
    private NavigationView navView;
    private GoogleMap Map_country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);

        appbar_country = (Toolbar) findViewById(R.id.appbar_country);
        setSupportActionBar(appbar_country);


        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout_country);

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map_country);
        mapFragment.getMapAsync(this);

        FloatingActionButton fabCountry = (FloatingActionButton) findViewById(R.id.fab_country);
        fabCountry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CameraUpdate camupdt = CameraUpdateFactory.newLatLngZoom(new LatLng(-9.189967, -75.015152), 5);
                Map_country.moveCamera(camupdt);
                Map_country.addMarker(new MarkerOptions().position(new LatLng(-12.046373, -77.042754)).title("Lima").snippet("Grado de Alerta Medio").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
                Map_country.addMarker(new MarkerOptions().position(new LatLng(-12.068636, -75.210298)).title("Huancayo").snippet("Grado de Alerta Alto"));
                Map_country.addMarker(new MarkerOptions().position(new LatLng(-13.53195, -71.96746259999998)).title("Cuzco").snippet("Grado de Alerta Alto"));
                Map_country.addMarker(new MarkerOptions().position(new LatLng(-18.0065679, -70.2462741)).title("Cuarto Marcador"));
                Map_country.addMarker(new MarkerOptions().position(new LatLng(-3.5564921, -80.42708849999997)).title("El quinto Marcador").icon(BitmapDescriptorFactory.defaultMarker(98)));
                Map_country.addMarker(new MarkerOptions().position(new LatLng(-18.0065679, -70.2462741)).title("El sexto marcador"));
                Map_country.addMarker(new MarkerOptions().position(new LatLng(-9.526115, -77.528779)).title("Huaraz").snippet("Grado de Alerta Medio").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
                Map_country.addMarker(new MarkerOptions().position(new LatLng(-7.161746, -78.512785)).title("Cajamarca").icon(BitmapDescriptorFactory.defaultMarker(98)));
                //Map_country.addMarker(new MarkerOptions().position(new LatLng()))
            }
        });

        /*
        //Eventos del Drawer Layout
        drawerLayout.setDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(View drawerView) {

            }

            @Override
            public void onDrawerClosed(View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
        */

        navView = (NavigationView) findViewById(R.id.navview_country);
        navView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {

                        boolean fragmentTransaction = false;
                        Fragment fragment = null;

                        switch (menuItem.getItemId()) {
                            case R.id.menu_seccion_1:
                                fragment = new Fragment1();
                                fragmentTransaction = true;
                                break;
                            case R.id.menu_seccion_2:
                                fragment = new Fragment2();
                                fragmentTransaction = true;
                                break;
                            case R.id.menu_opcion_1:
                                Log.i("NavigationView", "Pulsada opción 1");
                                break;
                            case R.id.menu_opcion_2:
                                Log.i("NavigationView", "Pulsada opción 2");
                                break;
                        }

                        if (fragmentTransaction) {
                            getSupportFragmentManager().beginTransaction()
                                    .replace(R.id.content_frame, fragment)
                                    .commit();

                            menuItem.setChecked(true);
                            getSupportActionBar().setTitle(menuItem.getTitle());
                        }

                        drawerLayout.closeDrawers();

                        return true;
                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        Map_country = googleMap;
        CameraUpdate camupd = CameraUpdateFactory.newLatLngZoom(new LatLng(-9.189967, -75.015152), 5);
        Map_country.moveCamera(camupd);

    }

}
