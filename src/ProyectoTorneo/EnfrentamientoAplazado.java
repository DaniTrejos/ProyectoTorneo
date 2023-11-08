package ProyectoTorneo;

import java.util.Date;

public class EnfrentamientoAplazado extends Enfrentamiento{
    private String razonAplazamiento;
    private Date nuevafecha = new Date();

    public EnfrentamientoAplazado(String razonAplazamiento, Date nuevafecha) {
        this.razonAplazamiento = razonAplazamiento;
        this.nuevafecha = nuevafecha;
    }

    public EnfrentamientoAplazado(){

    }

    public String getRazonAplazamiento() {
        return razonAplazamiento;
    }

    public void setRazonAplazamiento(String razonAplazamiento) {
        this.razonAplazamiento = razonAplazamiento;
    }

    public Date getNuevafecha() {
        return nuevafecha;
    }

    public void setNuevafecha(Date nuevafecha) {
        this.nuevafecha = nuevafecha;
    }
}
