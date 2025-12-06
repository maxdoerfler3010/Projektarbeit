package Projektarbeit;

public class Schuhe {
    private String marke;
    private int groesse;
    private double preis;
    private String material;

    public Schuhe (String marke, int groesse, double preis, String material) {
        this.marke = marke;
        this.groesse = groesse;
        this.preis = preis;
        this.material = material;
    }

    public double berechnePreisNachlass (double prozent){
        preis = preis * (1 - prozent / 100);
        return preis;
    }

    public void initObjekte() {
    }
}
