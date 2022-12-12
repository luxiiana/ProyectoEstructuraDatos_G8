package proyectog8;

import javax.swing.JOptionPane;

public class MenuMultifiestas {
    private char opc;
    //Menú de los usuarios
    MenuUsuarios mu = new MenuUsuarios();
    
    //Menú de los eventos
    MenuEventos me = new MenuEventos();
    
    //Menú de los asientos
     MenuAsientos ma = new MenuAsientos();
     
     //Menú de árbol
     arbolVentas a =new arbolVentas();
     menuArbol mv =new menuArbol();
    
    public void mostrarMenuMultifiestas() {
        
        opc = JOptionPane.showInputDialog(null,
                " ----𝐌𝐔𝐋𝐓𝐈𝐅𝐈𝐄𝐒𝐓𝐀𝐒----\n\n"
                +"Menu principal\n"
                + "a. Eventos\n" //Crear evento - editar evento - eliminar evento
                + "b. Menu de compra\n" //Comprar entrada - editar compra - eliminar compra
                + "c. Mostrar ventas\n" //muestra arbol o ventas
                + "s. Salir\n\n"
                + "Digite su opción:").toLowerCase().charAt(0);
        
        switch (opc) {
            case 'a':
                me.mostrarMenuEventos();
                mostrarMenuMultifiestas();
                break;

            case 'b':
                mv.menuArbol();
                mostrarMenuMultifiestas();
                break;

            case 'c':
                a.mostrarRaiz();
                mostrarMenuMultifiestas();
                break;
            case 's':
                JOptionPane.showMessageDialog(null, "Cerrando sesión");
                mu.mostrarMenuUsuarios();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción inválida, intente de nuevo!");
                mostrarMenuMultifiestas();
                break;

        }
    }  
}
