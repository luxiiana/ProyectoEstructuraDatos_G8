package proyectog8;

public class nodoEvento {
    
    private Evento dato;
    private nodoEvento siguiente;
    
    public nodoEvento(){
        this.dato=null;
        this.siguiente=null;
    }

    public Evento getDato() {
        return dato;
    }

    public void setDato(Evento dato) {
        this.dato = dato;
    }

    public nodoEvento getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(nodoEvento siguiente) {
        this.siguiente = siguiente;
    }
    
}
