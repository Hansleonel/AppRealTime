package com.example.codehans.apprealtime;

/**
 * Created by ogtie05 on 27/06/2017.
 */

public class PeticionContainer {
    private String Lugar;
    private String Obra;
    private String Motivo;

    public PeticionContainer(String lugar, String obra, String motivo) {
        Lugar = lugar;
        Obra = obra;
        Motivo = motivo;
    }

    public String getLugar() {
        return Lugar;
    }

    public void setLugar(String lugar) {
        Lugar = lugar;
    }

    public String getObra() {
        return Obra;
    }

    public void setObra(String obra) {
        Obra = obra;
    }

    public String getMotivo() {
        return Motivo;
    }

    public void setMotivo(String motivo) {
        Motivo = motivo;
    }
}
