package proyectog8;

import javax.swing.JOptionPane;

public class ListaAsientos {

    private nodoAsiento inicio;
    private nodoAsiento fin;

    String listaAsientos[][] = new String[4][10];

    //int c=10;
    //int f=10;
    //String listaAsientos[][]=new String[f][c];
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

    public void ocupado() {

    }

    //---------------METODOS-------------------
    public void llenarListaPre() {
        int contador = 0;
        for (int c = 0; c < 2; c++) {
            for (int x = 0; x < 10; x++) {
                contador = contador + 1;
                if (contador > 0 && contador < 10) {

                    listaAsientos[c][x] = "PRE0" + contador + "    ";
                } else if (contador == 10) {
                    listaAsientos[c][x] = "PRE" + contador + "    ";
                } else if (contador == 11) {
                    listaAsientos[c][x] = "\n" + "PRE" + contador + "    ";
                } else if (contador > 11 && contador <= 20) {
                    listaAsientos[c][x] = "PRE" + contador + "    ";

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

                    listaAsientos[c][x] = "NOR0" + contador + "    ";
                } else if (contador == 10) {
                    listaAsientos[c][x] = "NOR" + contador + "    ";
                } else if (contador == 11) {
                    listaAsientos[c][x] = "\n" + "NOR" + contador + "    ";
                } else if (contador > 11 && contador <= 20) {
                    listaAsientos[c][x] = "NOR" + contador + "    ";

                }
            }
        }
    }

    public void ocuparAsiento(String asiento) {
        for (int c = 0; c < 4; c++) {
            for (int x = 0; x < 10; x++) {
                if (listaAsientos[c][x].equalsIgnoreCase(asiento + "    ")) {
                    listaAsientos[c][x] = asiento + "*   ";

                }
            }
        }
    }

