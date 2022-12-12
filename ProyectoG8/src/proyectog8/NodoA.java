
package proyectog8;


public class NodoA {
     private Dato usuario;
     private Evento evento;
     private Asientos asiento;
    private NodoA enlaceIzq;
    private NodoA enladeDer;
    
    
    public NodoA(){
        this.enlaceIzq=null;
        this.enladeDer=null;
        
    }

    public Dato getUsuario() {
        return usuario;
    }

    public Evento getEvento() {
        return evento;
    }

    public Asientos getAsiento() {
        return asiento;
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

    void getEnlaceIzq(NodoA enlaceIzq) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
