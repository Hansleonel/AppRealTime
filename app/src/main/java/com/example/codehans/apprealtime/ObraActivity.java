package com.example.codehans.apprealtime;

import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TabHost;
import android.widget.Toast;

import java.util.ArrayList;

public class ObraActivity extends AppCompatActivity {

    Toolbar toolbar_obra;
    DrawerLayout drawerL_obra;

    //usado para el recyclerView
    private RecyclerView recviewObra01;
    private RecyclerView recviewObra02;
    private ArrayList<ObraPendienteContainer> datosObraPendiente;
    private ArrayList<ObraPendienteContainer> datosObraRealizados;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obra);

        toolbar_obra = (Toolbar) findViewById(R.id.appbar_obra);
        setSupportActionBar(toolbar_obra);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Cuzco");

        drawerL_obra = (DrawerLayout) findViewById(R.id.drawer_layout_obra);


        TabHost tabs = (TabHost) findViewById(R.id.TabHostObra);
        tabs.setup();

        TabHost.TabSpec spec = tabs.newTabSpec("mitab01");
        spec.setContent(R.id.tab1);
        spec.setIndicator("PENDIENTES");
        tabs.addTab(spec);

        spec = tabs.newTabSpec("mitab02");
        spec.setContent(R.id.tab2);
        spec.setIndicator("REALIZADOS");
        tabs.addTab(spec);

        tabs.setCurrentTab(0);

        //las siguientes lineas se usaran para el uso del recyclerview
        datosObraPendiente = new ArrayList<ObraPendienteContainer>();
        datosObraPendiente.add(new ObraPendienteContainer("Lugar", "Saqsayhuamn"));
        datosObraPendiente.add(new ObraPendienteContainer("Lugar", "Chinchero"));
        datosObraPendiente.add(new ObraPendienteContainer("Lugar", "  "));
        datosObraPendiente.add(new ObraPendienteContainer("Lugar", "  "));
        datosObraPendiente.add(new ObraPendienteContainer("Lugar", "  "));
        datosObraPendiente.add(new ObraPendienteContainer("Lugar", "  "));
        recviewObra01 = (RecyclerView) findViewById(R.id.RecView_Tab01);
        //la siguiente liena no es totalmnet necesria
        recviewObra01.setHasFixedSize(true);
        final ObraPendienteAdapter adaptador = new ObraPendienteAdapter(datosObraPendiente);

        //estas lineas no son necesarias solo si se kiere realizar algun tipo de accion cuando se pulse
        //un elemento de la lista
        adaptador.setOnclickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Pulsado el elemento" + recviewObra01.getChildAdapterPosition(v), Snackbar.LENGTH_LONG).show();
                //Toast.makeText(ObraActivity.this, "pusaldo el elemento" + recviewObra01.getChildAdapterPosition(v), Toast.LENGTH_LONG).show();
                Log.i("Elemento", "Pulsado elemento" + recviewObra01.getChildAdapterPosition(v));

            }
        });

        datosObraRealizados = new ArrayList<ObraPendienteContainer>();
        datosObraRealizados.add(new ObraPendienteContainer("Titulo 01", "Elemento 01"));
        datosObraRealizados.add(new ObraPendienteContainer("Titulo 02", "Elemento 02"));
        datosObraRealizados.add(new ObraPendienteContainer("Titulo 03", "Elemento 03"));
        datosObraRealizados.add(new ObraPendienteContainer("Titulo 04", "Elemento 04"));

        ObraPendienteAdapter adaptador02 = new ObraPendienteAdapter(datosObraRealizados);

        recviewObra01.setAdapter(adaptador);
        //es obligatorio asociar el recyclerview a una layoutmanager
        recviewObra01.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        //la siguiente linea se usa para la visualizacion de la division entre items del recyclerview
        //recordar implementar el dividerItemDecoration
        recviewObra01.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        //la siguiente linea es usada para la animacion del recyclerview
        //se usara una animacion por default
        recviewObra01.setItemAnimator(new DefaultItemAnimator());


        recviewObra02 = (RecyclerView) findViewById(R.id.RecView_Tab02);
        recviewObra02.setAdapter(adaptador02);
        recviewObra02.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recviewObra02.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        recviewObra02.setItemAnimator(new DefaultItemAnimator());

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerL_obra.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
