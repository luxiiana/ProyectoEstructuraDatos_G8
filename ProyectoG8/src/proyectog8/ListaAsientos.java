package proyectog8;

import javax.swing.JOptionPane;

public class ListaAsientos {
    
    private nodoAsiento inicio;
    private nodoAsiento fin;

    //String listaAsientos[][] = new String[4][10];
    
    int c=10;
    int f=10;
    
    String listaAsientos[][]=new String[f][c];
    
    public ListaAsientos() {
        this.inicio = null;
        this.fin = null;

    }
    
    
    //------------VALIDACIONES-----------------
    
    public boolean esVacia() {
        if (inicio == null) {
            return true;
        } else {
            return false;
        }

    }
    
    public void ocupado(){
        
    }

    //---------------METODOS-------------------
    
    
    
    
    public void llenarListaPre() {
        int contador = 0;
        for (int c = 0; c < 2; c++) {
            for (int x = 0; x < 10; x++) {
                contador = contador + 1;
                if (contador > 0 && contador < 10) {

                    listaAsientos[c][x] = "PRE0" + contador + "   ";
                } else if (contador == 10) {
                    listaAsientos[c][x] = "PRE" + contador + "   ";
                } else if (contador == 11) {
                    listaAsientos[c][x] = "\n" + "PRE" + contador + "   ";
                } else if (contador > 11 && contador <= 20) {
                    listaAsientos[c][x] = "PRE" + contador + "   ";

                }
            }
        }
    }

    public void mostrarListaPre() {
        System.out.print("\n\n");
        for (int c = 0; c < 2; c++) {
            for (int x = 0; x < 10; x++) {
                System.out.print(listaAsientos[c][x]);
                //System.out.print(listaAsientos);
            }
        }
    }

    public void llenarListaNor() {
        int contador = 0;
        for (int c = 2; c < 4; c++) {
            for (int x = 0; x < 10; x++) {
                contador = contador + 1;
                if (contador > 0 && contador < 10) {

                    listaAsientos[c][x] = "NOR0" + contador + "   ";
                } else if (contador == 10) {
                    listaAsientos[c][x] = "NOR" + contador + "   ";
                } else if (contador == 11) {
                    listaAsientos[c][x] = "\n" + "NOR" + contador + "   ";
                } else if (contador > 11 && contador <= 20) {
                    listaAsientos[c][x] = "NOR" + contador + "   ";

                }
            }
        }
    }

    public void ocuparAsiento(String asiento) {
        for (int c = 0; c < 4; c++) {
            for (int x = 0; x < 10; x++) {
                if (listaAsientos[c][x].equalsIgnoreCase(asiento + "   ")) {
                    listaAsientos[c][x] = "*****   ";

                }
            }
        }
    }

    public void mostrarListaNor() {
        System.out.print("\n");
        for (int c = 2; c < 4; c++) {
            for (int x = 0; x < 10; x++) {
                System.out.print(listaAsientos[c][x]);

            }

        }
    }

    public void hablilitarAsientos() {
        llenarListaPre();
        llenarListaNor();
    }

    public void mostrarAsientos() {
        mostrarListaPre();
        mostrarListaNor();

    }

    public void comprarAsiento() {
        Asientos a = new Asientos();
        mostrarAsientos();
        a.setCodArea(JOptionPane.showInputDialog("Digite el codigo de asiento que desea (PRE/NOR) y su numero de asiento (1-20)   (PRE: 5000 Colones NOR: 10000 colones) "));
        //a.setNumAsiento(Integer.parseInt(JOptionPane.showInputDialog("digite el numero de asiento que desea (1-20) ")));
        if (a.getCodArea().equalsIgnoreCase("PRE")) {
            a.setCosto(5000);
        } else if (a.getCodArea().equalsIgnoreCase("NOR")) {
            a.setCosto(10000);
        }
        a.setLibOcu('O');
        ocuparAsiento(a.getCodArea());
        JOptionPane.showMessageDialog(null, "¡Asiento seleccionado!");
        nodoAsiento nuevo = new nodoAsiento();
        nuevo.setDato(a);
        if (esVacia()) {
            inicio = nuevo;
            fin = nuevo;
            fin.setSiguiente(inicio);
            inicio.setAnterior(fin);
        } else if (a.getNumAsiento() < inicio.getDato().getNumAsiento()) {
            nuevo.setSiguiente(inicio);
            inicio = nuevo;
            fin.setSiguiente(inicio);
            inicio.setAnterior(fin);
        } else if (a.getNumAsiento() >= fin.getDato().getNumAsiento()) {
            fin.setSiguiente(nuevo);
            fin = nuevo;
            fin.setSiguiente(inicio);
            inicio.setAnterior(fin);
        } else {
            nodoAsiento aux = inicio;
            while (aux.getSiguiente().getDato().getNumAsiento() < a.getNumAsiento()) {
                aux = aux.getSiguiente();
            }
            nuevo.setSiguiente(aux.getSiguiente());
            nuevo.setAnterior(aux);
            aux.setSiguiente(nuevo);
            nuevo.getSiguiente().setAnterior(nuevo);
        }

    }

    public void editarAsiento() {
        nodoAsiento aux = inicio;
        if (aux != null) {
            while (aux.getSiguiente() != inicio) {
                if (aux.getDato().equals(aux.getDato().getNumAsiento())) {
                    // aqui verifica el asiento y pueden todo lo que se va a editar como la disponibilidad y eso
                }
            }

        }
    }

    public void eliminarAsiento() {
        if (!esVacia()) {
            inicio = inicio.getSiguiente();
            fin.setSiguiente(inicio);
            inicio.setAnterior(fin);
            JOptionPane.showMessageDialog(null, "El elemento fue extraído!");
        } else {
            //a partir de aqui se pone que el asiento no pudo ser eliminado porque estaba ocupado o algo asi
        }
    }

}
