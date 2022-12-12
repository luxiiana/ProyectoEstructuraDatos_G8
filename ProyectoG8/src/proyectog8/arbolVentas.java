package proyectog8;

import javax.swing.JOptionPane;

public class arbolVentas {
    
    private NodoA raiz;
    public nodoEvento inicio;
    
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

        //---OBJETOS----
        listaEvento l = new listaEvento();
        ListaAsientos la = new ListaAsientos();
        Asientos a = new Asientos();
        Dato d = new Dato();
        datoArbol da = new datoArbol();

        //---INGRESAR DATOS---
        do {
            da.setEvento(JOptionPane.showInputDialog("Ingrese el evento al que desea asistir: ")); //evento
            if (!l.existe(da.getEvento())) {
                JOptionPane.showMessageDialog(null, "No existe el evento");
            }
        } while (!l.existe(da.getEvento()));
        
        la.comprarAsiento(); //comprar asiento
        da.setAsiento(a.getNumAsiento()); //guardar número de asiento en nodo arbol
        da.setUsuario(d.getNickname()); //guardar nickname en usuario
        
        NodoA nuevo = new NodoA();
        nuevo.setElemento(da); //nodo del árbol
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
            System.out.println(raiz.getElemento().getUsuario());
            System.out.println(raiz.getElemento().getEvento());
            System.out.println(raiz.getElemento().getAsiento());
            
            mostrarNodo(raiz.getEnladeDer());
        }
        
    }
    
    public void modificarArbol() {
        listaEvento l = new listaEvento();
        String evento;
        if (raiz.getEnladeDer() != null) {
            do {
                evento = JOptionPane.showInputDialog("Ingrese el nombre del evento que compro para editarlo:\n");
            } while (!l.existe(evento));
        } else {
            if (raiz.getEnlaceIzq() != null) {
                do {
                    evento = JOptionPane.showInputDialog("Ingrese el nombre del evento que compro para editarlo:\n");
                } while (!l.existe(evento));
            }
        }
        
    }
    
    public void eliminar() {
        listaEvento l = new listaEvento();
        String evento = "";
        
        do {
            evento = JOptionPane.showInputDialog("Ingrese el evento que desea eliminar:\n");
        } while (!l.existe(evento));
        
        NodoA aux = raiz;
        if (aux != null) {
            eliminarNodo(aux, evento);
            JOptionPane.showMessageDialog(null, "Evento eliminado");
        } else {
            JOptionPane.showMessageDialog(null, "No hay eventos...");
        }
    }
    
    public void eliminarNodo(NodoA nuevo, String evento) {
        
        if (evento.equals(nuevo.getElemento().getEvento())) {
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
                            
                            temp.setEnlaceIzq(raiz.getEnlaceIzq());
                            //temp.getEnlaceIzq(raiz.getEnlaceIzq());

                        }
                        
                    }
                }
            }
        }
        
    }
    
    public NodoA sucesor(NodoA raiz) {
        if (raiz.getEnlaceIzq() != null) {
            return sucesor(raiz.getEnlaceIzq());
        }
        return raiz;
        
    }
    
}
