package Projektarbeit;
import java.util.ArrayList;

public class Schuhe {
    String marke;
    private int groesse;
    private double preis;
    private boolean istWasserdicht;
    private double alterPreis;   // <---- NEU


    public Schuhe (String marke, int groesse, double preis, boolean istWasserdicht) {
        this.marke = marke;
        this.groesse = groesse;
        this.preis = preis;
        this.alterPreis = preis;   // <---- alten Preis merken
        this.istWasserdicht = istWasserdicht;
    }


//Getter hinzufügen, damit das Filtern funktioniert
    public String getMarke() {
    return marke;
    }

    public int getGroesse() {
    return groesse;
    }

    public double getPreis() {
    return preis;
    }

    public boolean istWasserdicht() {
    return istWasserdicht;
    }

    // Rabatt anwenden (factor z.B. 0.9 für 10%)
    public void applyDiscount(double factor) {
        if (factor <= 0 || factor > 1) return;
        this.alterPreis = this.preis;     // alten Preis sichern
        this.preis = this.preis * factor; // neuen Preis setzen
    }


    @Override
    public String toString(){
        String preisText = String.format("%.2f €", preis);
        if (alterPreis != preis) {
            preisText += "\n(Regulärer Preis: " + String.format("%.2f €", alterPreis) + ")";
        }
        return "Marke: " + marke +
                "\nGröße: " + groesse +
                "\nPreis: " + preisText +
                "\n" + (istWasserdicht ? "Ist wasserdicht" : "Ist nicht wasserdicht");
    }



    public boolean contains(String ausgewaehlteMarke) {
    return false;
    }
}
