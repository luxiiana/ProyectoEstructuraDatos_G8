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
        ListaAsientos la = new ListaAsientos();
        Asientos a = new Asientos();
        datoArbol da = new datoArbol();

        //---INGRESAR DATOS---
        da.setUsuario(JOptionPane.showInputDialog("Ingrese su nombre: ")); //usuario
        da.setEvento(JOptionPane.showInputDialog("Ingrese el evento al que desea asistir: ")); //evento
        da.setAsiento(JOptionPane.showInputDialog("Ingrese uno de sus asientos para confirmar asistencia: ")); //asiento
        
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
        if (!EsVacio()) {
            mostrarNodo(raiz);
        } else {
            JOptionPane.showMessageDialog(null, "No se puede mostrar, no hay ventas...");
        }
    }

    public void mostrarNodo(NodoA raiz) {
        if (raiz != null) {
            mostrarNodo(raiz.getEnlaceIzq());
            System.out.print("Nombre: "+raiz.getElemento().getUsuario()+"---- Evento: "+raiz.getElemento().getEvento()+"---- Asiento: "+raiz.getElemento().getAsiento()+"===>");
            mostrarNodo(raiz.getEnladeDer());
        }

    }

    public void modificarArbol() {
        
        char opc =JOptionPane.showInputDialog("¿Qué va a editar?\na. Nombre\nb. Evento\nc. Asiento\ns. SALIR DE EDICIÓN").toLowerCase().charAt(0);
        String dato;
        
        switch(opc){
            case 'a':
                dato=JOptionPane.showInputDialog("Ingrese el nombre: ");
                cambiarNombre(dato);
                break;
            case 'b':
                dato=JOptionPane.showInputDialog("Ingrese el evento: ");
                cambiarEvento(dato);
                break;
            case 'c':
                dato=JOptionPane.showInputDialog("Ingrese el asiento: ");
                cambiarAsiento(dato);
                break;
            case 's':
                JOptionPane.showMessageDialog(null, "Saliendo...");
                break;
        }
        
    }
    
    public NodoA cambiarNombre(String dato){
        NodoA aux=raiz;
        while(!aux.getElemento().getUsuario().equals(dato)){
            if(aux.getElemento().getUsuario().compareTo(dato)>0){
                aux=aux.getEnlaceIzq();
            }else{
                aux=aux.getEnladeDer();
            }
            if(aux==null){
                JOptionPane.showMessageDialog(null, "Dato no encontrado");
                return null;
            }
        }
        String nuevoNombre=JOptionPane.showInputDialog("Ingrese el nuevo nombre: ");
        aux.getElemento().setUsuario(nuevoNombre);
        return aux;
    }
    
    public NodoA cambiarEvento(String dato){
        NodoA aux=raiz;
        while(!aux.getElemento().getEvento().equals(dato)){
            if(aux.getElemento().getEvento().compareTo(dato)>0){
                aux=aux.getEnlaceIzq();
            }else{
                aux=aux.getEnladeDer();
            }
            if(aux==null){
                JOptionPane.showMessageDialog(null, "Dato no encontrado");
                return null;
            }
        }
        String nuevoEvento=JOptionPane.showInputDialog("Ingrese el nuevo evento: ");
        aux.getElemento().setEvento(nuevoEvento);
        return aux;
    }
    
    public NodoA cambiarAsiento(String dato){
        NodoA aux=raiz;
        while(!aux.getElemento().getAsiento().equals(dato)){
            if(aux.getElemento().getAsiento().compareTo(dato)>0){
                aux=aux.getEnlaceIzq();
            }else{
                aux=aux.getEnladeDer();
            }
            if(aux==null){
                JOptionPane.showMessageDialog(null, "Dato no encontrado");
                return null;
            }
        }
        String nuevoAsiento=JOptionPane.showInputDialog("Ingrese su nuevo asiento: ");
        aux.getElemento().setAsiento(nuevoAsiento);
        return aux;
    }
    
    public void eliminar(){
        if (!EsVacio()) {
            raiz = null;
        } else {
            JOptionPane.showMessageDialog(null, "No datos para eliminar...");
        }
    }

}
