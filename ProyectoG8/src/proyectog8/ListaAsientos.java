
package proyectog8;

import javax.swing.JOptionPane;

/**
 *
 * @author Fabian
 */
public class ListaAsientos {
    private nodoAsiento inicio;
   private nodoAsiento fin;
   
   public ListaAsientos(){
       this.inicio=null;
       this.fin=null;
        
   }
   
   public boolean esVacia(){
      if(inicio==null){
         return true;
      }else{
         return false;
      }
   
}
   public void agregarAsiento(){
       Asientos a=new Asientos();
       a.setCodArea(JOptionPane.showInputDialog("digite el codigo de area"));
       a.setPreNor(' ');
       a.setNumAsiento(Integer.parseInt(JOptionPane.showInputDialog("digite el numero de asiento ")));
       a.setCosto(Double.parseDouble(JOptionPane.showInputDialog("digite el costo ")));
       a.setLibOcu(' ');
       nodoAsiento nuevo = new nodoAsiento();
       nuevo.setDato(a);
       if(esVacia()){
           inicio=nuevo;
         fin=nuevo; 
         fin.setSiguiente(inicio);
         inicio.setAnterior(fin);
       }else if(a.getNumAsiento()<inicio.getDato().getNumAsiento()){
           nuevo.setSiguiente(inicio);
         inicio=nuevo;
         fin.setSiguiente(inicio);
         inicio.setAnterior(fin);
       }else if(a.getNumAsiento()>=fin.getDato().getNumAsiento()){
           fin.setSiguiente(nuevo);
         fin=nuevo;   
         fin.setSiguiente(inicio);  
         inicio.setAnterior(fin);
       }else{
           nodoAsiento aux=inicio;
           while(aux.getSiguiente().getDato().getNumAsiento()<a.getNumAsiento()){
               aux=aux.getSiguiente();
           }
           nuevo.setSiguiente(aux.getSiguiente());
         nuevo.setAnterior(aux);
         aux.setSiguiente(nuevo);
         nuevo.getSiguiente().setAnterior(nuevo);
       }
       
   }
   
   

}
