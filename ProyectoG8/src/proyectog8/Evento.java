package proyectog8;

public class Evento {
    
    private String nombreEvento="";
    
    private String fecha = "";
    
    private String lugar="";
    
    public Evento(){
        this.nombreEvento=null;
        this.fecha=null;
        this.lugar="";
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

}
