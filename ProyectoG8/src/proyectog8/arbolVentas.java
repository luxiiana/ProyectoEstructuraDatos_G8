package proyectog8;

import javax.swing.JOptionPane;

public class arbolVentas {

    private NodoA raiz;

    /*
    Métodos que hay que hacer
    
    - Mostrar ventas: 
    
        "USER - EVENTO QUE COMPRA - ASIENTO - LO QUE PAGÓ"
    
    
     */
    public arbolVentas() {
        this.raiz = null;
    }

    public boolean EsVacio() {
        if (raiz == null) {
            return true;
        } else {
            return false;
        }
    }

    public void agregarAlArbol() {
        Dato d = new Dato();
        Evento e = new Evento();
        Asientos a = new Asientos();
        d.getNickname(); //esto está bien, es el usuario
        e.getNomEvento(); //esto no, el usuario ingresa uno y debe verificar que conincida con los eventos que ya existen
        a.getNumAsiento(); //acá debería elegir el asiento
        NodoA nuevo = new NodoA();
        if (EsVacio()) {
            raiz = nuevo;
        } else {
            insertarNuevo(raiz, nuevo);
        }

    }

    public void insertarNuevo(NodoA raiz, NodoA nuevo) {
        if (raiz.getEnlaceIzq() == null) {
            raiz.setEnlaceIzq(nuevo);
        } else {
            insertarNuevo(raiz.getEnlaceIzq(), nuevo);
        }
        if (raiz.getEnladeDer() == null && raiz.getEnlaceIzq() != null) {
            raiz.setEnladeDer(nuevo);
        } else {
            insertarNuevo(raiz.getEnladeDer(), nuevo);
        }
    }

    public void mostrarRaiz() {
        if (EsVacio()) {
            mostrarNodo(raiz);
        } else {
            JOptionPane.showMessageDialog(null, "no se puede mostrar, no hay eventos");
        }
    }

    public void mostrarNodo(NodoA raiz) {
        if (raiz != null) {
            mostrarNodo(raiz.getEnlaceIzq());
            System.out.println(raiz.getUsuario().getNombre());
            System.out.println(raiz.getEvento().getNomEvento());
            System.out.println(raiz.getAsiento().getNumAsiento());

            mostrarNodo(raiz.getEnladeDer());
        }

    }

    public NodoA eliminarNodo(NodoA nuevo, Evento evento) {
        if (raiz != null) {
            if (evento.equals(nuevo.getEvento())) {
                if (raiz.getEnlaceIzq() == null && raiz.getEnladeDer() == null) {
                    nuevo = null;
                } else {
                    if (raiz.getEnlaceIzq() == null && raiz.getEnladeDer() != null) {
                        nuevo = nuevo.getEnladeDer();
                    } else {
                        if (raiz.getEnlaceIzq() != null && raiz.getEnladeDer() == null) {
                            nuevo = nuevo.getEnlaceIzq();
                        } else {
                            if (raiz.getEnlaceIzq() != null && raiz.getEnladeDer() != null) {
                                NodoA der = raiz.getEnladeDer();
                                NodoA temp = sucesor(der);

                                temp.getEnlaceIzq(raiz.getEnlaceIzq());
                                return temp;
                            }

                        }
                    }
                }
                {

                }
            }
        }
        return raiz;
    }

    public NodoA sucesor(NodoA raiz) {
        if (raiz.getEnlaceIzq() != null) {
            return sucesor(raiz.getEnlaceIzq());
        }
        return raiz;

    }

}
