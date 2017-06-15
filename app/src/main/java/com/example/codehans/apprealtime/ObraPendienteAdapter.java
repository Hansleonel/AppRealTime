package com.example.codehans.apprealtime;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ogtie05 on 7/06/2017.
 */

public class ObraPendienteAdapter extends RecyclerView.Adapter<ObraPendienteAdapter.ObraPendienteViewHolder> implements View.OnClickListener {

    private ArrayList<ObraPendienteContainer> datosObraPendiente;
    private View.OnClickListener listener;

    public class ObraPendienteViewHolder extends RecyclerView.ViewHolder {
        private TextView txtTitulo;
        private TextView txtSubt;

        public ObraPendienteViewHolder(View itemView) {
            super(itemView);

            txtTitulo = (TextView) itemView.findViewById(R.id.LblTitulo);
            txtSubt = (TextView) itemView.findViewById(R.id.LblSubTitulo);

        }

        public void bindObraPendiente(ObraPendienteContainer p) {
            txtTitulo.setText(p.getTitulo());
            txtSubt.setText(p.getSubt());
        }
    }

    public ObraPendienteAdapter(ArrayList<ObraPendienteContainer> datosObraPendiente) {
        this.datosObraPendiente = datosObraPendiente;
    }

    @Override
    public ObraPendienteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_obra, parent, false);
        itemView.setOnClickListener(this);
        //usando el constructuror de la clase para inicializar el opvh
        ObraPendienteViewHolder opvh = new ObraPendienteViewHolder(itemView);
        return opvh;

    }

    @Override
    public void onBindViewHolder(ObraPendienteViewHolder viewholder, int position) {
        ObraPendienteContainer item = datosObraPendiente.get(position);
        viewholder.bindObraPendiente(item);
    }

    @Override
    public int getItemCount() {
        return datosObraPendiente.size();
    }


    public void setOnclickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if (listener != null)
            listener.onClick(view);
    }

}
