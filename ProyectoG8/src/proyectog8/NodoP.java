/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectog8;

/**
 *
 * @author NIKY
 */
public class NodoP {
    private Dato elemento;
    private NodoP siguiente;

    public NodoP() {
        this.siguiente = null;
    }

    public Dato getElemento() {
        return elemento;
    }

    public void setElemento(Dato elemento) {
        this.elemento = elemento;
    }

    public NodoP getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoP siguiente) {
        this.siguiente = siguiente;
    }
}
