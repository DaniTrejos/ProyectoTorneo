package ProyectoTorneo;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Equipo {
    private String nombreEquipo;
    private Persona representante;
    private int puntuacion;

    ArrayList<Jugador> listaJugadores = new ArrayList<>();

    public Equipo(String nombreEquipo, Persona representante, int puntuacion) {
        this.nombreEquipo = nombreEquipo;
        this.representante = representante;
        this.puntuacion=puntuacion;
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

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
    
    

    /*public ArrayList<Jugador> getListaJugadores() {
        return listaJugadores;
    }

    public void setListaJugadores(ArrayList<Jugador> listaJugadores) {
        this.listaJugadores = listaJugadores;
    }*/

    /*public boolean validarJugador(Jugador jugador){
    boolean esta=false;

    for(int i=0;i<listaJugadores.size()&& esta == false; i++){
        if(jugador.getId().equals(listaJugadores.get(i).getId())){
            esta=true;
        }
    }
    return esta;
}
 */
    Torneo torneo = new Torneo();

    public String verificarJugador(ArrayList<Jugador> jugadores){
        String codigoJugador;
        boolean iDExistente;

        do {
            codigoJugador = torneo.verificarMensajeEntrada("Ingrese el id del jugador: ");
            // Verificar si el código del jugador ya existe en el ArrayList
            iDExistente = false;

            for (int i = 0; i < jugadores.size(); i++) {
                if (codigoJugador.equals(jugadores.get(i).getId())) {
                    iDExistente = true;
                    break;
                }
            }
            if (iDExistente) {
                JOptionPane.showMessageDialog(null, "¡Error! el jugador ya existe. Ingrese otro.");
            }
        } while (iDExistente);

        return codigoJugador;
    }
    
    public void registrarJugador(){
        
        Jugador miJugador=new Jugador();

        miJugador.setId(verificarJugador(listaJugadores));
        miJugador.setNombre(entrada("Ingrese el nombre: "));
        miJugador.setApellido(entrada("Ingrese el apellido: "));
        miJugador.setEdad(Integer.parseInt(entrada("Ingrese la edad: ")));
        miJugador.setEmail(entrada("Ingrese el email: "));
        miJugador.setNumeroCelular(entrada("Ingrese el numero de celular: "));
        String op=entrada("Género:\n1. Masculino\n2. Femenino\n3. Otro ");
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

        JOptionPane.showMessageDialog(null, "Jugador registrado con éxito ");
        listaJugadores.add(miJugador);
    }
    
    public String entrada(String cadena){
        return JOptionPane.showInputDialog(cadena);
    }


    //temporal
    public Persona crearPersona(){
        Persona miPersona=new Persona();
        miPersona.setNombre(entrada("Ingrese el nombre"));
        miPersona.setApellido(entrada("Ingrese el apellido"));
        miPersona.setId(entrada("Ingrese el ID"));
        miPersona.setEmail(entrada("Ingrese el email"));
        miPersona.setNumeroCelular(entrada("Ingrese el número de celular "));
        
        return miPersona;
    }

    //crear funcion crear jugador y validar si el jugador ya esta registrado

    @Override
    public String toString() {
        return"Equipo{" + "nombreEquipo=" + nombreEquipo + ", representante=" + representante + ", listaJugadores=" + listaJugadores + '}';
    }
}