    public void desocuparAsiento(String asiento) {
        for (int c = 0; c < 4; c++) {
            for (int x = 0; x < 10; x++) {
                if (listaAsientos[c][x].equalsIgnoreCase(asiento + "*   ")) {
                    listaAsientos[c][x] = asiento + "    ";

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
        System.out.println("\nLos asientos que contengan un (*) se encuentran ocupados");
        mostrarListaPre();
        mostrarListaNor();
        System.out.println("\n");

    }

    public char comprarAsiento(char comprar) {
        int repetido = 1;
        if (comprar == 'n') {
            return 'n';
        } else {



           Asientos a = new Asientos();
            mostrarAsientos();
            a.setCodArea(JOptionPane.showInputDialog("Digite el codigo de asiento que desea (PRE/NOR) y su numero de asiento (1-20)   (PRE: 5000 Colones NOR: 10000 colones) "));



           if (!esVacia()) {
                String s = "";
                nodoAsiento aux = inicio;
                if (aux.getDato().getCodArea().equals(a.getCodArea())) {
                    repetido = 0;
                    JOptionPane.showMessageDialog(null, "ERROR El asiento no se puede seleccionar porque ya fue comprado anteriormente");
                } else {
                    repetido = 1;
                }
                aux = aux.getSiguiente();
                while (aux != inicio) {
                    while (aux.getDato().getCodArea().equals(a.getCodArea())) {
                        repetido = 0;
                        JOptionPane.showMessageDialog(null, "ERROR El asiento no se puede seleccionar porque ya fue comprado anteriormente");
                    }
                    repetido = 1;
                    
                    aux = aux.getSiguiente();
                }
            }
            if (repetido != 0) {
                for (int i = 0; i < 21; i++) {
                    if (a.getCodArea().equalsIgnoreCase("PRE" + i) || a.getCodArea().equalsIgnoreCase("PRE0" + i)) {
                        a.setCosto(5000);
                    } else if (a.getCodArea().equalsIgnoreCase("NOR" + i) || a.getCodArea().equalsIgnoreCase("NOR0" + i)) {
                        a.setCosto(10000);
                    }
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



           } else {
                comprarAsiento('s');
            }
        }
        return comprarAsiento(comprar = JOptionPane.showInputDialog("¿Desea comprar más asientos?\n-Si\n-No").toLowerCase().charAt(0));



   }

    public char editarAsiento(char editar) {

        if (editar == 'n') {
            return 'n';
        } else {

            int encontrado = 0;
            nodoAsiento aux = inicio;
            String asiento = JOptionPane.showInputDialog("Digite el codigo de asiento que desea cambiar (PRE/NOR) y su numero de asiento (1-20) ");
            if (aux.getDato().getCodArea().equalsIgnoreCase(asiento)) {

                JOptionPane.showMessageDialog(null, "Asiento encontrado ");
                encontrado = 1;
                desocuparAsiento(aux.getDato().getCodArea());
                aux.getDato().setCodArea(JOptionPane.showInputDialog("Digite el codigo de asiento que desea (PRE/NOR) y su numero de asiento (1-20)   (PRE: 5000 Colones NOR: 10000 colones) "));
                ocuparAsiento(aux.getDato().getCodArea());

                for (int i = 0; i < 21; i++) {
                    if (aux.getDato().getCodArea().equalsIgnoreCase("PRE" + i) || aux.getDato().getCodArea().equalsIgnoreCase("PRE0" + i)) {
                        aux.getDato().setCosto(5000);
                    } else if (aux.getDato().getCodArea().equalsIgnoreCase("NOR" + i) || aux.getDato().getCodArea().equalsIgnoreCase("NOR0" + i)) {
                        aux.getDato().setCosto(10000);
                    }
                }
                aux.getDato().setLibOcu('L');
                JOptionPane.showMessageDialog(null, "¡Asiento seleccionado!");

            }

            aux = aux.getSiguiente();
            while (aux != inicio) {
                if (aux.getDato().getCodArea().equalsIgnoreCase(asiento)) {

                    JOptionPane.showMessageDialog(null, "Asiento encontrado ");
                    encontrado = 1;
                    desocuparAsiento(aux.getDato().getCodArea());
                    aux.getDato().setCodArea(JOptionPane.showInputDialog("Digite el codigo de asiento que desea (PRE/NOR) y su numero de asiento (1-20)   (PRE: 5000 Colones NOR: 10000 colones) "));
                    ocuparAsiento(aux.getDato().getCodArea());

                    for (int i = 0; i < 21; i++) {
                        if (aux.getDato().getCodArea().equalsIgnoreCase("PRE" + i)) {
                            aux.getDato().setCosto(5000);
                        } else if (aux.getDato().getCodArea().equalsIgnoreCase("NOR" + i)) {
                            aux.getDato().setCosto(10000);
                        }
                    }
                    aux.getDato().setLibOcu('O');
                    JOptionPane.showMessageDialog(null, "¡Asiento seleccionado!");

                } else {
                    JOptionPane.showMessageDialog(null, "El asiento seleccionado no fue encontrado ");
                }

                aux = aux.getSiguiente();
            }
            if (encontrado != 1) {
                JOptionPane.showMessageDialog(null, "El asiento seleccionado no fue encontrado, intente nuevamente ");
            }
            return editarAsiento(editar = JOptionPane.showInputDialog("¿Desea editar otro asiento? \n-Si\n-No").toLowerCase().charAt(0));

        }
    }
    
    public void eliminarAsiento() {
        try { //para atrapar posibles errores a la hora de eliminar datos
            if (!esVacia()) {
                String codigo = JOptionPane.showInputDialog("Digite el codigo de asiento que desea cambiar (PRE/NOR) y su numero de asiento (1-20) ");
                if (codigo.equals(inicio.getDato().getCodArea())) { //si es igual a inicio, inicio pasa al siguiente borrando al actual inicio
                    inicio = inicio.getSiguiente();



                   //referencia circular
                    fin.setSiguiente(inicio);
                    inicio.setAnterior(fin);
                    desocuparAsiento(inicio.getDato().getCodArea());
                } else {
                    //creo 2 variables
                    nodoAsiento auxiliar;
                    nodoAsiento anterior;



                   //anterior sera auxiliar
                    anterior = inicio;
                    //auxiliar sera el que sigue de inicio
                    auxiliar = inicio.getSiguiente();
                    /*recorre mientras auxiliar es != de inicio y mientras el número del carro
                    de auxiliar sea diferente del que busco*/
                    while ((auxiliar != inicio) && (!auxiliar.getDato().getCodArea().equals(codigo))) {
                        /*Entonces anterior será el siguiente
                        y auxiliar el siguiente*/
                        anterior = anterior.getSiguiente();
                        auxiliar = auxiliar.getSiguiente();
                    }
                    //si auxiliar es diferente a inicio
                    if (auxiliar != inicio) {
                        //el siguiente de auxiliar
                        anterior.setSiguiente(auxiliar);
                        //actualiza el enlace
                        fin.setSiguiente(auxiliar.getSiguiente());
                         desocuparAsiento(auxiliar.getDato().getCodArea());
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "No hay datos...");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "¡Error al extraer!", "Ocurrió un error al extraer", JOptionPane.ERROR_MESSAGE);
        }
    }
}

