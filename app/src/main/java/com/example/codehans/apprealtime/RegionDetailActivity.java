package com.example.codehans.apprealtime;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class RegionDetailActivity extends AppCompatActivity {

    private Toolbar toolbar_region_detail;
    private DrawerLayout drawerL_Region_Detail;
    private NavigationView navview;
    private CardView cardviewRegionDetail;
    private CardView cardviewZonasE;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_region_detail);

        toolbar_region_detail = (Toolbar) findViewById(R.id.appbar_region_detail);
        setSupportActionBar(toolbar_region_detail);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Detalle Region: Cuzco");

        drawerL_Region_Detail = (DrawerLayout) findViewById(R.id.drawer_layout_region_detail);

        navview = (NavigationView) findViewById(R.id.navigationViewRegionDetail);

        cardviewRegionDetail = (CardView) findViewById(R.id.cardview03);

        //CARD VIEW
        cardviewRegionDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegionDetailActivity.this, ObraActivity.class);
                startActivity(intent);
            }
        });

        cardviewZonasE = (CardView) findViewById(R.id.cardview02);

        //SIGUIENTE CARD VIEW
        cardviewZonasE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_zona_e = new Intent(RegionDetailActivity.this, RegionZonasEmergenciaActivity.class);
                startActivity(intent_zona_e);
            }
        });


        //DRAWER NAVIGATION
        navview.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_seccion_1:
                        Intent intent = new Intent(RegionDetailActivity.this, MapActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        finish();
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerL_Region_Detail.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
