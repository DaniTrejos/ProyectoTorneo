package ProyectoTorneo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class Enfrentamiento {
    private String id;
    private LocalDateTime fechaEndrentamiento;
    private String lugar;
    private TipoEnfrentamiento tipoEnfrentamiento;
    private TipoDeporte tipoDeporte;
    private EstadoEnfrentamiento estadoEnfrentamiento;
    ArrayList<Equipo> listaEquipos = new ArrayList<>();
    
    
    
    //al momento de adicionar equipos verificar que no se registre el mismo equipo mas de una ves

    ArrayList<Juez> listajueces = new ArrayList<>();
   // Torneo mit=new Torneo();

    public Enfrentamiento(String id, LocalDateTime fechaEndrentamiento, String lugar, TipoEnfrentamiento tipoEnfrentamiento, TipoDeporte tipoDeporte, EstadoEnfrentamiento estadoEnfrentamiento) {
        this.id = id;
        this.fechaEndrentamiento = fechaEndrentamiento;
        this.lugar = lugar;
        this.tipoEnfrentamiento = tipoEnfrentamiento;
        this.tipoDeporte = tipoDeporte;
        this.estadoEnfrentamiento = estadoEnfrentamiento;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getFechaEndrentamiento() {
        return fechaEndrentamiento;
    }

    public void setFechaEndrentamiento(LocalDateTime fechaEndrentamiento) {
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

    public ArrayList<Equipo> getListaEquipos() {
        return listaEquipos;
    }

    public void setListaEquipos(ArrayList<Equipo> listaEquipos) {
        this.listaEquipos = listaEquipos;
    }

    public ArrayList<Juez> getListajueces() {
        return listajueces;
    }

    public void setListajueces(ArrayList<Juez> listajueces) {
        this.listajueces = listajueces;
    }

    public Enfrentamiento(){

    }
    
    public String entrada(String cadena){
        return JOptionPane.showInputDialog(cadena);
    }
    //temporal
    public void registrarJuez(){
        int num=Integer.parseInt(JOptionPane.showInputDialog(null,"           ¿Cuantos jueces desea registrar?", "Proyecto Programación II UQ", JOptionPane.PLAIN_MESSAGE));
        for(int i=0;i<num;i++){
         Juez miJuez=new Juez();
         miJuez.setId(JOptionPane.showInputDialog(null,"                     Ingrese el id", "Proyecto Programación II UQ", JOptionPane.PLAIN_MESSAGE));
         miJuez.setNombre(JOptionPane.showInputDialog(null,"                 Ingrese el nombre del juez","Proyecto Programación II UQ", JOptionPane.PLAIN_MESSAGE));
         miJuez.setApellido(JOptionPane.showInputDialog(null,"                    Ingrese el apellido","Proyecto Programación II UQ", JOptionPane.PLAIN_MESSAGE));
         miJuez.setLicencia(JOptionPane.showInputDialog(null,"               Ingrese el numero de licencia","Proyecto Programación II UQ", JOptionPane.PLAIN_MESSAGE));
         miJuez.setEmail(JOptionPane.showInputDialog(null,"                     Ingrese el email","Proyecto Programación II UQ", JOptionPane.PLAIN_MESSAGE));
         miJuez.setNumeroCelular(JOptionPane.showInputDialog(null,"               Ingrese el numero de celular","Proyecto Programación II UQ", JOptionPane.PLAIN_MESSAGE));
         listajueces.add(miJuez);
        }
        
    }

    
}
