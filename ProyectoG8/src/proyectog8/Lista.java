/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectog8;

import javax.swing.JOptionPane;

/**
 *
 * @author NIKY
 */
public class Lista {
    private NodoC inicio;

   public Lista(){
     this.inicio=null;
   } 
   public boolean esVaciaC(){
      if(inicio==null){
         return true;
      }else{
         return false;
      }
   }
   
   public void agregar(){
      Dato d=new Dato();
      d.setNombre(JOptionPane.showInputDialog(null,
            "Ingrese su nombre:"));
      d.setApellidos(JOptionPane.showInputDialog(null,
            "Ingrese sus apellidos:"));
      d.setNickname(JOptionPane.showInputDialog(null,
            "Ingrese su nickname:"));
      d.setContrasena(JOptionPane.showInputDialog(null,
            "Ingrese su contraseña:"));
      d.setEstado(JOptionPane.showInputDialog(null,
            "Ingrese su estado activo/inactivo:"));
      
      NodoC nuevo=new NodoC();
      nuevo.setElemento(d);
      if(esVaciaC()){
         inicio=nuevo;
      }else if(inicio.getSiguiente()==null){
         inicio.setSiguiente(nuevo);
      }else{
          NodoC aux = inicio;
          nuevo.setSiguiente(aux.getSiguiente());
          aux.setSiguiente(nuevo);
      }
   } 
   
   public void inactivarusuario(){
       if(!esVaciaC()){
         String nomb=JOptionPane.showInputDialog(null,"Digite el nombre del usuario a eliminar:");
         if(inicio.getElemento().getNombre().equals(nomb)){
            inicio=inicio.getSiguiente();
            JOptionPane.showMessageDialog(null,"¡Elemento extraído!");
         }else{
            NodoC anterior;
            NodoC auxiliar;
            anterior=inicio;
            auxiliar=inicio.getSiguiente();
            while((auxiliar!=null)&&(!auxiliar.getElemento().getNombre().equals(nomb))){
                anterior=anterior.getSiguiente();
                auxiliar=auxiliar.getSiguiente();
            }
            if(auxiliar!=null){
               anterior.setSiguiente(auxiliar.getSiguiente());
            }
         }
      }
   }
   
   
   public void mostrarLista(){
      if(!esVaciaC()){
         String s="";
         NodoC aux=inicio;
         while(aux!=null){
            s=s+aux.getElemento().getNombre()+"\n"+aux.getElemento().getApellidos()+"\n"+aux.getElemento().getNickname()+
                    "\n"+aux.getElemento().getContrasena()+"\n"+aux.getElemento().getEstado()+"\n\n\n";
            aux=aux.getSiguiente();
         }
         JOptionPane.showMessageDialog(null,"La lista contiene:\n"+s);
      }else{
         JOptionPane.showMessageDialog(null,"¡No se puede mostrar, lista vacía!");
      }
   } 
    
}
