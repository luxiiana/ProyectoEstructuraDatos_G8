package proyectog8;

public class datoArbol {
    
    private String evento ="";
    private String asiento="";
    private String usuario="";
    
    public datoArbol(){
        this.evento=null;
        this.asiento=null;
        this.usuario=null;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public String getEvento() {
        return evento;
    }
    
    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
}
