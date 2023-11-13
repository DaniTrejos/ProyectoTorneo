package ProyectoTorneo;

public class Juez extends Persona{
    private String licencia;

    public Juez(String nombre, String apellido, String numeroCelular, String email,String id, String licencia) {
        super(nombre, apellido, numeroCelular, email,id);
        this.licencia = licencia;
    }

  

    public Juez(){

    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }
}
