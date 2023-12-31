package ProyectoTorneo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;

public class Menus{

    Torneo miTorneo = new Torneo();
    ArrayList<Torneo> listaTorneos = new ArrayList<>();
    
    
    //Datos quemados
    public void datos(){
        Torneo t=new Torneo("torneo",3,TipoDeporte.FUTBOL,2,TipoTorneo.LOCAL,12.0,20,LocalDateTime.of(2023, Month.MARCH, 17, 3, 30),LocalDateTime.of(2023, Month.MARCH, 12, 3, 30),LocalDateTime.of(2023, Month.MARCH, 16, 3, 30),TipoEnfrentamiento.MASCULINO);
        Persona p=new Persona("name","apellido","345","email","345");
        Equipo e1=new Equipo("equipo",p,3);
        e1.listaJugadores.add(new Jugador(LocalDateTime.of(2022, Month.MARCH, 6, 6, 10),Genero.MASCULINO,13,"juan","apellido","678","email","567"));
        e1.listaJugadores.add(new Jugador(LocalDateTime.of(2022, Month.JULY, 10, 7, 10),Genero.MASCULINO,15,"jose","apellido","978","email","0067"));
        Equipo e2=new Equipo("equipoDos",p,5);
        t.equipos.add(e1);
        t.equipos.add(e2);
         
        listaTorneos.add(t);
    }
    
    

