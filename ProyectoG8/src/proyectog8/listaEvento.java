package proyectog8;

import javax.swing.JOptionPane;

public class listaEvento {

    private Evento e = new Evento();
    private nodoEvento inicio;

    public listaEvento() {
        this.inicio = null;
    }

    //-----------------------------VALIDACIONES---------------------------------------
    public boolean esVacio() {
        if (inicio == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean existe(String evento) {
        nodoEvento aux = inicio;
        while (!aux.equals(evento)) {
            aux = aux.getSiguiente();
        }
        if ((aux.equals(evento)) && (evento.equals(e.getNomEvento()))) {
            return true;
        } else {
            return false;
        }
    }

    //-----------------------------MÉTODOS---------------------------------------
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
            do {
                e.setMes(JOptionPane.showInputDialog("Elija el mes del evento: "
                        + "\na. Enero\nb. Febrero\nc. Marzo\nd. Abril\ne. Mayo\nf. Junio\ng. Julio"
                        + "\nh. Agosto\ni. Setiembre\nj. Octubre\nk. Noviembre\nl. Diciembre").toLowerCase().charAt(0));
            } while (e.getMes() == ' ');

            switch (e.getMes()) {
                case 'a':
                    e.setM("Enero");
                    break;
                case 'b':
                    e.setM("Febrero");
                    break;
                case 'c':
                    e.setM("Marzo");
                    break;
                case 'd':
                    e.setM("Abril");
                    break;
                case 'e':
                    e.setM("Mayo");
                    break;
                case 'f':
                    e.setM("Junio");
                    break;
                case 'g':
                    e.setM("Julio");
                    break;
                case 'h':
                    e.setM("Agosto");
                    break;
                case 'i':
                    e.setM("Setiembre");
                    break;
                case 'j':
                    e.setM("Octubre");
                    break;
                case 'k':
                    e.setM("Noviembre");
                    break;
                case 'l':
                    e.setM("Diciembre");
                    break;
            }

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

            e.setFecha("---FECHA DEL EVENTO---" + "\n\nDía: " + String.valueOf(e.getDia()) + "\nMes: " + e.getM() + "\nAño: " + String.valueOf(e.getAno()));

            return crearEvento(numEventos - 1);
        }
    }

