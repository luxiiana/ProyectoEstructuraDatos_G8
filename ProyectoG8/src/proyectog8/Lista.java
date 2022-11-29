
package proyectog8;

import javax.swing.JOptionPane;

public class Lista {
    private NodoC inicio;
    private NodoC aux;
    public int cont = 0;
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
   
   public NodoC agregar(NodoC nuevo){
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
      
      nuevo = new NodoC();
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
      return aux;
   } 
   
   public void desactivarusuario(){
       if(!esVaciaC()){
         String nomb=JOptionPane.showInputDialog(null,"Digite el nombre del usuario a eliminar:");
         if(inicio.getElemento().getNombre().equals(nomb)){
            inicio=inicio.getSiguiente();
            JOptionPane.showMessageDialog(null,"¡Usuario eliminado!");
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
   
   public void iniciarSesion(NodoC aux){
       MenuPrincipal me = new MenuPrincipal();
       MenuUsuarios meu = new MenuUsuarios();
       String nickb=JOptionPane.showInputDialog(null,"Digite su nickname: ");
       String contrab=JOptionPane.showInputDialog(null,"Digite su contraseña:");
       aux = inicio;
           while(aux!=null){
               if((aux.getElemento().getNickname().equals(nickb)&& aux.getElemento().getContrasena().equals(contrab))){
                   cont = 1;
                   me.mostrarMenuPrincipal();
               }
               else{
                   JOptionPane.showMessageDialog(null,"¡Usuario o contraseña incorrecta!");   
                   //meu.mostrarMenuUsuarios();
               }
               aux = aux.getSiguiente();
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
         JOptionPane.showMessageDialog(null,"¡No hay usuarios registrados!");
      }
   } 
   
   
}
