package proyectog8;

import javax.swing.JOptionPane;

public class listaEvento {

    private nodoEvento inicio;

    public listaEvento() {
        this.inicio = null;
    }

    public boolean esVacio() {
        if (inicio == null) {
            return true;
        } else {
            return false;
        }
    }

    public int crearEvento(int numEventos) {

        Evento e = new Evento();

        if (numEventos == 0) {
            return 0;
        } else {
            e.setNomEvento(JOptionPane.showInputDialog("Ingrese el nombre del nuevo evento: "));

            /*JOptionPane.showMessageDialog(null, "---FECHA---\nAcontinuación complete: "
                    + "\n-Día (como 1, 2 , 3...etc)\n-Mes (mayo, agosto, octubre...etc)\n-Año (2022, 2023, 2024,...etc)");
            e.setDia(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el día del evento: ")));
            e.setMes(JOptionPane.showInputDialog("Ingrese el mes del evento: "));
            e.setAno(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año del evento:")));*/
            JOptionPane.showMessageDialog(null, "A continuación ingresará la fecha:");

            //--------------MES-------------
            e.setMes(JOptionPane.showInputDialog("Elija el mes del evento: "
                    + "\na. Enero\nb. Febrero\nc. Marzo\nd. Abril\ne. Mayo\nf. Junio\ng. Julio"
                    + "\nh. Agosto\ni. Setiembre\nj. Octubre\nk. Noviembre\nl. Diciembre").toLowerCase().charAt(0));

            //-------------DIA---------------
            if (e.getMes() == 'b') {
                do {
                    e.setDia(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el día del evento: ")));
                } while (e.getDia() < 29);
            } else if (e.getMes() == 'd' || e.getMes() == 'f' || e.getMes() == 'i' || e.getMes() == 'k') {
                do {
                    e.setDia(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el día del evento: ")));
                } while (e.getDia() < 31);
            } else {
                do {
                    e.setDia(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el día del evento: ")));
                } while (e.getDia() < 32);
            }

            //-------------AÑO---------------
            e.setAno(JOptionPane.showInputDialog("Escoja el año del evento: \na. 2022 \nb.2023\nc.2024").toLowerCase().charAt(0));

            return crearEvento(numEventos - 1);
        }
    }

    public char editarEvento(char editar) {
        Evento e = new Evento();
        if (editar == 'n') {
            JOptionPane.showMessageDialog(null, "¡Evento editado!");
            return editar = 'n';
        } else {
            if (!esVacio()) {
                nodoEvento aux = inicio;
                while (aux != null) {
                    char opc = ' ';
                    opc = JOptionPane.showInputDialog("¿Qué desea editar?\na. Nombre del evento \nb.Día\nc. Mes\nd. Año\ne. Salir al menú principal").toLowerCase().charAt(0);
                    switch (opc) {
                        case 'a':
                            e.setNomEvento(JOptionPane.showInputDialog("Nombre actual:\n"+e.getNomEvento()+"\nIngrese el nuevo nombre del nuevo evento: "));
                            break;
                        case 'b':
                            if (e.getMes() == 'b') {
                                do {
                                    e.setDia(Integer.parseInt(JOptionPane.showInputDialog("Día actual:\n"+e.getDia()+"\nIngrese el día del evento: ")));
                                } while (e.getDia() < 29);
                            } else if (e.getMes() == 'd' || e.getMes() == 'f' || e.getMes() == 'i' || e.getMes() == 'k') {
                                do {
                                  e.setDia(Integer.parseInt(JOptionPane.showInputDialog("Día actual:\n"+e.getDia()+"\nIngrese el día del evento: ")));  
                                } while (e.getDia() < 31);
                            } else {
                                do {
                                    e.setDia(Integer.parseInt(JOptionPane.showInputDialog("Día actual:\n"+e.getDia()+"\nIngrese el día del evento: ")));
                                } while (e.getDia() < 32);
                            }
                            break;
                        case 'c':
                            e.setMes(JOptionPane.showInputDialog("Mes actual:\n"+e.getMes()+"\nElija el mes del evento: "
                                    + "\na. Enero\nb. Febrero\nc. Marzo\nd. Abril\ne. Mayo\nf. Junio\ng. Julio"
                                    + "\nh. Agosto\ni. Setiembre\nj. Octubre\nk. Noviembre\nl. Diciembre").toLowerCase().charAt(0));
                            break;
                        case 'd':
                            e.setAno(JOptionPane.showInputDialog("Escoja el año del evento: \na. 2022 \nb.2023\nc.2024").toLowerCase().charAt(0));
                            break;
                        case 'e':
                            break;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Evento no existe...");
            }
            return editarEvento(editar = JOptionPane.showInputDialog("¿Desea editar algo más? "
                    + "\n-Si\n-No").toLowerCase().charAt(0));
        }

    }
    
    
}
