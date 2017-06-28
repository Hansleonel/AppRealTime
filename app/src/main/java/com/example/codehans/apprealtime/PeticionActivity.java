package com.example.codehans.apprealtime;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TabHost;

import java.util.ArrayList;

public class PeticionActivity extends AppCompatActivity {

    private Toolbar toolbar_peticion;
    private DrawerLayout drawerLayout_peticion;
    private ArrayList<PeticionContainer> ArrayPeticion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peticion);

        toolbar_peticion = (Toolbar) findViewById(R.id.toolbar_peticion);
        setSupportActionBar(toolbar_peticion);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Peticiones");

        drawerLayout_peticion = (DrawerLayout) findViewById(R.id.drawer_layout_peticion);

        TabHost tabs = (TabHost) findViewById(R.id.TabHostPeticion);
        tabs.setup();

        TabHost.TabSpec spec = tabs.newTabSpec("mitab01");
        spec.setContent(R.id.tab_p1);
        spec.setIndicator("NUEVA");
        tabs.addTab(spec);

        spec = tabs.newTabSpec("mitab02");
        spec.setContent(R.id.tab_p2);
        spec.setIndicator("RECIBÍ");
        tabs.addTab(spec);

        spec = tabs.newTabSpec("mitab03");
        spec.setContent(R.id.tab_p3);
        spec.setIndicator("ENVIÉ");
        tabs.addTab(spec);

        spec = tabs.newTabSpec("mitab04");
        spec.setContent(R.id.tab_p4);
        spec.setIndicator("FAVS");
        tabs.addTab(spec);

        tabs.setCurrentTab(0);


    }
}
