package proyectog8;

public class Evento {
    
    private String nombreEvento="";
    
    private int fecha = 0;
    
    private String lugar="";
    
    public Evento(){
        this.nombreEvento=null;
        this.fecha=0;
        this.lugar="";
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public int getFecha() {
        return fecha;
    }

    public void setFecha(int fecha) {
        this.fecha = fecha;
    }
    
    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

}
