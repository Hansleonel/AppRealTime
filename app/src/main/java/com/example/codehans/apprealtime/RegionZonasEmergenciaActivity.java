package com.example.codehans.apprealtime;

import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class RegionZonasEmergenciaActivity extends AppCompatActivity {

    private Toolbar toolbar_zonasE;
    private DrawerLayout drawerLayout_zonasE;
    private NavigationView navigationView_zonasE;
    private RecyclerView recViewZonasE;
    private ArrayList<RegionZonasEmergenciaContainer> ArrayDatosZonaE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_region_zonas_emergencia);

        toolbar_zonasE = (Toolbar) findViewById(R.id.toolbar_zonas_emergencia);
        setSupportActionBar(toolbar_zonasE);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        drawerLayout_zonasE = (DrawerLayout) findViewById(R.id.drawer_layout_zonas_emergencia);

        FloatingActionButton fabZonasE = (FloatingActionButton) findViewById(R.id.fab_zonas_emergencia);
        fabZonasE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        navigationView_zonasE = (NavigationView) findViewById(R.id.navigationZonasEmergencia);
        navigationView_zonasE.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_opcion_1:
                        Toast.makeText(RegionZonasEmergenciaActivity.this, "Opcion1", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.menu_opcion_2:
                        Toast.makeText(RegionZonasEmergenciaActivity.this, "Opcion2", Toast.LENGTH_LONG).show();
                        break;

                }

                drawerLayout_zonasE.closeDrawers();
                return true;
            }
        });


        //llenando el array
        ArrayDatosZonaE = new ArrayList<RegionZonasEmergenciaContainer>();
        ArrayDatosZonaE.add(new RegionZonasEmergenciaContainer("Zona de Prioridad Alta:", "Huallapampa"));
        ArrayDatosZonaE.add(new RegionZonasEmergenciaContainer("Zona de Prioridad Alta:", "Santa Maria"));
        ArrayDatosZonaE.add(new RegionZonasEmergenciaContainer("Zona de Prioridad Alta:", "Villa Rosales"));
        ArrayDatosZonaE.add(new RegionZonasEmergenciaContainer("Zona de Prioridad Media:", "Horacio Zevallos"));
        ArrayDatosZonaE.add(new RegionZonasEmergenciaContainer("Zona de Prioridad Media:", "Balconcillo"));
        ArrayDatosZonaE.add(new RegionZonasEmergenciaContainer("Zona de Prioridad Media:", "El Bosque"));
        ArrayDatosZonaE.add(new RegionZonasEmergenciaContainer("Zona de Prioridad Baja:", "Taucumarca"));
        ArrayDatosZonaE.add(new RegionZonasEmergenciaContainer("Zona de Prioridad Baja:", "Pisac"));
        ArrayDatosZonaE.add(new RegionZonasEmergenciaContainer("Zona de Prioridad Baja:", "El Bosque II"));

        RegionZonasEmergenciaAdapter adaptador = new RegionZonasEmergenciaAdapter(ArrayDatosZonaE);


        recViewZonasE = (RecyclerView) findViewById(R.id.RecView_Zonas_Emergencia);
        recViewZonasE.setAdapter(adaptador);
        //la siguiente linea obligatoria para darle una orientacion al Recycler
        recViewZonasE.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        //la siguiente linea no obligatoria cuando se conoce el tamaño exacto del listado
        recViewZonasE.setHasFixedSize(true);
        //la siguiente liena no obligatroria para darle separadores
        recViewZonasE.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        //para darle cierta animacion a la lista no obligatoria
        recViewZonasE.setItemAnimator(new DefaultItemAnimator());

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout_zonasE.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
