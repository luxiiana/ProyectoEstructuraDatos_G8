package proyectog8;

import javax.swing.JOptionPane;

public class menuArbol {

    char opc = ' ';

    listaEvento l = new listaEvento();
    arbolVentas a = new arbolVentas();

    public void menuArbol() {
        opc = JOptionPane.showInputDialog(null, "---MENÚ DE COMPRAS---\na. Ver eventos disponibles\nb. Comprar entrada\nc. Editar compra"
                + "\nd. Eliminar compra\ns. Salir al menú principal").toLowerCase().charAt(0);

        switch (opc) {
            case 'a':
                l.mostrarEventos();
                menuArbol();
                break;
            case 'b':
                a.agregarAlArbol();
                menuArbol();
                break;
            case 'c':
                //EN ESTA LINEA VA EL EDITAR
                menuArbol();
                break;
            case 'd':
                //EN ESTA LÍNEA VA EL ELIMINAR
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
