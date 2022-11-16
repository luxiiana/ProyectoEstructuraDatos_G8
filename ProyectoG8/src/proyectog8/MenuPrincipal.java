package proyectog8;

import javax.swing.JOptionPane;

public class MenuPrincipal {
    //Menú de los usuarios
    MenuUsuarios mu = new MenuUsuarios();
    
    //Menú de los eventos
    MenuEventos me = new MenuEventos();
    
    //Menú de los asientos
    
    
    char opc = ' ';
    
    public void MenuP(){
        
        opc=JOptionPane.showInputDialog("MULTIFIESTAS\n---MENU PRINCIPAL---\na. Ver opciones para usuarios\nb.Ver opciones para eventos"
                + "\nc.Ver opciones para asientos\ns. SALIR").toLowerCase().charAt(0);
        
        switch(opc){
            case 'a':
                mu.mostrarMenu(); //muestra el menu de los usuarios
                MenuP();
                break;
            case 'b':
                me.mostrarMenu(); //muestra el menu de los eventos
                MenuP();
                break;
            case 'c':
                MenuP();
                break;
            case 's':
                JOptionPane.showMessageDialog(null, "Gracias por usar el programa!");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción inválida...Intentelo de nuevo...");
                MenuP();
                break;
        }
        
    }
    
}
