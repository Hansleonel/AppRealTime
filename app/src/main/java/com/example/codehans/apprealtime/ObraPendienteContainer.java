package com.example.codehans.apprealtime;

/**
 * Created by ogtie05 on 7/06/2017.
 */

public class ObraPendienteContainer {
    private String Titulo;
    private String Subt;

    public ObraPendienteContainer(String titulo, String subt) {
        Titulo = titulo;
        Subt = subt;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getSubt() {
        return Subt;
    }

    public void setSubt(String subt) {
        Subt = subt;
    }
}
