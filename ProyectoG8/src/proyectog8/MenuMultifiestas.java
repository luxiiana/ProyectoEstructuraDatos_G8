package proyectog8;

import javax.swing.JOptionPane;

public class MenuMultifiestas {
    private int opc;
    //Menú de los usuarios
    MenuUsuarios mu = new MenuUsuarios();
    
    //Menú de los eventos
    MenuEventos me = new MenuEventos();
    
    //Menú de los asientos
     MenuAsientos ma = new MenuAsientos();
    
    
    public void mostrarMenuMultifiestas() {
        
        opc = Integer.parseInt(JOptionPane.showInputDialog(null,
                " ----𝐌𝐔𝐋𝐓𝐈𝐅𝐈𝐄𝐒𝐓𝐀𝐒----\n\n"
                +"Menu principal\n"
                + "1. Eventos\n" //Crear evento - editar evento - eliminar evento
                + "2. Comprar\n" //Comprar entrada - editar compra - eliminar compra
                + "3. Mostrar Ventas\n" //muestra arbol
                + "4. Salir\n\n"
                + "Digite su opción:"));
        
        switch (opc) {
            case 1:
                me.mostrarMenuEventos();
                mostrarMenuMultifiestas();
                break;

            case 2:
                //mostrar menu de compra
                mostrarMenuMultifiestas();
                break;

            case 3:
                //muestra datos del arbol
                mostrarMenuMultifiestas();
                break;
            case 4:
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
