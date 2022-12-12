
package proyectog8;


public class NodoA {
    private datoArbol elemento;
    private NodoA enlaceIzq;
    private NodoA enladeDer;
    
    
    public NodoA(){
        this.elemento=null;
        this.enlaceIzq=null;
        this.enladeDer=null;
        
    }

    public datoArbol getElemento() {
        return elemento;
    }

    public void setElemento(datoArbol elemento) {
        this.elemento = elemento;
    }

    public NodoA getEnlaceIzq() {
        return enlaceIzq;
    }

    public void setEnlaceIzq(NodoA enlaceIzq) {
        this.enlaceIzq = enlaceIzq;
    }

    public NodoA getEnladeDer() {
        return enladeDer;
    }

    public void setEnladeDer(NodoA enladeDer) {
        this.enladeDer = enladeDer;
    }
    
}
