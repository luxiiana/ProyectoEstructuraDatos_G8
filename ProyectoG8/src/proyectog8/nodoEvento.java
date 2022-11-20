package proyectog8;

public class nodoEvento {
    
    private Evento elemento;
    
    private nodoEvento siguiente;
    
    public nodoEvento(){
        this.elemento=null;
        this.siguiente=null;
    }

    public Evento getElemento() {
        return elemento;
    }

    public void setElemento(Evento elemento) {
        this.elemento = elemento;
    }

    public nodoEvento getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(nodoEvento siguiente) {
        this.siguiente = siguiente;
    }
    
}
