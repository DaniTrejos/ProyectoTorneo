package ProyectoTorneo;

import javax.swing.JOptionPane;

public class Persona {
    private String id;
    private String nombre;
    private String Apellido;
    private String numeroCelular;
    private String email;

    public Persona(String nombre, String apellido, String numeroCelular, String email,String id) {
        this.nombre = nombre;
        Apellido = apellido;
        this.numeroCelular = numeroCelular;
        this.email = email;
        this.id=id;
    }

    public Persona(){

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String entrada(String cadena){
        return JOptionPane.showInputDialog(cadena);
    }
    
    public Persona crearPersona(){
        Persona miPersona=new Persona();
        miPersona.setNombre(entrada("ingrese el nombre"));
        miPersona.setApellido(entrada("ingrese el apellido"));
        miPersona.setId(entrada("ingrese el ID"));
        miPersona.setEmail(entrada("ingrese el email"));
        miPersona.setNumeroCelular(entrada("ingrese el numero de celular "));
        
        return miPersona;
    }
    
    
}
