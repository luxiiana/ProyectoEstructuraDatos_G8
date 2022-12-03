package proyectog8;

import javax.swing.JOptionPane;

public class MenuEventos {
    
    char opc = ' ';
    Evento e = new Evento();
    listaEvento l = new listaEvento();
    
    public void mostrarMenuEventos(){
        
        opc=JOptionPane.showInputDialog("---EVENTOS---\n\na. Crear evento\nb. Editar evento"
                + "\nc. Eliminar evento\ns. SALIR").toLowerCase().charAt(0);
        
        switch(opc){
            case 'a':
                char crear=JOptionPane.showInputDialog("¿Desea crear un evento?\n-Sí\n-No").toLowerCase().charAt(0);
                l.crearEvento(crear);
                break;
            case 'b':
                char editar =JOptionPane.showInputDialog("¿Desea editar un evento?\n-Si\n-No").toLowerCase().charAt(0);
                l.editarEvento(editar);
                break;
            case 'c':
                char eliminar=JOptionPane.showInputDialog("¿Desea eliminar un evento?\n-Si\n-No").toLowerCase().charAt(0);
                l.eliminarEventos(eliminar);
                break;
            case 's':
                JOptionPane.showMessageDialog(null, "Saliendo...");
                break;
        }
        
    }
    
}
