package com.example.codehans.apprealtime;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ogtie05 on 15/06/2017.
 */

public class RegionZonasEmergenciaAdapter extends RecyclerView.Adapter<RegionZonasEmergenciaAdapter.RegionZonaEmergenciaViewHolder> {

    private ArrayList<RegionZonasEmergenciaContainer> datosRegionZonasE;
    private View.OnClickListener listener;


    public RegionZonasEmergenciaAdapter(ArrayList<RegionZonasEmergenciaContainer> datosRegionZonasE) {
        this.datosRegionZonasE = datosRegionZonasE;
    }

    @Override
    public RegionZonaEmergenciaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_zonas_emergencia, parent, false);
        RegionZonaEmergenciaViewHolder rvh = new RegionZonaEmergenciaViewHolder(itemView);
        return rvh;
    }

    @Override
    public void onBindViewHolder(RegionZonaEmergenciaViewHolder holder, int position) {
        RegionZonasEmergenciaContainer item = datosRegionZonasE.get(position);
        holder.BindRegionZOnaEmergencia(item);
    }

    @Override
    public int getItemCount() {
        return datosRegionZonasE.size();
    }

    public class RegionZonaEmergenciaViewHolder extends RecyclerView.ViewHolder {

        private TextView txtTitulo;
        private TextView txtSubt;
        private ImageView ImageViewZonaE;

        public RegionZonaEmergenciaViewHolder(View itemView) {
            super(itemView);

            txtTitulo = (TextView) itemView.findViewById(R.id.lbl_titulo_zonaE);
            txtSubt = (TextView) itemView.findViewById(R.id.lbl_subt_zonaE);
            ImageViewZonaE = (ImageView) itemView.findViewById(R.id.Imgv_zonaE);

        }

        public void BindRegionZOnaEmergencia(RegionZonasEmergenciaContainer p) {
            txtTitulo.setText(p.getTitulo_ZonaE());
            txtSubt.setText(p.getSubt_ZonaE());
            if (p.getTitulo_ZonaE().equals("Zona de Prioridad Alta:")) {
                ImageViewZonaE.setImageResource(R.mipmap.ic_region_red);
            } else if (p.getTitulo_ZonaE().equals("Zona de Prioridad Media:")) {
                ImageViewZonaE.setImageResource(R.mipmap.ic_region_ylw);
            }
        }
    }

}
