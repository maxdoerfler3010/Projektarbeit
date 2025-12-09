package Projektarbeit;
import java.util.ArrayList;

public class Schuhe {
    String marke;
    private int groesse;
    private double preis;
    private boolean istWasserdicht;

    public Schuhe (String marke, int groesse, double preis, boolean istWasserdicht) {
        this.marke = marke;
        this.groesse = groesse;
        this.preis = preis;
        this.istWasserdicht = istWasserdicht;
    }

//Methode zur Berechnung eines Preisnachlasses
    public double berechnePreisNachlass (double prozent){
        preis = preis * (1 - prozent / 100);
        return preis;
    }


}
