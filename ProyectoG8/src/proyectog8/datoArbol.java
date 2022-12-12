package proyectog8;

public class datoArbol {
    
    private String evento ="";
    private int asiento=0;
    private String usuario="";
    
    public datoArbol(){
        this.evento=null;
        this.asiento=0;
        this.usuario=null;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public int getAsiento() {
        return asiento;
    }

    public void setAsiento(int asiento) {
        this.asiento = asiento;
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
}
