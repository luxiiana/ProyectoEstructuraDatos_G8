package proyectog8;

public class Asientos {
    
    private String codArea=""; 
    private char preNor = ' ';
    private int numAsiento=0;
    private double costo=0;
    private char libOcu=' ';
    
    public Asientos(){
        this.codArea=null;
        this.preNor=' ';
        this.numAsiento=0;
        this.costo=0;
        this.libOcu=' ';
    }

    public String getCodArea() {
        return codArea;
    }

    public void setCodArea(String codArea) {
        this.codArea = codArea;
    }

    public char getPreNor() {
        return preNor;
    }

    public void setPreNor(char preNor) {
        this.preNor = preNor;
    }

    public int getNumAsiento() {
        return numAsiento;
    }

    public void setNumAsiento(int numAsiento) {
        this.numAsiento = numAsiento;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public char getLibOcu() {
        return libOcu;
    }

    public void setLibOcu(char libOcu) {
        this.libOcu = libOcu;
    }
    
}
