package proyectog8;

import javax.swing.JOptionPane;

public class MenuUsuarios {
    private int opc;
    private Lista c=new Lista();
    Dato d = new Dato();

    public void mostrarMenu() {
        
        opc = Integer.parseInt(JOptionPane.showInputDialog(null,
                "***USUARIOS***\n\n"
                + "1. Registrar usuario\n"
                + "2. Iniciar Sesion\n"
                + "3. Inactivar usuario\n"
                + "4. Volver al menú principal\n\n"
                + "Digite su opción:"));
        
        switch (opc) {
            case 1:
                c.agregar();
                mostrarMenu();
                break;

            case 2:
                c.mostrarLista();
                mostrarMenu();
                break;

            case 3:
                c.desactivarusuario();
                mostrarMenu();
                break;

            case 4:
                JOptionPane.showMessageDialog(null, "Volviendo al menú principal...");
                break;

            default:
                JOptionPane.showMessageDialog(null, "Opción inválida, revise!");
                mostrarMenu();
                break;

        }
    }
    
}
