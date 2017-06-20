package com.example.codehans.apprealtime;

/**
 * Created by ogtie05 on 15/06/2017.
 */

public class RegionZonasEmergenciaContainer {
    private String Titulo_ZonaE;
    private String Subt_ZonaE;

    public RegionZonasEmergenciaContainer(String titulo_ZonaE, String subt_ZonaE) {
        Titulo_ZonaE = titulo_ZonaE;
        Subt_ZonaE = subt_ZonaE;
    }

    public String getTitulo_ZonaE() {
        return Titulo_ZonaE;
    }

    public void setTitulo_ZonaE(String titulo_ZonaE) {
        Titulo_ZonaE = titulo_ZonaE;
    }

    public String getSubt_ZonaE() {
        return Subt_ZonaE;
    }

    public void setSubt_ZonaE(String subt_ZonaE) {
        Subt_ZonaE = subt_ZonaE;
    }
}
