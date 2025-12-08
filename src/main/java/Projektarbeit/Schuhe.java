package Projektarbeit;
import java.util.ArrayList;

public class Schuhe {
    private String marke;
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

    //neue Array Liste erzeugen
    private ArrayList<Schuhe> schuhListe = new ArrayList<>();

    //neue Objekte in der erzeugten Array Liste hinzufügen
    public void initObjekte() {
            schuhListe.add (new Schuhe("Nike", 42, 110, false));
            schuhListe.add (new Schuhe("Adidas", 38, 119.99,true));
            schuhListe.add (new Schuhe("Puma", 40, 150,false));
        }

    }
