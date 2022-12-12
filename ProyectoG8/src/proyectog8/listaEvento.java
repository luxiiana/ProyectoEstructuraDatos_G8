package proyectog8;

import javax.swing.JOptionPane;

public class listaEvento {

    private nodoEvento n=new nodoEvento();
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
        if ((aux.equals(evento)) && (evento.equals(aux.getElemento()))) {
            return true;
        } else {
            return false;
        }
    }

    //-----------------------------MÉTODOS---------------------------------------
    public char crearEvento(char agregar) {

        Evento e = new Evento();

        if (agregar == 'n') {
            return 'n';
        } else {
            e.setNomEvento(JOptionPane.showInputDialog("Ingrese el nombre del nuevo evento: "));

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
                } while (e.getDia() > 29);
            } else if (e.getMes() == 'd' || e.getMes() == 'f' || e.getMes() == 'i' || e.getMes() == 'k') {
                do {
                    e.setDia(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el día del evento: ")));
                } while (e.getDia() > 30);
            } else {
                do {
                    e.setDia(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el día del evento: ")));
                } while (e.getDia() > 31);
            }

            //-------------AÑO---------------
            e.setAno(JOptionPane.showInputDialog("Escoja el año del evento: \na. 2022 \nb.2023\nc.2024").toLowerCase().charAt(0));

            e.setFecha("---FECHA DEL EVENTO---" + "\n\nDía: " + String.valueOf(e.getDia()) + "\nMes: " + e.getM() + "\nAño: " + String.valueOf(e.getAno()));

            nodoEvento n = new nodoEvento();
            n.setElemento(e);

            if (esVacio()) {
                inicio = n;
            } else if (e.getNomEvento().compareTo(inicio.getElemento().getNomEvento())<0) {
                n.setSiguiente(inicio);
                inicio = n;
            } else if (inicio.getSiguiente() == null) {
                inicio.setSiguiente(n);
            } else {
                nodoEvento aux = inicio;
                while ((aux.getSiguiente() != null) && (aux.getSiguiente().getElemento().getNomEvento().compareTo(e.getNomEvento()))<0) {
                    aux = aux.getSiguiente();
                }
                n.setSiguiente(aux.getSiguiente());
                aux.setSiguiente(n);
            }

            return crearEvento(agregar = JOptionPane.showInputDialog("¿Desea crear otro evento?\n-Si\n-No").toLowerCase().charAt(0));
        }
    }

    public char editarEvento(char editar) {
        nodoEvento n=new nodoEvento();
        Evento e = new Evento();
        if (editar == 'n') {
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
                while ((aux != null) && (aux.equals(n.getElemento().getNomEvento()))) { //Si aux no cae en vacío y es igual a el nombre de un evento del nodo
                    char opc = ' ';
                    opc = JOptionPane.showInputDialog("¿Qué desea editar?\na. Nombre del evento \nb.Fecha\nc. Salir al menú principal").toLowerCase().charAt(0);
                    switch (opc) {
                        case 'a':
                            n.getElemento().setNomEvento(JOptionPane.showInputDialog("Nombre actual:\n" + n.getElemento().getNomEvento() + "\nIngrese el nuevo nombre del nuevo evento: "));
                            JOptionPane.showMessageDialog(null, "Nuevo nombre del evento: " + e.getNomEvento());
                            break;
                        case 'b':
                            char edita = ' ';
                            do {
                                edita = JOptionPane.showInputDialog("---EDITAR FECHA----\n\na. Día\nb. Mes\nc. Año").toLowerCase().charAt(0);
                            } while (edita != ' ' && edita != 'a' && edita != 'b' && edita != 'c');

                            switch (edita) {
                                case 'a':
                                    if (n.getElemento().getMes() == 'b') {
                                        do {
                                            n.getElemento().setDia(Integer.parseInt(JOptionPane.showInputDialog("Día actual: " + n.getElemento().getDia() + "\nIngrese el día del evento: ")));
                                        } while (n.getElemento().getDia() > 29);
                                    } else if (n.getElemento().getMes() == 'd' || n.getElemento().getMes() == 'f' || n.getElemento().getMes() == 'i' || n.getElemento().getMes() == 'k') {
                                        do {
                                            n.getElemento().setDia(Integer.parseInt(JOptionPane.showInputDialog("Día actual: " + n.getElemento().getDia() + "\nIngrese el día del evento: ")));
                                        } while (n.getElemento().getDia() > 30);
                                    } else {
                                        do {
                                            n.getElemento().setDia(Integer.parseInt(JOptionPane.showInputDialog("Dia actual: " + n.getElemento().getDia() + "\nIngrese el día del evento: ")));
                                        } while (n.getElemento().getDia() > 31);
                                    }
                                    break;
                                case 'b':
                                    do {
                                        n.getElemento().setMes(JOptionPane.showInputDialog("Mes actual: " + n.getElemento().getMes() + "\n\nElija el nuevo mes del evento: "
                                                + "\na. Enero\nb. Febrero\nc. Marzo\nd. Abril\ne. Mayo\nf. Junio\ng. Julio"
                                                + "\nh. Agosto\ni. Setiembre\nj. Octubre\nk. Noviembre\nl. Diciembre").toLowerCase().charAt(0));
                                    } while (n.getElemento().getMes() != ' ');

                                    switch (n.getElemento().getMes()) {
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
                                    e.setAno(JOptionPane.showInputDialog("Año actual del evento: " + n.getElemento().getAno() + "\nEscoja el nuevo año del evento: \na. 2022 \nb.2023\nc.2024").toLowerCase().charAt(0));
                                    break;
                            }
                            e.setFecha("---FECHA DEL EVENTO---" + "\n\nDía: " + String.valueOf(n.getElemento().getDia()) + "\nMes: " + e.getM() + "\nAño: " + String.valueOf(n.getElemento().getAno()));
                            break;
                        case 'c': //salir del programa
                            break;
                    }
                    n.setElemento(e);
                }
                if (aux != null && !aux.equals(n.getElemento().getNomEvento())) {
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

}
