package ProyectoTorneo;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Equipo {
    private String nombreEquipo;
    private Persona representante;
    private int puntuacion;

    ArrayList<Jugador> listaJugadores = new ArrayList<>();
    ArrayList<Resultado>resultados=new ArrayList<>();

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
    
    public void adicionarResultado(Resultado r){
        resultados.add(r);
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
            codigoJugador = torneo.verificarMensajeEntrada("                Ingrese el id del jugador ");
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

    Menus menus = new Menus();
    //Jugador mijugador=new Jugador();

    public void ingresarEdadJugador(int edM,Jugador mijugador){
        int edad1;
        do {
            edad1 = Integer.parseInt(JOptionPane.showInputDialog(null,"             Ingrese la edad del jugador","Proyecto Programación II UQ", JOptionPane.PLAIN_MESSAGE));
            if (edad1 <= edM && edad1 > 16) {
                mijugador.setEdad(edad1);
                //se puede omitir el get en la siguiente linea
                JOptionPane.showMessageDialog(null, "La edad ingresada es " + mijugador.getEdad());
                break;
            } else {
                JOptionPane.showMessageDialog(null, "El jugador no cumple con los rangos de edad para este torneo");
            }

        }while(edad1>edM || edad1<16);
    }

    public void registrarJugador(int edM){
        
        Jugador miJugador=new Jugador();

        miJugador.setId(verificarJugador(listaJugadores));
        miJugador.setNombre(JOptionPane.showInputDialog(null, "                      Ingrese el nombre ", "Proyecto Programación II UQ", JOptionPane.PLAIN_MESSAGE));
        miJugador.setApellido(JOptionPane.showInputDialog(null, "                     Ingrese el apellido ", "Proyecto Programación II UQ", JOptionPane.PLAIN_MESSAGE));
        //miJugador.setEdad(Integer.parseInt(JOptionPane.showInputDialog(null, "                       Ingrese la edad ", "Proyecto Programación II UQ", JOptionPane.PLAIN_MESSAGE)));
        

        ingresarEdadJugador(edM,miJugador);

        miJugador.setEmail(JOptionPane.showInputDialog(null, "                      Ingrese el email ", "Proyecto Programación II UQ", JOptionPane.PLAIN_MESSAGE));
        miJugador.setNumeroCelular(JOptionPane.showInputDialog(null, "            Ingrese el numero de celular ", "Proyecto Programación II UQ", JOptionPane.PLAIN_MESSAGE));
        String op=JOptionPane.showInputDialog(null, "                              Género\n  1. Masculino\n  2. Femenino\n  3. Otro ", "Proyecto Programación II UQ", JOptionPane.PLAIN_MESSAGE);
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
        miJugador.setFechaNacimiento(torneo.guardarFecha("Ingrese la fecha de nacimiento en formato: año/mes/dia/hora/minuto"));
        //fecha de nacimiento
        this.listaJugadores.add(miJugador);

        JOptionPane.showMessageDialog(null, "¡Jugador registrado con éxito!");
        
    }
    
    public String entrada(String cadena){
        return JOptionPane.showInputDialog(cadena);
    }


    //temporal
    public Persona crearPersona(){
        Persona miPersona=new Persona();
        miPersona.setNombre(JOptionPane.showInputDialog(null, "                     Ingrese el nombre", "Proyecto Programación II UQ", JOptionPane.PLAIN_MESSAGE));
        miPersona.setApellido(JOptionPane.showInputDialog(null, "                     Ingrese el apellido", "Proyecto Programación II UQ", JOptionPane.PLAIN_MESSAGE));
        miPersona.setId(JOptionPane.showInputDialog(null, "                        Ingrese el ID", "Proyecto Programación II UQ", JOptionPane.PLAIN_MESSAGE));
        miPersona.setEmail(JOptionPane.showInputDialog(null, "                      Ingrese el email", "Proyecto Programación II UQ", JOptionPane.PLAIN_MESSAGE));
        miPersona.setNumeroCelular(JOptionPane.showInputDialog(null, "            Ingrese el número de celular ", "Proyecto Programación II UQ", JOptionPane.PLAIN_MESSAGE));
        
        return miPersona;
    }
    
    //Metodo para contar resultados
    public int[] result(){
        int [] retorno=new int[3];
        int g=0;
        int p=0;
        int e=0;
        for(int i=0;i<resultados.size();i++){
            if(resultados.get(i).equals(Resultado.GANADOR)){
                g=g+1;
            }
            else if(resultados.get(i).equals(Resultado.PERDEDOR)){
                p=p+1;
            }
            
            else{
                e=e+1;
            }
        }
        retorno[0]=g;
        retorno[1]=p;
        retorno[2]=e;
        return retorno;
    }

    //crear funcion crear jugador y validar si el jugador ya esta registrado

    @Override
    public String toString() {
        return"Equipo{" + "nombreEquipo=" + nombreEquipo + ", representante=" + representante + ", listaJugadores=" + listaJugadores + '}';
    }
}
