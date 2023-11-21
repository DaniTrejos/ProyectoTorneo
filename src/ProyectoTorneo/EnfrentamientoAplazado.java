package ProyectoTorneo;

import java.time.LocalDateTime;
import java.util.Date;

public class EnfrentamientoAplazado extends Enfrentamiento{
    private String razonAplazamiento;
    private LocalDateTime nuevafecha;

    public EnfrentamientoAplazado(String razonAplazamiento, LocalDateTime nuevafecha) {
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

    public LocalDateTime getNuevafecha() {
        return nuevafecha;
    }

    public void setNuevafecha(LocalDateTime nuevafecha) {
        this.nuevafecha = nuevafecha;
    }
}
