package com.example.codehans.apprealtime;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ogtie05 on 7/06/2017.
 */

public class RegionAdapter extends RecyclerView.Adapter<RegionAdapter.RegionViewHolder> implements View.OnClickListener {


    private View.OnClickListener listener;
    private ArrayList<RegionDetail> datosRegion;

    public RegionAdapter(ArrayList<RegionDetail> datosRegion) {
        this.datosRegion = datosRegion;
    }

    public void setOnclickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if (listener != null) {
            listener.onClick(v);
        }
    }

    public static class RegionViewHolder extends RecyclerView.ViewHolder {

        private TextView txtTitulo;
        private TextView txtSubt;

        public RegionViewHolder(View itemView) {
            super(itemView);

            txtTitulo = (TextView) itemView.findViewById(R.id.LblTitulo);
            txtSubt = (TextView) itemView.findViewById(R.id.LblSubTitulo);
        }

        public void bindRegion(RegionDetail region) {
            txtTitulo.setText(region.getTitulo());
            txtSubt.setText(region.getSubt());
        }


    }


    @Override
    public RegionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_region_detail, parent, false);

        itemView.setOnClickListener(this);

        RegionViewHolder regionvh = new RegionViewHolder(itemView);

        return regionvh;
    }

    @Override
    public void onBindViewHolder(RegionViewHolder viewholder, int position) {
        RegionDetail item = datosRegion.get(position);
        viewholder.bindRegion(item);
    }


    @Override
    public int getItemCount() {
        return datosRegion.size();
    }

}
