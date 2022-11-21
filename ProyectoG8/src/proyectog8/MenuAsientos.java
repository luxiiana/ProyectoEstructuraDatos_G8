package proyectog8;

import javax.swing.JOptionPane;

/**
 *
 * @author fabia
 */
public class MenuAsientos {

    private char opcion = ' ';
    ListaAsientos la = new ListaAsientos();

    public void mostrarMenu() {
        opcion = JOptionPane.showInputDialog(null, "***MENÚ PRINCIPAL***\n\n"
                + "a. Agregar asiento\n"
                + "b. Editar Asiento\n"
                + "c. Inactivar Asiento\n"
                + "d. Habilitar Sala\n"
                + "e. Mostrar Asientos\n"
                + "f. Salir del Sistema\n\n"
                + "Digite su opción:").toLowerCase().charAt(0);
        switch (opcion) {
            case 'a': {
                la.agregarAsiento();
                mostrarMenu();
                break;
            }
            case 'b': {
                //la.mostrarElementos();
                mostrarMenu();
                break;
            }
            case 'c': {
                //la.mostrarElementos2();
                mostrarMenu();
                break;
            }
            case 'd': {
                la.hablilitarAsientos();
                mostrarMenu();
                break;
            }
            case 'e': {
                la.mostrarAsientos();
                mostrarMenu();
                break;
            }
            case 'f': {
                System.exit(0);
                break;
            }
            default: {
                JOptionPane.showMessageDialog(null,
                        "Opción incorrecta!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}
