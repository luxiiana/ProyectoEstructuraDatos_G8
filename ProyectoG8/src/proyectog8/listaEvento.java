package proyectog8;

import javax.swing.JOptionPane;

public class listaEvento {

    private nodoEvento n = new nodoEvento();
    private nodoEvento inicio;
    private Evento e = new Evento();

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

        while (!aux.getElemento().getNomEvento().equals(evento)) {
            aux = aux.getSiguiente();
        }
        if (aux.getElemento().getNomEvento().equals(evento)) {
            return true;
        } else {
            JOptionPane.showInputDialog("El evento no existe");
            return false;
        }
    }

    //-----------------------------MÉTODOS---------------------------------------
    public char crearEvento(char agregar) {

        Evento e = new Evento();

        if (agregar == 'n') {
            return 'n';
        } else {
            //---NOMBRE EVENTO---
            e.setNomEvento(JOptionPane.showInputDialog("Ingrese el nombre del nuevo evento: "));

            //---LUGAR---
            e.setLugar(JOptionPane.showInputDialog(null, "Ingrese la sala en la que se realizará: \na. SALA A\nb. SALA B\nc. SALA C").toLowerCase().charAt(0));

            //---MES---
            e.setMes(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número del mes del evento: \nEj: (01, 02, 03...,12)")));

            //---DIA---
            e.setDia(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el día del evento: ")));

            //---AÑO---
            do {
                e.setAno(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año del evento:\n(Sólo se puede agendar del 2022 al 2024)")));
            } while (e.getAno() < 2022 && e.getAno() > 2024);

            //---NODO---
            nodoEvento n = new nodoEvento();
            n.setElemento(e);

            if (esVacio()) {
                inicio = n;
            } else if (e.getNomEvento().compareTo(inicio.getElemento().getNomEvento()) < 0) { //izquierda
                n.setSiguiente(inicio);
                inicio = n;
            } else if (inicio.getSiguiente() == null) { //derecha
                inicio.setSiguiente(n);
            } else { //en el medio
                nodoEvento aux = inicio;
                while ((aux.getSiguiente() != null) && (aux.getSiguiente().getElemento().getNomEvento().compareTo(e.getNomEvento())) < 0) {
                    aux = aux.getSiguiente();
                }
                n.setSiguiente(aux.getSiguiente());
                aux.setSiguiente(n);
            }

            return crearEvento(agregar = JOptionPane.showInputDialog("¿Desea crear otro evento?\n-Si\n-No").toLowerCase().charAt(0));
        }
    }

    public char editarEvento(char editar) {

        if (editar == 'n') {
            n.setElemento(e);
            return editar = 'n';
        } else {
            String evento = "";
            char opc = ' ';
            
            if(!esVacio()){
                 do {
                    evento = JOptionPane.showInputDialog("Ingrese el nombre del evento a editar: ");
                } while (!existe(evento));

                nodoEvento aux = inicio;
                while (aux != null) {

                    opc = JOptionPane.showInputDialog("¿Qué desea editar?"
                            + "\na. Nombre del evento \nb.Mes\nc. Día\nd. Año\ns. Salir al menú principal").toLowerCase().charAt(0);

                    switch (opc) {
                        case 'a':
                            e.setNomEvento(JOptionPane.showInputDialog("Ingrese el nuevo nombre:"));
                            n.setElemento(e);
                            JOptionPane.showMessageDialog(null, "Nuevo nombre del evento: " + n.getElemento().getNomEvento());
                            break;
                        case 'b':
                            e.setMes(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo mes: ")));
                            n.setElemento(e);
                            JOptionPane.showMessageDialog(null, "Nuevo mes: " + n.getElemento().getMes());
                            break;
                        case 'c':
                            e.setDia(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo día del evento: ")));
                            n.setElemento(e);
                            JOptionPane.showMessageDialog(null, "Nuevo día: " + n.getElemento().getDia());
                            break;
                        case 'd':
                            e.setAno(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el nuevo año: ")));
                            n.setElemento(e);
                            JOptionPane.showMessageDialog(null, "Nuevo año: " + n.getElemento().getAno());
                            break;
                        case 's':
                            n.setElemento(e);
                            return editarEvento(editar = JOptionPane.showInputDialog("SALIENDO...\n¿Desea editar algo más? "
                                    + "\n-Si\n-No").toLowerCase().charAt(0));
                        default:
                            JOptionPane.showMessageDialog(null, "Opcion no válida...");
                            break;
                    }

                }
            }else{
                JOptionPane.showMessageDialog(null, "LISTA VACÍA");
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
                s = s + aux.getElemento().getNomEvento() + "\nSALA: " + aux.getElemento().getLugar() + "\nMES: " + aux.getElemento().getMes()
                        + "\nDIA: " + aux.getElemento().getDia() + "\nAÑO: " + aux.getElemento().getAno() + "\n\n----------------------------\n\n";
                aux = aux.getSiguiente();
            }
            JOptionPane.showMessageDialog(null, "La lista contiene:\n" + s);
        } else {
            JOptionPane.showMessageDialog(null, "¡No se puede mostrar, lista vacía!");
        }
    }

}
