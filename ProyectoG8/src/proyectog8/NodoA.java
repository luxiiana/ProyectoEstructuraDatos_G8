
package proyectog8;


public class NodoA {
     private Dato elemento;
    private NodoA enlaceIzq;
    private NodoA enladeDer;
    
    
    public NodoA(){
        this.enlaceIzq=null;
        this.enladeDer=null;
        
    }

    public Dato getElemento() {
        return elemento;
    }

    public void setElemento(Dato elemento) {
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
