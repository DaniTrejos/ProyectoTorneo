package ProyectoTorneo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;

public class Menus{

    Torneo miTorneo = new Torneo();

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
                                3. Registrar jueces
                                4. Agendar enfrentamientos
                                5. Información de fechas
                                6. Enfrentamientos
                                7. Tabla general
                                8. Salir""".indent(5), "Proyecto Programación II UQ", JOptionPane.PLAIN_MESSAGE);


                if (input == null) {
                    break;
                }
                option = Integer.parseInt(input);

                if (option > 0 && option <= 8) {
                    switch (option) {
                        case 1:
                            ArrayList<Torneo> listaTorneos = new ArrayList<>();
                            miTorneo.crearTorneo(listaTorneos);
                            JOptionPane.showMessageDialog(null, "Prueba Agregar");
                            break;
                        case 2:
                            mostrarOpcionesDeportes();
                            //miTorneo.crearEquipo(Integer.parseInt(JOptionPane.showInputDialog("¿Cuantos equipos son?")));
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        case 5:
                            menuConsultarFechas();
                            break;
                        case 6:
                            mostrarInformacionEnfrentamientos();
                            break;
                        case 7:
                            mostrarTablaGeneralTorneosIndividuales();
                            break;
                        case 8:
                            break;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Elija una opción de 1-8");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese caracteres de tipo numérico");
            }
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
                            JOptionPane.showMessageDialog(null, "Fechas consultadas");
                            break;
                        case 2:
                            menuModificarFechas();
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

    public void menuModificarFechas(){
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

                            JOptionPane.showMessageDialog(null, "Fechas de  inicio de inscripciones modificadas");
                            break;
                        case 2:
                            JOptionPane.showMessageDialog(null, "Fechas de finalización de inscripciones modificadas");
                            break;
                        case 3:
                            JOptionPane.showMessageDialog(null, "Fechas de inicio del torneo modificadas");
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

    public void mostrarTablaGeneralTorneosIndividuales(){
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
    }

    public static void mostrarTablaGeneralFutbol() {
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

    static class TableCellRenderer extends DefaultTableCellRenderer {
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
    }

    public void mostrarInformacionEnfrentamientos(){

        int option = 0;

        while (option != 4) {
            try {
                String input = JOptionPane.showInputDialog(null,"     1. Agregar resultados\n     2. Consultar Información de los Equipos \n     3."+
                        " Consultar Información de los Jueces \n     4. Atrás", "Proyecto Programación II UQ", JOptionPane.PLAIN_MESSAGE);

                if (input == null) {
                    break;
                }

                option = Integer.parseInt(input);

                if (option > 0 && option <= 4) {
                    switch (option) {
                        case 1:
                            JOptionPane.showMessageDialog(null, "Aquí debe de escoger el deporte y luego automaticamente"+
                                    " se guardan los resultados con la la clase random");
                            break;
                        case 2:
                            JOptionPane.showMessageDialog(null, "Información de equipos consultada");
                            break;
                        case 3:
                            JOptionPane.showMessageDialog(null, "Información de los jueces consultada");
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

    public void mostrarOpcionesDeportes(){
        int option = 0;

        while (option != 6) {
            try {
                String input = JOptionPane.showInputDialog(null,"     1. Futbol \n     2. Baloncesto\n     3."+
                        " Volleyball\n     4. Hockey\n     5. Polo\n     6. Atras","Proyecto Programación II UQ", JOptionPane.PLAIN_MESSAGE);
                if (input == null) {

                    break;
                }
                option = Integer.parseInt(input);

                if (option > 0 && option <= 6) {
                    switch (option) {
                        case 1:
                            miTorneo.crearEquipo(Integer.parseInt(JOptionPane.showInputDialog("¿Cuantos equipos de futbol son?")));
                            break;
                        case 2:
                            miTorneo.crearEquipo(Integer.parseInt(JOptionPane.showInputDialog("¿Cuantos equipos de baloncesto son?")));
                            break;
                        case 3:
                            miTorneo.crearEquipo(Integer.parseInt(JOptionPane.showInputDialog("¿Cuantos equipos de volleyball son?")));
                            break;
                        case 4:
                            miTorneo.crearEquipo(Integer.parseInt(JOptionPane.showInputDialog("¿Cuantos equipos de hockey son?")));
                            break;
                        case 5:
                            miTorneo.crearEquipo(Integer.parseInt(JOptionPane.showInputDialog("¿Cuantos equipos de polo son?")));
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
    }

}
