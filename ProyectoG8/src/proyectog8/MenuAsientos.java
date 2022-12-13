package proyectog8;

import javax.swing.JOptionPane;
     
public class MenuAsientos {

    private char opcion = ' ';
    ListaAsientos la = new ListaAsientos();
    
    public void mostrarMenuAsientos() {
        opcion = JOptionPane.showInputDialog(null, "***MENÚ PRINCIPAL***\n\n"
                + "a. HABILITE LA SALA ANTES DE COMPRAR\n\n"
                + "b. Elegir asiento\n"
                + "c. Cambiar de Asiento\n"
                + "d. Eliminar Asiento\n"
                + "e. Mostrar Asientos\n"
                + "s. Salir del Sistema\n\n"
                + "Digite su opción:").toLowerCase().charAt(0);
        switch (opcion) {
            case 'a': {
                la.hablilitarAsientos();
                mostrarMenuAsientos();
                break;
            }
            case 'b': {
                char comprar=JOptionPane.showInputDialog("¿Desea comprar asientos?\n-Si\n-No").toLowerCase().charAt(0);
                la.comprarAsiento(comprar);
                mostrarMenuAsientos();
                break;
            }
            case 'c': {
                char editar=JOptionPane.showInputDialog("¿Desea editar un asiento?\n-Si\n-No").toLowerCase().charAt(0);
                la.editarAsiento(editar);
                mostrarMenuAsientos();
                break;
            }
            case 'd': {
                
                mostrarMenuAsientos();
                break;
            }
            case 'e': {
                la.mostrarAsientos();
                mostrarMenuAsientos();
                break;
            }
            case 's': {
                break;
            }
            default: {
                JOptionPane.showMessageDialog(null,
                        "Opción incorrecta!", "Error", JOptionPane.ERROR_MESSAGE);
                mostrarMenuAsientos();
            }
        }
    }

}
