package proyectog8;

import javax.swing.JOptionPane;

public class MenuUsuarios {
    private char opc;
    private NodoC aux = null;
    private Lista c=new Lista();
    Dato d = new Dato();
    public void mostrarMenuUsuarios() {
    
        opc = JOptionPane.showInputDialog(null,
                " ----ππππππππππππ----\n\n"
                +"Menu principal\n"
                + "a. Registrar usuario\n"
                + "b. Iniciar Sesion\n"
                + "c. Eliminar usuario\n"
                + "s. Salir\n\n"
                + "Digite su opciΓ³n:").toLowerCase().charAt(0);
        
        switch (opc) {
            case 'a':
                aux = c.agregar(aux);
                mostrarMenuUsuarios();
                break;

            case 'b':
                c.iniciarSesion(aux);
                if(c.cont==0){
                    
                    mostrarMenuUsuarios();
                }
                c.cont = 0;
                break;

            case 'c':
                c.mostrarLista();
                c.desactivarusuario();
                mostrarMenuUsuarios();
                break;

            case 's':
                JOptionPane.showMessageDialog(null, "Gracias por usar el programa!");
                break;

            default:
                JOptionPane.showMessageDialog(null, "OpciΓ³n invΓ‘lida, intente de nuevo!");
                mostrarMenuUsuarios();
                break;

        }
    }
    
}
