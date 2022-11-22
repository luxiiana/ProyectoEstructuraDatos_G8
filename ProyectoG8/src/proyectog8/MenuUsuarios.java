package proyectog8;

import javax.swing.JOptionPane;

public class MenuUsuarios {
    private int opc;
    private Lista c=new Lista();
    Dato d = new Dato();

    public void mostrarMenuUsuarios() {
        
        opc = Integer.parseInt(JOptionPane.showInputDialog(null,
                " ----𝐌𝐔𝐋𝐓𝐈𝐅𝐈𝐄𝐒𝐓𝐀𝐒----\n\n"
                +"Menu principal\n"
                + "1. Registrar usuario\n"
                + "2. Iniciar Sesion\n"
                + "3. Inactivar usuario\n"
                + "4. Salir\n\n"
                + "Digite su opción:"));
        
        switch (opc) {
            case 1:
                c.agregar();
                mostrarMenuUsuarios();
                break;

            case 2:
                c.iniciarSesion();
                break;

            case 3:
                c.mostrarLista();
                c.desactivarusuario();
                mostrarMenuUsuarios();
                break;

            case 4:
                JOptionPane.showMessageDialog(null, "Gracias por usar el programa!");
                break;

            default:
                JOptionPane.showMessageDialog(null, "Opción inválida, intente de nuevo!");
                mostrarMenuUsuarios();
                break;

        }
    }
    
}