    public char editarEvento(char editar) {
        if (editar == 'n') {
            JOptionPane.showMessageDialog(null, "¡Evento editado!");
            return editar = 'n';
        } else {
            if (!esVacio()) {
                String evento = "";

                do {
                    evento = JOptionPane.showInputDialog("Ingrese el nombre del evento que desea editar: \n");
                    if (!existe(evento)) {
                        JOptionPane.showMessageDialog(null, "El evento no existe...");
                    }
                } while (!existe(evento));

                nodoEvento aux = inicio;
                while ((aux != null) && (aux.equals(e.getNomEvento()))) { //Si aux no cae en vacío y es igual a el nombre de un evento del nodo
                    char opc = ' ';
                    opc = JOptionPane.showInputDialog("¿Qué desea editar?\na. Nombre del evento \nb.Fecha\nc. Salir al menú principal").toLowerCase().charAt(0);
                    switch (opc) {
                        case 'a':
                            e.setNomEvento(JOptionPane.showInputDialog("Nombre actual:\n" + e.getNomEvento() + "\nIngrese el nuevo nombre del nuevo evento: "));
                            JOptionPane.showMessageDialog(null, "Nuevo nombre del evento: " + e.getNomEvento());
                            break;
                        case 'b':
                            char edita = ' ';
                            do {
                                edita = JOptionPane.showInputDialog("---EDITAR FECHA----\n\na. Día\nb. Mes\nc. Año").toLowerCase().charAt(0);
                            } while (edita != ' ' && edita != 'a' && edita != 'b' && edita != 'c');

                            switch (edita) {
                                case 'a':
                                    if (e.getMes() == 'b') {
                                        do {
                                            e.setDia(Integer.parseInt(JOptionPane.showInputDialog("Día actual: " + e.getDia() + "\nIngrese el día del evento: ")));
                                        } while (e.getDia() < 29);
                                    } else if (e.getMes() == 'd' || e.getMes() == 'f' || e.getMes() == 'i' || e.getMes() == 'k') {
                                        do {
                                            e.setDia(Integer.parseInt(JOptionPane.showInputDialog("Día actual: " + e.getDia() + "\nIngrese el día del evento: ")));
                                        } while (e.getDia() < 31);
                                    } else {
                                        do {
                                            e.setDia(Integer.parseInt(JOptionPane.showInputDialog("Dia actual: " + e.getDia() + "\nIngrese el día del evento: ")));
                                        } while (e.getDia() < 32);
                                    }
                                    break;
                                case 'b':
                                    do {
                                        e.setMes(JOptionPane.showInputDialog("Mes actual: " + e.getMes() + "\n\nElija el nuevo mes del evento: "
                                                + "\na. Enero\nb. Febrero\nc. Marzo\nd. Abril\ne. Mayo\nf. Junio\ng. Julio"
                                                + "\nh. Agosto\ni. Setiembre\nj. Octubre\nk. Noviembre\nl. Diciembre").toLowerCase().charAt(0));
                                    } while (e.getMes() == ' ');

                                    switch (e.getMes()) {
                                        case 'a':
                                            e.setM("Enero");
                                            break;
                                        case 'b':
                                            e.setM("Febrero");
                                            break;
                                        case 'c':
                                            e.setM("Marzo");
                                            break;
                                        case 'd':
                                            e.setM("Abril");
                                            break;
                                        case 'e':
                                            e.setM("Mayo");
                                            break;
                                        case 'f':
                                            e.setM("Junio");
                                            break;
                                        case 'g':
                                            e.setM("Julio");
                                            break;
                                        case 'h':
                                            e.setM("Agosto");
                                            break;
                                        case 'i':
                                            e.setM("Setiembre");
                                            break;
                                        case 'j':
                                            e.setM("Octubre");
                                            break;
                                        case 'k':
                                            e.setM("Noviembre");
                                            break;
                                        case 'l':
                                            e.setM("Diciembre");
                                            break;
                                    }
                                    break;
                                case 'c':
                                    e.setAno(JOptionPane.showInputDialog("Año actual del evento: " + e.getAno() + "\nEscoja el nuevo año del evento: \na. 2022 \nb.2023\nc.2024").toLowerCase().charAt(0));
                                    break;
                            }
                            e.setFecha("---FECHA DEL EVENTO---" + "\n\nDía: " + String.valueOf(e.getDia()) + "\nMes: " + e.getM() + "\nAño: " + String.valueOf(e.getAno()));
                            break;
                        case 'c': //salir del programa
                            break;
                    }
                }
                if (aux != null && !aux.equals(e.getNomEvento())) {
                    aux.getSiguiente();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Lista vacía...");
            }
            return editarEvento(editar = JOptionPane.showInputDialog("¿Desea editar algo más? "
                    + "\n-Si\n-No").toLowerCase().charAt(0));
        }

    }

    public char eliminarEventos(char eliminar) {

        if (eliminar == 'n') {
            return eliminar = 'n';
        } else {
            if (!esVacio()) {
                String evento = "";
                do {
                    evento = JOptionPane.showInputDialog("Ingrese el nombre del evento que desea eliminar:\n");
                    if (!existe(evento)) { //si no existe
                        JOptionPane.showMessageDialog(null, "El evento no existe! Intentelo de nuevo");
                    }
                } while (!existe(evento)); //se repite el input si el evento no existe y sale un rótulo

                if (inicio.getElemento().getNomEvento().equals(evento)) {
                    inicio = inicio.getSiguiente();
                    JOptionPane.showMessageDialog(null, "El evento:\n" + evento + "\nFue eliminado...");
                } else {
                    nodoEvento anterior;
                    nodoEvento auxiliar;
                    anterior = inicio;
                    auxiliar = inicio.getSiguiente();
                    while ((auxiliar != null) && (!auxiliar.getElemento().getNomEvento().equals(evento))) { //si aux no está vacío y no se el evento que busco
                        //Avanzamos
                        anterior = anterior.getSiguiente();
                        auxiliar = auxiliar.getSiguiente();
                    }
                    if (auxiliar != null) { //si el auxiliar está vacío
                        /*el anterior va a poner como siguiente al siguiente del auxiliar,
                        eliminando al que originalmente le seguía*/
                        anterior.setSiguiente(auxiliar.getSiguiente());
                    }

                }
            }
            return eliminarEventos(eliminar = JOptionPane.showInputDialog("¿Desea eliminar algo más? \n-Si\n-No").toLowerCase().charAt(0));
        }

    }

    public void mostrarEventos() {
        if (!esVacio()) {
            String s = "";
            nodoEvento aux = inicio;
            while (aux != null) {
                s = s + aux.getElemento().getNomEvento() + "\n" + aux.getElemento() + "---";
                aux = aux.getSiguiente();
            }
            JOptionPane.showMessageDialog(null, "La lista contiene:\n" + s);
        } else {
            JOptionPane.showMessageDialog(null, "¡No se puede mostrar, lista vacía!");
        }
    }

    public int comprarEvento(int entradas) {

        entradas = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántas entradas comprará?\n\nIngreselo:"));

        if (entradas == 0) {
            return 0;
        } else {
            if (!esVacio()) {
                String compra = "";
                do {
                    compra = JOptionPane.showInputDialog("Ingrese el nombre del evento que desea editar: \n");
                    if (!existe(compra)) {
                        JOptionPane.showMessageDialog(null, "El evento no existe...");
                    }
                } while (!existe(compra));
                nodoEvento aux = inicio;
                while (aux != null && aux.equals(compra)) {
                    /*ACÁ SE LLAMAN LOS ASIENTOS PARA QUE EL USUARIO LOS ELIJA SEGÚN LA CANTIDAD DE ENTRADAS*/
                }
                if (aux != null && !aux.equals(e.getNomEvento())) {
                    aux.getSiguiente();
                }
                return comprarEvento(entradas - 1);

            } else {
                JOptionPane.showMessageDialog(null, "No hay eventos...");
                return 0;
            }
        }
    }

}
