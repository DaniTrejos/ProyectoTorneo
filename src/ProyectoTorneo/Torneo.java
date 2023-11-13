package ProyectoTorneo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Torneo {
    private String nombreTorneo;
    private int numeroMaxEquipo;
    private TipoDeporte tipoDeporte;
    private int numeroJugadores;

    private TipoTorneo tipotorneo;
    private double valorInscripcion;
    private int edadMaxJugadores;
    private LocalDateTime fechaInicioCompeticion;
    private LocalDateTime fechaInicioInscripcion;
    private LocalDateTime fechaFinalInscripcion;
    private TipoEnfrentamiento tipoE;
    //private Genero genero;
    ArrayList<Equipo>equipos=new ArrayList<>();
    ArrayList<Enfrentamiento>enfrentamientos=new ArrayList<>();
   
    public Torneo(){
    }

    public Torneo(String nombreTorneo, int numeroMaxEquipo, TipoDeporte tipoDeporte, int numeroJugadores, TipoTorneo tipotorneo, double valorInscripcion, int edadMaxJugadores, LocalDateTime fechaInicioCompeticion, LocalDateTime fechaInicioInscripcion, LocalDateTime fechaFinalInscripcion, TipoEnfrentamiento tipoE, ArrayList<Equipo> equipos) {
        this.nombreTorneo = nombreTorneo;
        this.numeroMaxEquipo = numeroMaxEquipo;
        this.tipoDeporte = tipoDeporte;
        this.numeroJugadores = numeroJugadores;
        this.tipotorneo = tipotorneo;
        this.valorInscripcion = valorInscripcion;
        this.edadMaxJugadores = edadMaxJugadores;
        this.fechaInicioCompeticion = fechaInicioCompeticion;
        this.fechaInicioInscripcion = fechaInicioInscripcion;
        this.fechaFinalInscripcion = fechaFinalInscripcion;
        this.tipoE = tipoE;
        this.equipos = equipos;
    }

            /*public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }*/

    public String getNombreTorneo() {
        return nombreTorneo;
    }

    public void setNombreTorneo(String nombreTorneo) {
        this.nombreTorneo = nombreTorneo;
    }

    public int getNumeroMaxEquipo() {
        return numeroMaxEquipo;
    }

    public void setNumeroMaxEquipo(int numeroMaxEquipo) {
        this.numeroMaxEquipo = numeroMaxEquipo;
    }

    public TipoDeporte getTipoDeporte() {
        return tipoDeporte;
    }

    public void setTipoDeporte(TipoDeporte tipoDeporte) {
        this.tipoDeporte = tipoDeporte;
    }

    public int getNumeroJugadores() {
        return numeroJugadores;
    }

    public void setNumeroJugadores(int numeroJugadores) {
        this.numeroJugadores = numeroJugadores;
    }

    public TipoTorneo getTipotorneo() {
        return tipotorneo;
    }

    public void setTipotorneo(TipoTorneo tipotorneo) {
        this.tipotorneo = tipotorneo;
    }

    public double getValorInscripcion() {
        return valorInscripcion;
    }

    public void setValorInscripcion(double valorInscripcion) {
        this.valorInscripcion = valorInscripcion;
    }

    public int getEdadMaxJugadores() {
        return edadMaxJugadores;
    }

    public void setEdadMaxJugadores(int edadMaxJugadores) {
        this.edadMaxJugadores = edadMaxJugadores;
    }

    public LocalDateTime getFechaInicioCompeticion() {
        return fechaInicioCompeticion;
    }

    public void setFechaInicioCompeticion(LocalDateTime fechaInicioCompeticion) {
        this.fechaInicioCompeticion = fechaInicioCompeticion;
    }

    public LocalDateTime getFechaInicioInscripcion() {
        return fechaInicioInscripcion;
    }

    public void setFechaInicioInscripcion(LocalDateTime fechaInicioInscripcion) {
        this.fechaInicioInscripcion = fechaInicioInscripcion;
    }

    public LocalDateTime getFechaFinalInscripcion() {
        return fechaFinalInscripcion;
    }

    public void setFechaFinalInscripcion(LocalDateTime fechaFinalInscripcion) {
        this.fechaFinalInscripcion = fechaFinalInscripcion;
    }

    public TipoEnfrentamiento getTipoE() {
        return tipoE;
    }

    public void setTipoE(TipoEnfrentamiento tipoE) {
        this.tipoE = tipoE;
    }

    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(ArrayList<Equipo> equipos) {
        this.equipos = equipos;
    }

           /* public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(ArrayList<Equipo> equipos) {
        this.equipos = equipos;
    }*/

    public String entrada(String cadena){
        return JOptionPane.showInputDialog(cadena);
    }

    //Método para guardar las fechas ingresadas
    public LocalDateTime guardarFecha(String mensaje) {
        LocalDateTime fechaHoraEspecifica = null;
        boolean entradaValida = true;

        while (entradaValida) {
            String fechaInput = JOptionPane.showInputDialog(mensaje);

            if (fechaInput == null) {
                JOptionPane.showMessageDialog(null, "Usted decidió continuar sin ingresar ningún dato", "¡Advertencia!", JOptionPane.WARNING_MESSAGE);
                break;
            }

            String[] divPartes = fechaInput.split("/");

            if (divPartes.length == 5) {
                try {
                    int anio = Integer.parseInt(divPartes[0]);
                    int mes = Integer.parseInt(divPartes[1]);
                    int dia = Integer.parseInt(divPartes[2]);
                    int hora = Integer.parseInt(divPartes[3]);
                    int minuto = Integer.parseInt(divPartes[4]);

                    fechaHoraEspecifica = LocalDateTime.of(anio, mes, dia, hora, minuto);
                    entradaValida = false;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Ingrese valores númericos enteros.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Formato de fecha y hora no válido.");
            }
        }
        return fechaHoraEspecifica;
    }


    //Método para cerrar la ventana si el usuario o quien sea le da click en "cancelar" o en la "x" de cerrar
    public String verificarMensajeEntrada(String mensaje) {
        String entradaVerificada = JOptionPane.showInputDialog(mensaje);

        if (entradaVerificada == null) {
            JOptionPane.showMessageDialog(null, "Usted decidió continuar sin ingresar ningún dato", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return "0";
        }
        return entradaVerificada;
    }

    public String verificarNombreTorneo(ArrayList<Torneo>torneos){
        String nombreTorneo;
        boolean nombreExistente;
        do {
            nombreTorneo = verificarMensajeEntrada("Ingrese el nombre del torneo: ");
            // Verificar si el nombre del torneo ya existe en el ArrayList
            nombreExistente = false;

            for (int i = 0; i < torneos.size(); i++) {
                if (torneos.get(i).getNombreTorneo().equals(nombreTorneo)) {
                    nombreExistente = true;
                    break;
                }
            }
            if (nombreExistente) {
                JOptionPane.showMessageDialog(null, "¡Error! El nombre del torneo ya existe. Ingrese uno diferente.");
            }
        } while (nombreExistente);

        return nombreTorneo;
    }

    public void crearTorneo(ArrayList<Torneo>torneos){
        
        Torneo miTorneo=new Torneo();

        miTorneo.setNombreTorneo(verificarNombreTorneo(torneos));
        //miTorneo.setNombreTorneo(verificarMensajeEntrada("Ingrese el nombre del torneo"));
        miTorneo.setNumeroMaxEquipo(Integer.parseInt(verificarMensajeEntrada("Ingrese el número máximo de equipos")));
        miTorneo.setEdadMaxJugadores(Integer.parseInt(verificarMensajeEntrada("Ingrese la edad Máxima")));
        miTorneo.setValorInscripcion(Double.parseDouble(verificarMensajeEntrada("Ingrese el valor de la inscripción")));

        String op1 = entrada(      "Tipo de Torneo\n1. Local\n2. Regional\n3. Nacional\n4. Mundial");
        switch(op1){
            case "1":
                miTorneo.setTipotorneo(TipoTorneo.LOCAL);
                break;
            case "2":
                miTorneo.setTipotorneo(TipoTorneo.REGIONAL);
                break;
            case "3":
                miTorneo.setTipotorneo(TipoTorneo.NACIONAL);
                break;
            case "4":
                miTorneo.setTipotorneo(TipoTorneo.MUNDIAL);
                break;
        }

        //Modificar con menú
        String op2=entrada("     Tipo de deporte\n1. Futbol\n2. Baloncesto\n3. Volleyball\n4. Hockey\n5. Polo ");
        switch(op2){
            case "1":
                miTorneo.setTipoDeporte(TipoDeporte.FUTBOL);
                break;
            case "2":
                miTorneo.setTipoDeporte(TipoDeporte.BALONCESTO);
                break;
            case "3":
                miTorneo.setTipoDeporte(TipoDeporte.VOLLEYBALL);
                break;
            case "4":
                miTorneo.setTipoDeporte(TipoDeporte.HOCKEY);
                break;
                
            case "5":
                miTorneo.setTipoDeporte(TipoDeporte.POLO);
                break;
        }
        
        String op3=entrada("    Tipo de Enfrentamiento\n1. Maculino\n2. Femenino\n3. Mixto ");
        switch(op3){
            case "1":
                miTorneo.setTipoE(TipoEnfrentamiento.MASCULINO);
                break;
            case "2":
                miTorneo.setTipoE(TipoEnfrentamiento.FEMENINO);
                break;
            case "3":
                miTorneo.setTipoE(TipoEnfrentamiento.MIXTO);
                break;
            
        }
        
        miTorneo.setFechaInicioInscripcion(guardarFecha("ingrese la fecha de inicio de las inscrpciones con formato año/mes/dia/hora/minuto"));
        miTorneo.setFechaFinalInscripcion(guardarFecha("ingrese la fecha de finalizacion de las inscripciones con formato año/mes/dia/hora/minuto"));
        miTorneo.setFechaInicioCompeticion(guardarFecha("ingrese la fecha de inicio del torneo con formato año/mes/dia/hora/minuto"));
        
        torneos.add(miTorneo);
        
    }
    
    public void crearEquipo(){
        //validar que el tamaño del arrayList sea menor al maximo permitido
        if(this.equipos.size()<this.numeroMaxEquipo){
            Equipo miEquipo=new Equipo();
            
            String name=entrada("ingrese el nombre del equipo ");
            boolean esta=false;
            //verificar que no existan equipos con el mismo nombre
            for(int i=0;i<this.equipos.size();i++){
                if(name.equals(this.equipos.get(i).getNombreEquipo())){
                    esta=true;
                }
            }

            if(esta==false){
                miEquipo.setNombreEquipo(name);
                JOptionPane.showMessageDialog(null, "Ingrese la informacion del representante");
                miEquipo.setRepresentante(miEquipo.crearPersona());
                //temporal
                int num=Integer.parseInt(entrada("ingrese la cantidad de jugadores que desea añadir "));

                for(int i=0;i<num;i++){
                    miEquipo.registrarJugador();
                }
                equipos.add(miEquipo);
                JOptionPane.showMessageDialog(null,"Equipo registrado con exito "+ miEquipo.listaJugadores.toString());
            
             }
            
            else{
                JOptionPane.showMessageDialog(null,"Ya existe un equipo registrado con el nombre que ingreso, intente nuevamente con otro nombre ");
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"No queda espacio para este torneo ");
        }
        
    }
    
}
