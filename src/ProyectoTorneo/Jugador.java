package ProyectoTorneo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class Jugador extends Persona{
    private LocalDateTime fechaNacimiento;
    private Genero genero;
    private int edad;

    public Jugador(LocalDateTime fechaNacimiento, Genero genero, int edad, String nombre, String apellido, String numeroCelular, String email, String id) {
        super(nombre, apellido, numeroCelular, email, id);
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.edad = edad;
    }

    public LocalDateTime getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
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

    public Jugador() {
    }

    
}
