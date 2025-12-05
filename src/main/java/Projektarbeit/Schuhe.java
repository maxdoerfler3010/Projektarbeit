package Projektarbeit;

public class Schuhe {
    private String marke;
    private int groesse;
    private double preis;
    private String material;
    private boolean istWasserdicht;

    public Schuhe(String marke, int groesse, double preis, String material, boolean istWasserdicht) {
        this.marke = marke;
        this.groesse = groesse;
        this.preis = preis;
        this.material = material;
        this.istWasserdicht = istWasserdicht;
    }

    public double brechnePreisNachlass (double prozent){
        prozent = 20;
        preis = preis * (prozent / 100);
        return preis;
    }
}
