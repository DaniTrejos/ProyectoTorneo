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
            String fechaInput;
            do {
                fechaInput = JOptionPane.showInputDialog(null, mensaje, "Proyecto Programación II UQ", JOptionPane.PLAIN_MESSAGE);

                if (fechaInput == null) {
                    JOptionPane.showMessageDialog(null, "No puede continuar hasta que ingrese el dato correspondiente", "¡Advertencia!", JOptionPane.WARNING_MESSAGE);
                    //break;
                }
            }while(fechaInput==null);

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

   /* public String verificarMensajeEntrada(String mensaje) {
        String entradaVerificada;

        do {
            entradaVerificada = JOptionPane.showInputDialog(null, mensaje, "Proyecto Programación II UQ", JOptionPane.PLAIN_MESSAGE);

            if (entradaVerificada == null) {
                int opcion = JOptionPane.showConfirmDialog(null, "¿Desea volver al menú principal?", "Confirmar", JOptionPane.YES_NO_OPTION);

                if (opcion == JOptionPane.YES_OPTION) {
                    // Si el usuario elige volver al menú principal, retorna null
                    return null;
                }
            }

        } while (entradaVerificada == null);

        return entradaVerificada;
    }

    */


    //Método para cerrar la ventana si el usuario o quien sea le da click en "cancelar" o en la "x" de cerrar
    public String verificarMensajeEntrada(String mensaje) {
        String entradaVerificada;
        do{
            entradaVerificada = JOptionPane.showInputDialog(null, mensaje, "Proyecto Programación II UQ", JOptionPane.PLAIN_MESSAGE);

            if (entradaVerificada == null) {
                JOptionPane.showMessageDialog(null, "No puede continuar hasta que ingrese el dato correspondiente", "Advertencia", JOptionPane.WARNING_MESSAGE);
                //return "0";
            }
        }while(entradaVerificada==null);
        return entradaVerificada;
    }

   /* public String verificarNombreTorneo(ArrayList<Torneo>torneos){
        String nombreTorneo;
        boolean nombreExistente;
        do {
            nombreTorneo = verificarMensajeEntrada("           Ingrese el nombre del torneo ");

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

    */


    public String verificarNombreTorneo(ArrayList<Torneo> torneos) {
        String nombreTorneo;

        do {
            nombreTorneo = verificarMensajeEntrada("            Ingrese el nombre del torneo");

            boolean nombreExistente = false;

            if (nombreTorneo == null || nombreTorneo.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un nombre para el torneo.");
                continue; // Vuelve al inicio del bucle para solicitar nuevamente el nombre.
            }

            for (Torneo torneo : torneos) {
                if (torneo.getNombreTorneo().equals(nombreTorneo)) {
                    nombreExistente = true;
                    break;
                }
            }

            if (nombreExistente) {
                JOptionPane.showMessageDialog(null, "¡Error! El nombre del torneo ya existe. Ingrese uno diferente.");
            } else {
                break;
            }
        } while (true);

        return nombreTorneo;
    }

    public int obtenerNumeroEquipos() {
        int numeroMaxEquipos;

        do {
            try {
                String input = verificarMensajeEntrada("    Ingrese el número máximo de equipos");

                numeroMaxEquipos = Integer.parseInt(input);

                // Validar si el número de equipos es 2 o más
                if (numeroMaxEquipos < 2) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese un número de equipos igual o mayor a 2.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }

            } catch (NumberFormatException e) {
                // Si la entrada no es un número, mostrar un mensaje de advertencia
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                numeroMaxEquipos = 0; // Establecer un valor por defecto para evitar problemas en el bucle
            }

        } while (numeroMaxEquipos < 2);

        return numeroMaxEquipos;
    }

    public int obtenerRangoEdad() {
        int numeroEdad;

        do {
            try {
                String input = verificarMensajeEntrada("                 Ingrese la edad máxima");

                numeroEdad = Integer.parseInt(input);

                // Validar si el número de equipos es 2 o más
                if (numeroEdad > 70 || numeroEdad < 16) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese una edad entre 16 y 70 años", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }

            } catch (NumberFormatException e) {
                // Si la entrada no es un número, mostrar un mensaje de advertencia
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                numeroEdad = 0; // Establecer un valor por defecto para evitar problemas en el bucle
            }

        } while (numeroEdad > 70 || numeroEdad < 16);

        return numeroEdad;
    }


    public int obtenerPrecioInscripcion() {
        int valorInscripcion;

        do {
            try {
                String input = verificarMensajeEntrada("         Ingrese el valor de la inscripcion");

                valorInscripcion = Integer.parseInt(input);


                if (valorInscripcion < 0) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese un valor igual o mayor a 0.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }

            } catch (NumberFormatException e) {
                // Si la entrada no es un número, mostrar un mensaje de advertencia
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                valorInscripcion = 0;
            }

        } while (valorInscripcion < 0);

        return valorInscripcion;
    }



    public void crearTorneo(ArrayList<Torneo>torneos){
        
        Torneo miTorneo=new Torneo();

        miTorneo.setNombreTorneo(verificarNombreTorneo(torneos));
        // torneo.setFechaInicioInscripcion(miTorneo.guardarFecha("Ingrese la f.n: "));
        //miTorneo.setNombreTorneo(verificarMensajeEntrada("Ingrese el nombre del torneo"));
        miTorneo.setNumeroMaxEquipo(obtenerNumeroEquipos());  //
        miTorneo.setEdadMaxJugadores(obtenerRangoEdad());  //
        miTorneo.setValorInscripcion(obtenerPrecioInscripcion());  //
        //miTorneo.setNumeroMaxEquipo(Integer.parseInt(verificarMensajeEntrada("    Ingrese el número máximo de equipos")));
        //miTorneo.setEdadMaxJugadores(Integer.parseInt(verificarMensajeEntrada("                Ingrese la edad Máxima")));
        //miTorneo.setValorInscripcion(Double.parseDouble(verificarMensajeEntrada("         Ingrese el valor de la inscripción")));

        String op1 = JOptionPane.showInputDialog(null,      "                       Tipo de Torneo\n  1. Local\n  2. Regional\n  3. Nacional\n  4. Mundial", "Proyecto Programación II UQ", JOptionPane.PLAIN_MESSAGE);

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
        String op2 = JOptionPane.showInputDialog(null,"                    Tipo de deporte\n   1. Futbol\n   2. Baloncesto\n   3. Volleyball\n   4. Hockey\n   5. Polo ", "Proyecto Programación II UQ", JOptionPane.PLAIN_MESSAGE);
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
        
        String op3 = JOptionPane.showInputDialog(null,"                Tipo de Enfrentamiento\n   1. Masculino\n   2. Femenino\n   3. Mixto ","Proyecto Programación II UQ", JOptionPane.PLAIN_MESSAGE);
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
        
        miTorneo.setFechaInicioInscripcion(guardarFecha(" Ingrese la fecha de inicio de las inscrpciones en formato año/mes/dia/hora/minuto"));
        miTorneo.setFechaFinalInscripcion(guardarFecha(" Ingrese la fecha de finalizacion de las inscripciones en formato año/mes/dia/hora/minuto"));
        miTorneo.setFechaInicioCompeticion(guardarFecha(" Ingrese la fecha de inicio del torneo en formato año/mes/dia/hora/minuto"));
        
        torneos.add(miTorneo);
        
    }
    
    public void crearEquipo(){
        //validar que el tamaño del arrayList sea menor al maximo permitido
        if(this.equipos.size()<this.numeroMaxEquipo){
            Equipo miEquipo=new Equipo();
            
            String name = JOptionPane.showInputDialog(null,"            Ingrese el nombre del equipo ","Proyecto Programación II UQ", JOptionPane.PLAIN_MESSAGE);
            boolean esta=false;
            //verificar que no existan equipos con el mismo nombre
            for(int i=0;i<this.equipos.size();i++){
                if(name.equals(this.equipos.get(i).getNombreEquipo())){
                    esta=true;
                }
            }

            if(esta==false){
                miEquipo.setNombreEquipo(name);
                JOptionPane.showMessageDialog(null,"Ingrese la informacion del representante");
                miEquipo.setRepresentante(miEquipo.crearPersona());
                //temporal
                int num=Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad de jugadores que desea añadir ", "Proyecto Programación II UQ", JOptionPane.PLAIN_MESSAGE));

                for(int i=0;i<num;i++){
                    miEquipo.registrarJugador();
                }
                equipos.add(miEquipo);
                JOptionPane.showMessageDialog(null,"Equipo registrado con exito "+ miEquipo.listaJugadores.toString(), "Proyecto Programación II UQ", JOptionPane.PLAIN_MESSAGE);
            
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
