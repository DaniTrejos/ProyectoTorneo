package ProyectoTorneo;

public class Enfrentamientofinalizado extends Enfrentamiento{
    private Resultado resultado;

    public Enfrentamientofinalizado(Resultado resultado) {
        this.resultado = resultado;
    }

    public Enfrentamientofinalizado(){

    }

    public Resultado getResultado() {
        return resultado;
    }

    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
    }
}
