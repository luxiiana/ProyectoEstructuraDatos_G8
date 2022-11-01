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
    
    public int agregarEvento(int numEventos){
        
        numEventos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de eventos que agregará: "));
        
        if(numEventos==0){
            return 0;
        }else{
            //se crea objeto para nuestros datos
            Evento e = new Evento();

            //llenamos con los datos al objeto
            e.setNombreEvento(JOptionPane.showInputDialog("Ingrese el nombre del evento: "));
            e.setFecha(JOptionPane.showInputDialog("Ingrese la fecha del evento de la siguiente forma: \nEjemplo: 1 de enero, 2000\n"));
            e.setLugar(JOptionPane.showInputDialog("Ingrese el lugar del evento: "));

            //se crea el objeto del nodo 
            nodoEvento ne = new nodoEvento();
            //se establece que nuestro nodo contiene los datos del primer objeto que creamos
            ne.setDato(e);
            
            if(esVacio()){ //agregar si está vacío

                //si el nodo de inicio es vacio (no tiene lugar ni fecha) entonces podemos agregar el evento

                //agregar al inicio
                inicio=ne;
                fin=ne;

                //referencia circular 
                fin.setSiguiente(inicio);

            }else if(e.getFecha().compareTo(inicio.getDato().getFecha()) <0){ //agregar a la izquierda

                //si el dato de fecha es mayor a la fecha del inicio, el inicio pasa a siguiente y el inicio será el nuevo nodo
                inicio.setSiguiente(inicio);
                inicio=ne;

                //referenica circular
                fin.setSiguiente(inicio);

            }else if(inicio.getDato().getFecha().compareTo(e.getFecha()) <0){ //agregar a la derecha
                
                //el dato que le sigue a inicio será el nodo nuevo
                inicio.setSiguiente(ne);
                
                //referencia circular
                fin.setSiguiente(inicio);
                
            }else{ //agrega en medio
                
            }
            
            //recursividad, la cantidad de eventos que dijimos al inicio va a disminuir hasta llegar al caso base
            numEventos--;
            return (agregarEvento(numEventos));
        }
        
        
        
    }
    
}