    public void menuPrincipal() {

        JOptionPane.showMessageDialog(null, "BIENVENIDO A LOS JUEGOS UNIVERSITARIOS 2023", "Proyecto Programación II UQ", JOptionPane.PLAIN_MESSAGE);

        int option = 0; // Inicializamos la opción a un valor válido

        while (option != 8) {
            try {
                String input = JOptionPane.showInputDialog(null,
                        """
                                                  MENÚ PRINCIPAL
                                1. Crear torneos
                                2. Crear equipos
                                3. Agendar enfrentamientos
                                4. Información de fechas
                                5. Enfrentamientos
                                6. Tabla general
                                7. Consultar lista de jugadores por equipo
                                8. Salir""".indent(4), "Proyecto Programación II UQ", JOptionPane.PLAIN_MESSAGE);


                if (input == null) {
                    break;
                }
                option = Integer.parseInt(input);

                if (option > 0 && option <= 8) {
                    switch (option) {
                        case 1:
                            miTorneo.crearTorneo(listaTorneos);
                            break;
                        case 2:
                            validarExistenciaTorneo();
                            break;
                        case 3:
                            agendarEnfrentamiento();
                            break;
                        case 4:
                            menuConsultarFechas();
                            break;
                        case 5:
                            mostrarInformacionEnfrentamientos();
                            break;
                        case 6:
                            //mostrarTablaGeneralTorneosIndividuales();
                            mostrarResultados();
                            
                            break;
                        case 7:
                            listaJugadores();
                            break;
                            
                        case 8:
                            
                            break;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Elija una opción de 1-8","Proyecto Programación II UQ", JOptionPane.PLAIN_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese caracteres de tipo numérico","Proyecto Programación II UQ", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }

    public void validacionTorneoModificarFechas(){
        String nombreTorneo = JOptionPane.showInputDialog(null,"Ingrese el nombre del torneo al cual quiere consultarle las fechas","Proyecto Programación II UQ", JOptionPane.PLAIN_MESSAGE);
        boolean torneoEncontrado = false;
        for (int i = 0; i < listaTorneos.size(); i++) {
            Torneo torneo = listaTorneos.get(i);
            if (nombreTorneo.equals(torneo.getNombreTorneo())) {
                menuModificarFechas(torneo);
                torneoEncontrado = true;
                break;
            }
        }
        if (!torneoEncontrado) {
            JOptionPane.showMessageDialog(null, "No se encontró un torneo con ese nombre","Proyecto Programación II UQ", JOptionPane.PLAIN_MESSAGE);
        }
    }

    public void menuConsultarFechas(){
        int option = 0;

        while (option != 3) {
            try {
                String input = JOptionPane.showInputDialog(null,"     1. Consultar Fechas \n     2."+
                        " Modificar Fechas \n     3. Atrás","Proyecto Programación II UQ", JOptionPane.PLAIN_MESSAGE);

                if (input == null) {
                    break;
                }
                option = Integer.parseInt(input);
                if (option > 0 && option <= 3) {
                    switch (option) {
                        case 1:
                            consultarFechas();
                            //JOptionPane.showMessageDialog(null, "Fechas consultadas");
                            break;
                        case 2:
                            validacionTorneoModificarFechas();
                            //Primero debo de preguntar a que torneo le deseo modificar las fechas, buscarlo ahí si modificar las fechas dentro de él
                            //menuModificarFechas();
                            //JOptionPane.showMessageDialog(null, "Fechas modificadas");
                            break;
                        case 3:
                            break;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Elija una opción de 1-3");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese caracteres de tipo numérico");
            }
        }
    }

    //metodo para evitar repiticion dentro del menu

    public void menuModificarFechas(Torneo torneo){
        int option = 0;

        while (option != 4) {
            try {
                String input = JOptionPane.showInputDialog(null, "     1. Inicio de Inscripciones \n     2."+
                        " Cierre de Inscripciones \n     3. Inicio del Torneo\n     4. Atras", "Proyecto Programación II UQ", JOptionPane.PLAIN_MESSAGE);

                if (input == null) {
                    break;
                }
                option = Integer.parseInt(input);
                if (option > 0 && option <= 4) {
                    switch (option) {
                        case 1:
                            torneo.setFechaInicioInscripcion(miTorneo.guardarFecha("Ingrese la nueva fecha en formato año/mes/día/hora/minuto"));
                            //JOptionPane.showMessageDialog(null, "Fechas de inicio de inscripciones modificadas");
                            // He pasado torneo (nombre del torneo encontrado) por parametro, para modificar aquí adentro el inicio de inscripción sin tener que ingresar fechas a modificar
                            /*int resultado = modificarFechasTorneo("Ingrese la fecha que desea modificar: ", 1);

                            if (resultado == -1) {
                                JOptionPane.showMessageDialog(null, "No se ha encontrado la fecha que quiere modificar");
                            } else {
                                LocalDateTime nuevaFecha1 = miTorneo.guardarFecha("Ingrese la nueva fecha en formato año/mes/día/hora/minuto");

                                //Accedo al objeto Torneo específico en el ArrayList y establezco la nueva fecha
                                listaTorneos.get(resultado).setFechaInicioInscripcion(nuevaFecha1);
                               JOptionPane.showMessageDialog(null, "Fechas de inicio de inscripciones modificadas");
                           }

                             */
                            break;

                        case 2:
                            torneo.setFechaFinalInscripcion(miTorneo.guardarFecha("Ingrese la nueva fecha en formato año/mes/día/hora/minuto"));
                            JOptionPane.showMessageDialog(null, "Fechas de finalización de inscripciones modificadas");
                            /*int resultado2 = modificarFechasTorneo("Ingrese la fecha que desea modificar: ", 2);

                            if (resultado2 == -1) {
                                JOptionPane.showMessageDialog(null, "No se ha encontrado la fecha que quiere modificar");
                            } else {
                                LocalDateTime nuevaFecha = miTorneo.guardarFecha("Ingrese la nueva fecha en formato año/mes/día/hora/minuto");

                                // Accedo al objeto Torneo específico en el ArrayList y establezco la nueva fecha
                                listaTorneos.get(resultado2).setFechaFinalInscripcion(nuevaFecha);
                                JOptionPane.showMessageDialog(null, "Fechas de finalización de inscripciones modificadas");
                            }

                             */
                            break;

                        case 3:
                            torneo.setFechaInicioCompeticion(miTorneo.guardarFecha("Ingrese la nueva fecha en formato año/mes/día/hora/minuto"));
                            JOptionPane.showMessageDialog(null, "Fechas de inicio del torneo modificadas");
                            /*int resultado3 = modificarFechasTorneo("Ingrese la fecha que desea modificar: ", 3);

                            if (resultado3 == -1) {
                                JOptionPane.showMessageDialog(null, "No se ha encontrado la fecha que quiere modificar");
                            } else {
                                LocalDateTime nuevaFecha = miTorneo.guardarFecha("Ingrese la nueva fecha en formato año/mes/día/hora/minuto");
                                listaTorneos.get(resultado3).setFechaInicioCompeticion(nuevaFecha);
                                JOptionPane.showMessageDialog(null, "Fechas de inicio del torneo modificadas");
                            }

                             */
                            break;

                        case 4:
                            break;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Elija una opción de 1-4");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese caracteres de tipo numérico");
            }
        }
    }

   /* public void mostrarTablaGeneralTorneosIndividuales(){
        int option = 0;

        while (option != 6) {
            try {
                String input = JOptionPane.showInputDialog(null,"     1. Futbol \n     2. Baloncesto\n     3."+
                        " Volleyball\n     4. Hockey\n     5.Polo\n     6. Atras","Proyecto Programación II UQ", JOptionPane.PLAIN_MESSAGE);
                if (input == null) {

                    break;
                }
                option = Integer.parseInt(input);

                if (option > 0 && option <= 6) {
                    switch (option) {
                        case 1:
                            mostrarTablaGeneralFutbol();
                            break;
                        case 2:
                            JOptionPane.showMessageDialog(null, "Baloncesto");
                            break;
                        case 3:
                            JOptionPane.showMessageDialog(null, "Volleyball");
                            break;
                        case 4:
                            JOptionPane.showMessageDialog(null, "Hockey");
                            break;
                        case 5:
                            JOptionPane.showMessageDialog(null, "Polo");
                            break;
                        case 6:
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Elija una opción de 1-6");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese caracteres de tipo numérico");
            }
        }
    }*/

    /*public static void mostrarTablaGeneralFutbol() {
        Object[][] data = {
                {"Equipo A", 2, "Equipo B", 1},
                {"Equipo C", 0, "Equipo D", 2},
                {"Equipo E", 1, "Equipo F", 1}
        };

        String[] columnNames = {"Equipo Local", "Puntos Local", "Equipo Visitante", "Puntos Visitante"};
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model);
        table.setDefaultRenderer(Object.class, new ProyectoTorneo.Menus.TableCellRenderer());
        JScrollPane scrollPane = new JScrollPane(table);
        JOptionPane.showMessageDialog(null, scrollPane, "Marcadores de los enfrentamientos", JOptionPane.PLAIN_MESSAGE);
    }

    public static class TableCellRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            int golesLocal = (int) table.getValueAt(row, 1);
            int golesVisitante = (int) table.getValueAt(row, 3);
            if (golesLocal > golesVisitante) {
                c.setBackground(new Color(95, 225, 78));
            } else if (golesLocal < golesVisitante) {
                c.setBackground(new Color(231, 123, 147));
            } else {
                c.setBackground(new Color(239, 239, 151));
            }
            return c;
        }
    }*/

    public void mostrarInformacionEnfrentamientos(){

        int option = 0;

        while (option != 5) {
            try {
                String input = JOptionPane.showInputDialog(null,"     1. Agregar resultados \n     2. Consultar Participación de los Equipos \n     3."+
                        " Consultar Participación de los Jueces  \n     4. Aplazar enfrentamientos \n     5. Atrás", "Proyecto Programación II UQ", JOptionPane.PLAIN_MESSAGE);

                if (input == null) {
                    break;
                }

                option = Integer.parseInt(input);

                if (option > 0 && option <= 5) {
                    switch (option) {
                        case 1:
                            //JOptionPane.showMessageDialog(null, "Aquí debe de escoger el deporte y luego automaticamente"+
                                  //  " se guardan los resultados con la la clase random");
                            String buscar=miTorneo.entrada("Ingrese el id del enfrentamiento donde desea registrar los resultados");
                            for(int i=0;i<listaTorneos.size();i++){
                                for(int j=0;j<listaTorneos.get(i).enfrentamientos.size();j++){
                                    if(listaTorneos.get(i).enfrentamientos.get(j).getId().equals(buscar)){
                                        listaTorneos.get(i).enfrentamientos.get(j).registrarResultado();
                                    }
                                }
                            }
                            break;
                        case 2:
                            //JOptionPane.showMessageDialog(null, "Información de equipos consultada");
                            ArrayList<Enfrentamiento>en=buscarParticipacionJ();
                            mostrarTablaEnfrentamientos(en);
                            
                            break;
                        case 3:

                            //JOptionPane.showMessageDialog(null, "Información de los jueces consultada");
                            ArrayList<Enfrentamiento>e=buscarParticipacionJu();
                            mostrarTablaEnfrentamientos(e);
                            break;
                        case 4:
                            aplazarEnfrentamiento();
                            break;
                        case 5:
                            break;
                        
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Elija una opción de 1-5");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese caracteres de tipo numérico");
            }

        }

    }



    public void validarExistenciaTorneo(){
        if(listaTorneos.size()<1){
            JOptionPane.showMessageDialog(null, "No se puede crear el equipo porque no hay torneos existentes");
        }
        else{
            //Buscar el torneo  donde se desea registrar el equipo
            String s = JOptionPane.showInputDialog(null,"   Ingrese el nombre del torneo en el que desea registrar el equipo ","Proyecto Programación II UQ", JOptionPane.PLAIN_MESSAGE);
            boolean c = false;
            for(int i = 0; i < listaTorneos.size(); i++){
                if(listaTorneos.get(i).getNombreTorneo().equals(s)){
                    listaTorneos.get(i).crearEquipo();
                    c = true;
                }
            }
            if(c==false){
                JOptionPane.showMessageDialog(null, "No se encontraron resultados ","Proyecto Programación II UQ", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }
    
    public TipoDeporte verificarTD (int entrada){
        TipoDeporte retorno=null;
        switch(entrada){
            case 1:
                retorno=TipoDeporte.FUTBOL;
                break;
            case 2:
                retorno=TipoDeporte.BALONCESTO;
                break;
            
            case 3:
                retorno=TipoDeporte.HOCKEY;
                break;
                
            case 4:
                retorno=TipoDeporte.POLO;
                break;
            case 5:
                retorno=TipoDeporte.VOLLEYBALL;
                break;
        }
        return retorno;
        
    }
    
    public TipoEnfrentamiento tipoE(int entrada){
        TipoEnfrentamiento retorno=null;
        switch(entrada){
            case 1:
                retorno=TipoEnfrentamiento.MASCULINO;
                break;
                
            case 2:
                retorno=TipoEnfrentamiento.FEMENINO;
                break;
                
            case 3:
                retorno=TipoEnfrentamiento.MIXTO;
                break;
        }
        return retorno;
    }
    
    

    public void consultarFechas() {
        if (listaTorneos.size()<1) {
            JOptionPane.showMessageDialog(null, "No hay torneos disponibles para consultar fechas","Proyecto Programación II UQ", JOptionPane.PLAIN_MESSAGE);
        } else {
            String nombreTorneo = JOptionPane.showInputDialog(null, "Ingrese el nombre del torneo al cual quiere consultarle las fechas","Proyecto Programación II UQ", JOptionPane.PLAIN_MESSAGE);
            boolean torneoEncontrado = false;

            for (int i = 0; i < listaTorneos.size(); i++) {
                Torneo torneo = listaTorneos.get(i);
                if (nombreTorneo.equals(torneo.getNombreTorneo())) {
                    JOptionPane.showMessageDialog(null,
                            "                       Fechas del Torneo " + torneo.getNombreTorneo() + "\n\n" +
                                    "  Fecha inicio de la inscripción: " + torneo.getFechaInicioInscripcion().toLocalDate() +
                                    "\n  Hora de inicio: " + torneo.getFechaInicioInscripcion().toLocalTime() + "\n" +
                                    "------------------------------------------------------------------------" + "\n"+
                                    "  Fecha finalización de la inscripción: " + torneo.getFechaFinalInscripcion().toLocalDate() +
                                    "\n  Hora de cierre: " + torneo.getFechaFinalInscripcion().toLocalTime() + "\n" +
                                    "------------------------------------------------------------------------" + "\n" +
                                    "  Fecha inicio del torneo: " + torneo.getFechaInicioCompeticion().toLocalDate() +
                                    "\n  Hora de inicio: " + torneo.getFechaInicioCompeticion().toLocalTime(),"Proyecto Programación II UQ", JOptionPane.PLAIN_MESSAGE);
                    torneoEncontrado = true;
                    break;
                }
            }
            if (!torneoEncontrado) {
                JOptionPane.showMessageDialog(null, "No se encontró un torneo con ese nombre","Proyecto Programación II UQ", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }

    public void obtenerFechaTorneo(ArrayList<Torneo> listaTorneos){
        if(listaTorneos.size()<1){
            JOptionPane.showMessageDialog(null, "No hay fechas disponibles para modificar","Proyecto Programación II UQ", JOptionPane.PLAIN_MESSAGE);
        }
        else{
            //menuModificarFechas();
        }
    }

    /*public int modificarFechasTorneo(String mensaje, int condicion){
        LocalDateTime fechaABuscar = miTorneo.guardarFecha(mensaje);

        int indice = -1; //inicializo en este valor para saber más adelante si la fecha se encontró o no
        for (int i = 0; i < listaTorneos.size(); i++) {
            if(condicion==1){
                LocalDateTime fecha = listaTorneos.get(i).getFechaInicioInscripcion(); // Extraigo la fecha para compararla
                if (fecha.equals(fechaABuscar)) {
                    indice = i; // Encuentro la fecha y rompo el ciclo
                    break;
                }
            }else if (condicion==2){
                LocalDateTime fecha = listaTorneos.get(i).getFechaFinalInscripcion(); // Extraigo la fecha para compararla
                if (fecha.equals(fechaABuscar)) {
                    indice = i; // Encuentro la fecha y rompo el ciclo
                    break;
                }
            }
            else {
                LocalDateTime fecha = listaTorneos.get(i).getFechaInicioCompeticion(); // Extraigo la fecha para compararla
                if (fecha.equals(fechaABuscar)) {
                    indice = i; // Encuentro la fecha y rompo el ciclo
                    break;
                }
            }

        }
        return indice;
    }

     */

    
   
    //Temporal no se donde mas crear este metodo
    
     public void agendarEnfrentamiento(){
            Enfrentamiento enfren=new Enfrentamiento();
           // String buscar=miTorneo.entrada("Ingrese el nombre del torneo donde desea registrar el enfretamiento");
         String buscar=JOptionPane.showInputDialog(null,"  Ingrese el nombre del torneo donde desea registrar el enfretamiento","Proyecto Programación II UQ", JOptionPane.PLAIN_MESSAGE);
            boolean c=false;
            for(int i=0;i<listaTorneos.size()&&c==false;i++){
              //Buscar el torneo donde se registrara el enfrentamiento
            if(listaTorneos.get(i).getNombreTorneo().equals(buscar)){
                int op=Integer.parseInt(JOptionPane.showInputDialog(null,"               Elija el tipo de deporte\n  1. Futbol\n  2. Baloncesto\n  3. Hockey \n  4. Polo \n  5. Volleyball","Proyecto Programación II UQ", JOptionPane.PLAIN_MESSAGE));
                //verificar que el tipo de deporte sea el mismo del torneo, si se cumple procede a crear el objeto
                if(verificarTD(op)==listaTorneos.get(i).getTipoDeporte()){
                    
                    //verificar que el el tipo de enfrentamiento corresponda al del torneo
                  int op1=Integer.parseInt(JOptionPane.showInputDialog(null,"               Tipo de Enfrentamiento\n  1. Masculino\n  2. Femenino\n  3. Mixto","Proyecto Programación II UQ", JOptionPane.PLAIN_MESSAGE));
                  if(tipoE(op1)==listaTorneos.get(i).getTipoE()){
                      
                        enfren.setId(JOptionPane.showInputDialog(null,"           Ingrese el id del enfrentamiento","Proyecto Programación II UQ", JOptionPane.PLAIN_MESSAGE));
                        enfren.setFechaEndrentamiento(miTorneo.guardarFecha("Ingrese la fecha de incio del enfrentamiento con formato año/mes/dia/hora/minuto"));
                        enfren.setLugar(JOptionPane.showInputDialog(null,"           Ingrese el lugar donde se realizará","Proyecto Programación II UQ", JOptionPane.PLAIN_MESSAGE));
                        enfren.setTipoDeporte(verificarTD(op));
                        enfren.setTipoEnfrentamiento(tipoE(op1));
                        //Registrar los equipos que participaran buscandolos por el nombre del equipo
                        int num=Integer.parseInt(JOptionPane.showInputDialog(null,"         ¿Cuantos equipos desea registrar?","Proyecto Programación II UQ", JOptionPane.PLAIN_MESSAGE));
                        for(int j=0;j<num;j++){
                            //se busca el nombre del equipo en la lista de equipos del objeto en la posicion del arraylist torneos
                            String b=JOptionPane.showInputDialog(null,"        Ingrese el nombre del equipo que desea agregar","Proyecto Programación II UQ", JOptionPane.PLAIN_MESSAGE);
                            boolean encontrada=false;
                            for(int k=0;k<listaTorneos.get(i).equipos.size();k++){
                                //Comparar si el nombre suministrado exista en caso de que si lo agrega a la lista de equipos en la clase enfrentamiento
                                if(listaTorneos.get(i).equipos.get(k).getNombreEquipo().equals(b)){
                                    enfren.listaEquipos.add(listaTorneos.get(i).equipos.get(k));
                                    encontrada=true;
                                }
                            }
                        
                        if(encontrada==false){
                            JOptionPane.showMessageDialog(null, "No se encontro el nombre del equipo");
                            if(j>0){
                                j=j-1;
                            }
                        }
                    
                    }
                    
                    //Estado del enfrentamiento se compara la fecha ingresada con la fecha actual
                    
                    if(enfren.getFechaEndrentamiento().isBefore(LocalDateTime.now())){
                        enfren.setEstadoEnfrentamiento(EstadoEnfrentamiento.PENDIENTE);
                    }
                    else if(LocalDateTime.now().equals(enfren.getFechaEndrentamiento())){
                        enfren.setEstadoEnfrentamiento(EstadoEnfrentamiento.ENJUEGO);
                    }
                  
                    //Registrar jueces para este enfrentamiento
                    
                    enfren.registrarJuez();
                    
                    //Adicionar enfrentamiento al torneo
                    listaTorneos.get(i).enfrentamientos.add(enfren);
                  }
                  
                  else{
                      JOptionPane.showMessageDialog(null, "El tipo de enfrentamiento no coincide con el tipo del torneo ");
                      c=true;
                  }

                }
                else{
                    c=true;
                    JOptionPane.showMessageDialog(null, "El tipo de deporte no coincide con el tipo de deporte del torneo");
                }
                c=true;
                
            }
        }
            
          if(c==false){
              JOptionPane.showMessageDialog(null, "No se encontro resultados para el torneo que busca ");
          }
    }
     
     //metodo para aplazar enfrentamiento
     
     public void aplazarEnfrentamiento(){
         String buscar=JOptionPane.showInputDialog(null,"         Ingrese el Id del enfrentamiento que desea aplazar","Proyecto Programación II UQ", JOptionPane.PLAIN_MESSAGE);
         boolean control=false;
         
         //buscar enfrentamiento
         for(int i=0;i<listaTorneos.size();i++){
             for(int j=0;j<listaTorneos.get(i).enfrentamientos.size();j++){
                 if(listaTorneos.get(i).enfrentamientos.get(j).getId().equals(buscar)){
                     String razon=JOptionPane.showInputDialog(null,"     Ingrese el motivo por el cual se aplazar el enfrentamiento","Proyecto Programación II UQ", JOptionPane.PLAIN_MESSAGE);
                     listaTorneos.get(i).enfrentamientos.get(j).setEstadoEnfrentamiento(EstadoEnfrentamiento.APLAZADO);
                     listaTorneos.get(i).enfrentamientos.get(j).setFechaEndrentamiento(miTorneo.guardarFecha("Ingrese la nueva fecha de inicio en el formato: año/mes/dia/hora/minuto"));
                     control=true;
                     JOptionPane.showMessageDialog(null, "El enfrentamiento se aplazo con exito ");
                 }
             }}
         
         if(control==false){
             JOptionPane.showMessageDialog(null, "No se encontraron enfrentamientos registrados con el Id que ingreso ");
         }
     }
     
     //Metodo para buscar enfrentamientos donde participara el equipo o juez
     
     public ArrayList<Enfrentamiento> buscarParticipacionJ(){
         ArrayList<Enfrentamiento>retorno=new ArrayList<>();
         String buscar=JOptionPane.showInputDialog(null,"Ingrese el nombre del equipo para consultar","Proyecto Programación II UQ", JOptionPane.PLAIN_MESSAGE);
         for(int i=0;i<listaTorneos.size();i++){
             for(int j=0;j<listaTorneos.get(i).enfrentamientos.size();j++){
                 for(int k=0;k<listaTorneos.get(i).enfrentamientos.get(j).listaEquipos.size();k++){
                     if(listaTorneos.get(i).enfrentamientos.get(j).listaEquipos.get(k).getNombreEquipo().equals(buscar)){
                         retorno.add(listaTorneos.get(i).enfrentamientos.get(j));
                     }
                 }
             }
         }
         return retorno;
     }
     
     public ArrayList<Enfrentamiento> buscarParticipacionJu(){
         ArrayList<Enfrentamiento>retorno=new ArrayList<>();
         String buscar=JOptionPane.showInputDialog(null,"Ingrese el numero de licencia que desea buscar","Proyecto Programación II UQ", JOptionPane.PLAIN_MESSAGE);
         for(int i=0;i<listaTorneos.size();i++){
             for(int j=0;j<listaTorneos.get(i).enfrentamientos.size();j++){
                 for(int k=0;k<listaTorneos.get(i).enfrentamientos.get(j).listajueces.size();k++){
                     if(listaTorneos.get(i).enfrentamientos.get(j).listajueces.get(k).getLicencia().equals(buscar)){
                         retorno.add(listaTorneos.get(i).enfrentamientos.get(j));
                     }
                 }
             }
         }
         return retorno;
     }
     
     public static void mostrarTablaEnfrentamientos(ArrayList<Enfrentamiento> enfrentamientos) {
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("ID");
    model.addColumn("Lugar");
    model.addColumn("Estado");
    model.addColumn("Fecha");
    model.addColumn("Tipo Deporte");
    model.addColumn("Tipo Enfrentamiento");
    for (Enfrentamiento en : enfrentamientos) {
        model.addRow(new Object[]{en.getId(), en.getLugar(), en.getEstadoEnfrentamiento(),en.getFechaEndrentamiento(), en.getTipoDeporte(),en.getTipoEnfrentamiento()});
    }
    
    JTable table = new JTable(model);
    
    JScrollPane scrollPane = new JScrollPane(table);
    Dimension preferredSize = new Dimension(600, 300); // Ajusta este valor según tus necesidades
    scrollPane.setPreferredSize(preferredSize);
    
    JFrame frame = new JFrame("Marcadores de los enfrentamientos");
    //JScrollPane scrollPane = new JScrollPane(table);
    JOptionPane.showMessageDialog(null, scrollPane, "Lista de los enfrentamientos", JOptionPane.PLAIN_MESSAGE);
}

     public void listaJugadores(){
         String buscar=JOptionPane.showInputDialog(null,"                  Ingrese el nombre del equipo","Proyecto Programación II UQ", JOptionPane.PLAIN_MESSAGE);
          ArrayList<Jugador>ju=new ArrayList<>();
          boolean c=false;
         for(int i=0;i<listaTorneos.size()&&c==false;i++){
             for(int j=0;j<listaTorneos.get(i).equipos.size();j++){
                 if(listaTorneos.get(i).equipos.get(j).getNombreEquipo().equals(buscar)){
                    //ju=listaTorneos.get(i).equipos.get(j).listaJugadores;
                  
                    DefaultTableModel model = new DefaultTableModel();
                    model.addColumn("ID");
                    model.addColumn("Nombre");
                    model.addColumn("Apellido");
                    model.addColumn("Edad");
                    model.addColumn("Fecha Nacimiento");
                    model.addColumn("Genero");
                    model.addColumn("N Celular");
                    model.addColumn("Email");
                   

                    for (Jugador per : listaTorneos.get(i).equipos.get(j).listaJugadores) {
                        model.addRow(new Object[]{per.getId(),per.getNombre(),per.getApellido(),per.getEdad(),per.getFechaNacimiento(),per.getGenero(),per.getNumeroCelular(),per.getEmail()});
                    }
                    JTable table = new JTable(model);

                    JScrollPane scrollPane = new JScrollPane(table);
                    Dimension preferredSize = new Dimension(600, 300); // Ajusta este valor según tus necesidades
                    scrollPane.setPreferredSize(preferredSize);

                    JFrame frame = new JFrame("Marcadores de los enfrentamientos");
                    //JScrollPane scrollPane = new JScrollPane(table);
                    JOptionPane.showMessageDialog(null, scrollPane, "Lista de los enfrentamientos", JOptionPane.PLAIN_MESSAGE);
                    c=true;
                 }
             }
         }
         
         //Crear tabla
         
         
         
     }
     
     public void listaJueces(){
         
     }
    
     public ArrayList<Juez> juecesR(int index){
         ArrayList<Juez>retorno=new ArrayList<>();
         int num=0;
         for(int i=0;i<listaTorneos.get(index).enfrentamientos.size();i++){
             for(int j=0;j<listaTorneos.get(index).enfrentamientos.get(i).listajueces.size();j++){
                 for(int k=0;k<retorno.size();k++){
                     if(listaTorneos.get(index).enfrentamientos.get(i).listajueces.get(j).getLicencia().equals(retorno.get(k).getLicencia())){
                        num=num+1;
                     }
                 }
                 
                 //agregados porque no se encontro el numero de licencia en el arrayList nuevo
                 if(num!=0){
                     retorno.add(listaTorneos.get(index).enfrentamientos.get(i).listajueces.get(j));
                 }
             }
         }
         return retorno;
     }
     
     //mostrar tabla resultados por torneo
     
     public void mostrarResultados(){
         String buscar=miTorneo.entrada("Ingrese el nombre del torneo");
         boolean c=false;
         for(int i=0;i<listaTorneos.size()&&c==false;i++){
             if(listaTorneos.get(i).getNombreTorneo().equals(buscar)){
                 //Crear tabla
         
                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("Nombre Equipo");
                model.addColumn("Victorias");
                model.addColumn("Perdidas");
                model.addColumn("Empates");

                for (Equipo per :listaTorneos.get(i).equipos) {
                    model.addRow(new Object[]{per.getNombreEquipo(),per.result()[0],per.result()[1],per.result()[2]});
                }

               JTable table = new JTable(model);

               JScrollPane scrollPane = new JScrollPane(table);
               Dimension preferredSize = new Dimension(600, 300); // Ajusta este valor según tus necesidades
               scrollPane.setPreferredSize(preferredSize);

               JFrame frame = new JFrame("Marcadores de los enfrentamientos");
               //JScrollPane scrollPane = new JScrollPane(table);
               JOptionPane.showMessageDialog(null, scrollPane, "Lista de los enfrentamientos", JOptionPane.PLAIN_MESSAGE);
               c=true;
             }
         }
         
         
     }

}
