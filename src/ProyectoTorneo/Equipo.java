package ProyectoTorneo;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Equipo {
    private String nombreEquipo;
    private Persona representante;
    ArrayList<Jugador> listaJugadores = new ArrayList<>();

    public Equipo(String nombreEquipo, Persona representante) {
        this.nombreEquipo = nombreEquipo;
        this.representante = representante;
        //this.listaJugadores=listadoJugadores;
    }

    public Equipo(){

    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public Persona getRepresentante() {
        return representante;
    }

    public void setRepresentante(Persona representante) {
        this.representante = representante;
    }

    /*public ArrayList<Jugador> getListaJugadores() {
        return listaJugadores;
    }

    public void setListaJugadores(ArrayList<Jugador> listaJugadores) {
        this.listaJugadores = listaJugadores;
    }*/
    
    public void registrarJugador(){
        
        Jugador miJugador=new Jugador();
        miJugador.setId(entrada("ingrese el id"));
        miJugador.setNombre(entrada("ingrese el nombre"));
        miJugador.setApellido(entrada("ingrese el apellido"));
        miJugador.setEdad(Integer.parseInt(entrada("ingrese la edad")));
        miJugador.setEmail(entrada("ingrese el email"));
        miJugador.setNumeroCelular(entrada("ingrese el numero de celular"));
        String op=entrada("Genero: 1.Masculino  2.Femenino 3.Otro ");
        switch(op){
            case "1":
               miJugador.setGenero(Genero.MASCULINO);
               break;
            case "2":
               miJugador.setGenero(Genero.FEMENINO);
               break;
               
            case "3":
                miJugador.setGenero(Genero.OTRO);
                break;
        }
        
        //fecha de nacimiento
        
        
        if(validarJugador(miJugador)==false){
            listaJugadores.add(miJugador);
            JOptionPane.showMessageDialog(null, "Jugador registrado con exito ");
        }
        
        else{
            JOptionPane.showMessageDialog(null, "el jugador ya se encuentra registrado ");
        }
        
    }
    
    public String entrada(String cadena){
        return JOptionPane.showInputDialog(cadena);
    }
    
    public boolean validarJugador(Jugador jugador){
        boolean esta=false;
        
        for(int i=0;i<listaJugadores.size()&&esta==false;i++){
            if(jugador.getId().equals(listaJugadores.get(i).getId())){
                esta=true;
            }
        }
        return esta;
    }
    //temporal
    public Persona crearPersona(){
        Persona miPersona=new Persona();
        miPersona.setNombre(entrada("ingrese el nombre"));
        miPersona.setApellido(entrada("ingrese el apellido"));
        miPersona.setId(entrada("ingrese el ID"));
        miPersona.setEmail(entrada("ingrese el email"));
        miPersona.setNumeroCelular(entrada("ingrese el numero de celular "));
        
        return miPersona;
    }
    
    
    
    
    
    //crear funcion crear jugador y validar si el jugador ya esta registrado

    @Override
    public String toString() {
        return"Equipo{" + "nombreEquipo=" + nombreEquipo + ", representante=" + representante + ", listaJugadores=" + listaJugadores + '}';
    }
}
