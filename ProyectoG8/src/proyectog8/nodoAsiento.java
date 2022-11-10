package proyectog8;

public class nodoAsiento {
    
    private Asientos dato;
    private nodoAsiento siguiente;
    private nodoAsiento anterior;
    
    public nodoAsiento(){
        this.dato=null;
        this.siguiente=null;
        this.anterior=null;
    }

    public Asientos getDato() {
        return dato;
    }

    public void setDato(Asientos dato) {
        this.dato = dato;
    }

    public nodoAsiento getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(nodoAsiento siguiente) {
        this.siguiente = siguiente;
        
        
    }

    public nodoAsiento getAnterior() {
        return anterior;
    }

    public void setAnterior(nodoAsiento anterior) {
        this.anterior = anterior;
    }
    
}
