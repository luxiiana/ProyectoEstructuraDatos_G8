package proyectog8;

import javax.swing.JOptionPane;

public class MenuEventos {
    
    char opc = ' ';
    Evento e = new Evento();
    
    public void mostrarMenuEventos(){
        
        opc=JOptionPane.showInputDialog("---COMPRAR ENTRADA---\n\na. Ver lista de eventos\nb. Comprar entradas para evento").charAt(0);
        
    }
    
}
