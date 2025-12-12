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
//neue Array Liste erzeugen
public static ArrayList<Schuhe> schuhListe = new ArrayList<>();

//neue Objekte in der erzeugten Array Liste hinzufügen
public static void initObjekte() {
    schuhListe.add(new Schuhe("Nike", 42, 110, false));
    schuhListe.add(new Schuhe("Adidas", 38, 119.99, true));
    schuhListe.add(new Schuhe("Puma", 40, 150, false));
}

public static void addSchuhe(Schuhe s){
    schuhListe.add(s);
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


    public String toString(){
    return "Marke: " + marke + "\nGröße: " + groesse + "\nPreis: " + preis + " €" + "\n" + (istWasserdicht ? "Ist wasserdicht" : "Ist nicht wasserdicht");
    }

    public boolean contains(String ausgewaehlteMarke) {
    return false;
    }
}
