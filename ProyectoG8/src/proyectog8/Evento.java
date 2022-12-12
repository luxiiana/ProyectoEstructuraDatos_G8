package proyectog8;

public class Evento {
    
    private String nomEvento="";
    
    private int dia = 0;
    
    private int mes = 0;
    
    private int ano = 0;
    
    private char lugar = ' ';
    
    public Evento(){
        this.nomEvento=null;
        this.dia=0;
        this.mes=0;
        this.ano=0;
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

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
    
    public char getLugar() {
        return lugar;
    }

    public void setLugar(char lugar) {
        this.lugar = lugar;
    }
    
}
