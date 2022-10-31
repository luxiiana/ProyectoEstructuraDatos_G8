package proyectog8;

import javax.swing.JOptionPane;

public class listaEvento {
    
    private nodoEvento inicio;
    private nodoEvento fin;
    
    public listaEvento(){
        this.inicio=null;
        this.fin=null;
    }
    
    public boolean esVacio(){
        if(inicio==null){
            return true;
        }else{
            return false;
        }
    }
    
    public void agregarEvento(String nombreEvento, int fecha, String lugar){
        //se crea objeto para nuestros datos
        Evento e = new Evento();
        
        //llenamos con los datos al objeto
        e.setNombreEvento(JOptionPane.showInputDialog("Ingrese el nombre del evento: "));
        e.setFecha(Integer.parseInt(JOptionPane.showInputDialog("Ingrese la fecha del evento de la siguiente forma: \nEjemplo: 1 de enero, 2010\nDebe escribirlo así: 20100101")));
        e.setLugar(JOptionPane.showInputDialog("Ingrese el lugar del evento: "));
        
        //se crea el objeto del nodo 
        nodoEvento ne = new nodoEvento();
        //se establece que nuestro nodo contiene los datos del primer objeto que creamos
        ne.setDato(e);
        
        if(esVacio()){ //agregar al inicio
            
            //establecer el primer nodo
            inicio=ne;
            fin=ne;
            
            //referencia circular 
            fin.setSiguiente(inicio);
            
        }
        
    }
    
}
