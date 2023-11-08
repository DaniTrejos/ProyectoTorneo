package ProyectoTorneo;

import java.util.ArrayList;
import java.util.Date;

public class Jugador extends Persona{
    private Date fechaNacimiento = new Date();
    private Genero genero;
    private int edad;

    

    public Jugador(String nombre, String apellido, String numeroCelular, String email,String id, Date fechaNacimiento, Genero genero, int edad) {
        super(nombre, apellido, numeroCelular, email,id);
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.edad = edad;
        
    }

    public Jugador(){

    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Jugador{" + "fechaNacimiento=" + fechaNacimiento + ", genero=" + genero + ", edad=" + edad + '}';
    }
    
    

   
}
