package proyectog8;

import javax.swing.JOptionPane;

public class menuArbol {

    char opc = ' ';
    
    
    arbolVentas a = new arbolVentas();

    public void menuArbol() {
        opc = JOptionPane.showInputDialog(null, "---MENÚ DE COMPRAS---\na. Comprar entrada\nb. Editar compra"
                + "\nc. Eliminar compra\nd. Mostrar compras\ns. Salir al menú principal").toLowerCase().charAt(0);

        switch (opc) {
            case 'a':
                a.agregarAlArbol();
                menuArbol();
                break;
            case 'b':
                a.modificarArbol();
                menuArbol();
                break;
            case 'c':
                a.eliminar();
                menuArbol();
                break;
            case 'd':
                a.mostrarRaiz();
                menuArbol();
                break;
            case 's':
                JOptionPane.showMessageDialog(null, "Volviendo al menú principal...");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Intente de nuevo...");
                menuArbol();
                break;
        }
    }
}
