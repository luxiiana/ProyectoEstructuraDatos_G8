package proyectog8;

import javax.swing.JOptionPane;

public class MenuEventos {
    
    Evento e = new Evento();
    listaEvento l = new listaEvento();
    
    char opc = ' ';
    
    public void mostrarMenu(){
        
        opc=JOptionPane.showInputDialog("---EVENTOS---\na. Agregar un evento\nb.Eliminar un evento\nc. Mostrar lista de eventos"
                + "\ns. SALIR AL MENÚ PRINCIPAL").toLowerCase().charAt(0);
        
        switch(opc){
            case 'a':
                int numEventos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de eventos que agregará: "));
                l.agregarEvento(numEventos);
                mostrarMenu();
                break;
            case 'b':
                mostrarMenu();
                break;
            case 'c':
                l.mostrarEventos();
                mostrarMenu();
                break;
            case 's':
                JOptionPane.showMessageDialog(null, "Volviendo al menú principal...");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción inválida...intentelo de nuevo");
                mostrarMenu();
                break;
        }
        
    }
    
}
