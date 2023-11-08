package ProyectoTorneo;

import java.util.ArrayList;
import java.util.Date;

public class Enfrentamiento {
    private Equipo equipo1;
    private Equipo equipo2;
    private Date fechaEndrentamiento = new Date();
    private String lugar;
    private TipoEnfrentamiento tipoEnfrentamiento;
    private TipoDeporte tipoDeporte;
    private EstadoEnfrentamiento estadoEnfrentamiento;

    ArrayList<Juez> listajueces = new ArrayList<>();

    public Enfrentamiento(Equipo equipo1, Equipo equipo2, Date fechaEndrentamiento, String lugar, TipoEnfrentamiento tipoEnfrentamiento, TipoDeporte tipoDeporte, EstadoEnfrentamiento estadoEnfrentamiento, ArrayList<Juez> listajueces) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.fechaEndrentamiento = fechaEndrentamiento;
        this.lugar = lugar;
        this.tipoEnfrentamiento = tipoEnfrentamiento;
        this.tipoDeporte = tipoDeporte;
        this.estadoEnfrentamiento = estadoEnfrentamiento;
        this.listajueces = listajueces;
    }

    public Enfrentamiento(){

    }

    public Equipo getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(Equipo equipo1) {
        this.equipo1 = equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(Equipo equipo2) {
        this.equipo2 = equipo2;
    }

    public Date getFechaEndrentamiento() {
        return fechaEndrentamiento;
    }

    public void setFechaEndrentamiento(Date fechaEndrentamiento) {
        this.fechaEndrentamiento = fechaEndrentamiento;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public TipoEnfrentamiento getTipoEnfrentamiento() {
        return tipoEnfrentamiento;
    }

    public void setTipoEnfrentamiento(TipoEnfrentamiento tipoEnfrentamiento) {
        this.tipoEnfrentamiento = tipoEnfrentamiento;
    }

    public TipoDeporte getTipoDeporte() {
        return tipoDeporte;
    }

    public void setTipoDeporte(TipoDeporte tipoDeporte) {
        this.tipoDeporte = tipoDeporte;
    }

    public EstadoEnfrentamiento getEstadoEnfrentamiento() {
        return estadoEnfrentamiento;
    }

    public void setEstadoEnfrentamiento(EstadoEnfrentamiento estadoEnfrentamiento) {
        this.estadoEnfrentamiento = estadoEnfrentamiento;
    }

    public ArrayList<Juez> getListajueces() {
        return listajueces;
    }

    public void setListajueces(ArrayList<Juez> listajueces) {
        this.listajueces = listajueces;
    }
}
