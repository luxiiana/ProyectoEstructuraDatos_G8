package proyectog8;

public class arbolVentas {
    private NodoA raiz;
    /*
    Métodos que hay que hacer
    
    - Mostrar ventas: 
    
        "USER - EVENTO QUE COMPRA - ASIENTO - LO QUE PAGÓ"
    
    
    */
    
   public arbolVentas(){
       this.raiz=null;
   }
   
      public boolean EsVacio(){
       if(raiz==null){
           return true;
       }else{
           return false;
       }
   }
}
