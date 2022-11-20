package proyectog8;

public class Evento {
    
    private String nomEvento="";
    
    private int dia = 0;
    
    private char mes = ' ';
    
    private char ano = ' ';
    
    private char lugar = 0;
    
    public Evento(){
        this.nomEvento=null;
        this.dia=0;
        this.mes=' ';
        this.ano=' ';
        this.lugar=' ';
    }

    public String getNomEvento() {
        return nomEvento;
    }

    public void setNomEvento(String nomEvento) {
        this.nomEvento = nomEvento;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public char getMes() {
        return mes;
    }

    public void setMes(char mes) {
        this.mes = mes;
    }

    public char getAno() {
        return ano;
    }

    public void setAno(char ano) {
        this.ano = ano;
    }
    
    public char getLugar() {
        return lugar;
    }

    public void setLugar(char lugar) {
        this.lugar = lugar;
    }
    
}
