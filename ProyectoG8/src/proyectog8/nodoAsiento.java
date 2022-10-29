package proyectog8;

public class nodoAsiento {
    
    private Asientos dato;
    private nodoAsiento siguiente;
    
    public nodoAsiento(){
        this.dato=null;
        this.siguiente=null;
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
    
}
