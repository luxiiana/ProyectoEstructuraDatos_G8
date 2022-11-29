package proyectog8;

import javax.swing.JOptionPane;

public class MenuPrincipal {
    private int opc;
    //Menú de los usuarios
    MenuUsuarios mu = new MenuUsuarios();
    
    //Menú de los eventos
    MenuEventos me = new MenuEventos();
    
    //Menú de los asientos
    MenuAsientos ma = new MenuAsientos();
    
    
    public void mostrarMenuPrincipal() {
        
        opc = Integer.parseInt(JOptionPane.showInputDialog(null,
                " ----𝐌𝐔𝐋𝐓𝐈𝐅𝐈𝐄𝐒𝐓𝐀𝐒----\n\n"
                +"Menu principal\n"
                + "1. Ver eventos\n"
                + "2. Ver asientos\n"
                + "3. Salir\n\n"
                + "Digite su opción:"));
        
        switch (opc) {
            case 1:
                me.mostrarMenuEventos();
                mostrarMenuPrincipal();
                break;

            case 2:
                ma.mostrarMenuAsientos();
                mostrarMenuPrincipal();
                break;

            case 3:
                //mu.mostrarMenuUsuarios();
                break;

            default:
                JOptionPane.showMessageDialog(null, "Opción inválida, intente de nuevo!");
                mostrarMenuPrincipal();
                break;

        }
    }  
}
