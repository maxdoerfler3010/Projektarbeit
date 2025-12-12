package Projektarbeit;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Verkauf extends JFrame{

    //Attribute angeben, damit sie schon gleich gespeichert sind
    private String marke;
    private String groesse;
    private String preis;

    private JPanel myPanel;
    private JLabel label_Marken;
    private JLabel label_Groesse;
    private JLabel label_Preis;
    private JTextField tF_Preis;
    private JCheckBox checkBox_Wasserfest;
    private JLabel label_Schuhliste;
    private JButton speichernButton;
    private JButton loeschenButton;
    private JComboBox comBox_Marken;
    private JTextField tF_Groesse;
    private JLabel label_ObjektAusgeben;
    private JTextArea textArea1_Schuhliste;
    private JTextArea textArea1_Filter;
    private JComboBox comboBox1_Filter;
    private JButton filternButton;
    private JPanel attributePanel;
    private JPanel listePanel;
    private JPanel filterPanel;
    private JLabel imageLabel;
    private JPanel imagePanel;
    private JComboBox comBox_Rabatt;


    //Konstruktor bilden
    public Verkauf() {
        setTitle("Verkauf");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1050, 800);
        setContentPane(myPanel);
        //add(imageLabel("SchuheBanner.jpeg"));
        setVisible(true);

        comBox_Rabatt.setModel(new DefaultComboBoxModel<>(new String[] {"Kein Rabatt", "10%", "20%"}));

        //zeigt die 3 Anfangsschuhe direkt im Textfeld
        initObjekte();
        zeigeAlleSchuhe();


        //Action Listener, um neue Objekte in einer Liste zu speichern
        speichernButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                speichereSchuh();
                rabattbenutzen();
            }
        });


        //Action listener, um alle Textfelder zu löschen
        loeschenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loeschen();
            }
        });


        filternButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtereNachMarke();
            }
        });

    }

    //neue Array Liste erzeugen
    public static ArrayList<Schuhe> schuhListe = new ArrayList<>();

    public static ArrayList<Schuhe> gefilterteDaten = new ArrayList<>();


    //neue Objekte in der erzeugten Array Liste hinzufügen
    public static void initObjekte() {
        schuhListe.add(new Schuhe("Nike", 42, 110, false));
        schuhListe.add(new Schuhe("Adidas", 38, 119.99, true));
        schuhListe.add(new Schuhe("Puma", 40, 150, false));
    }

    public static void addSchuhe(Schuhe s){
        schuhListe.add(s);
    }

    //------------------MUSS NOCH GEÄNDERT WERDEN---------------------
    //Methode um alle Schuhe anzuzeigen
    public void zeigeAlleSchuhe() {
        String text = "";

        for (Schuhe s : schuhListe) {
            text += s.toString() + "\n\n";
        }

        textArea1_Schuhliste.setText(text);
    }

    //Methode um gefilterte Schuhe anzuzeigen
    public void zeigeGefilterteSchuhe() {
        //----------SELBER------------
        /*String text = "";

        for (Schuhe item : gefilterteDaten) {
            text += item.toString() + "\n\n";
        }

        textArea1_Filter.setText(text);*/

        //----------CHATGPT---------
        /*StringBuilder text = new StringBuilder();

        for (Schuhe item : gefilterteDaten) {
            text.append(item.toString()).append("\n\n");
        }

        textArea1_Filter.setText(text.toString());
        */
    }

    // neuen Schuh aus den Eingabefeldern erstellen, in Liste speichern & anzeigen
    public void speichereSchuh() {
        try {
            boolean istWasserdicht = checkBox_Wasserfest.isSelected();

            marke = comBox_Marken.getSelectedItem().toString();
            groesse = tF_Groesse.getText();
            preis = tF_Preis.getText();

            int groesseInt = Integer.parseInt(groesse);
            double preisDouble = Double.parseDouble(preis);

            // neues Objekt erzeugen und in der zentralen Liste speichern
            Schuhe neuerSchuh = new Schuhe(marke, groesseInt, preisDouble, istWasserdicht);
            addSchuhe(neuerSchuh);

            // komplette Liste neu anzeigen
            zeigeAlleSchuhe();

            // Eingabefelder zurücksetzen
            tF_Groesse.setText("");
            tF_Preis.setText("");
            checkBox_Wasserfest.setSelected(false);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Bitte gültige Zahlen für Größe und Preis eingeben!",
                    "Eingabefehler",
                    JOptionPane.ERROR_MESSAGE);
        }
    }


    //Rabatt auf den Schuh anwenden
    public void rabattbenutzen() {
        String rabatt = (String) comBox_Rabatt.getSelectedItem();
        if (rabatt == null) return;

        // Wenn "Kein Rabatt" gewählt, nichts tun
        if (rabatt.equals("Kein Rabatt")) {
            return;
        }

        // Prüfen, ob Liste leer ist
        if (schuhListe.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Keine Schuhe vorhanden, auf die Rabatt angewandt werden kann.");
            return;
        }

        // letzten Schuh holen
        Schuhe letzter = schuhListe.get(schuhListe.size() - 1);

        // Welchen Rabatt anwenden?
        switch (rabatt) {
            case "10%":
                letzter.applyDiscount(0.9); // 10% Rabatt -> Faktor 0.9
                break;
            case "20%":
                letzter.applyDiscount(0.8);
                break;
            default:
                // nicht erwartet — nichts tun
                return;
        }

        // Anzeige aktualisieren
        zeigeAlleSchuhe();
    }

    //Filter-Methode
    private void filtereNachMarke() {
        //--------------SELBER------------
        /*//ArrayList<Schuhe> gefilterteDaten = new ArrayList<>();
        String ausgewaehlteMarke = comboBox1_Filter.getSelectedItem().toString();

        for (Schuhe item : schuhListe) {
            if (item.getMarke() != ausgewaehlteMarke) {
                continue;
            }
            gefilterteDaten.add(item);
            zeigeGefilterteSchuhe();
        }*/

        //----------CHATGPT---------
        /*gefilterteDaten.clear(); // ganz wichtig!
        String ausgewaehlteMarke = comboBox1_Filter.getSelectedItem().toString();

        for (Schuhe item : schuhListe) {
            if (!item.getMarke().equals(ausgewaehlteMarke)) {
                continue;
            }
            gefilterteDaten.add(item);
        }

        zeigeGefilterteSchuhe(); // erst NACH der Schleife!
        */
    }

    private void loeschen(){
        textArea1_Schuhliste.setText("");//Schuh-Liste löschen
        textArea1_Filter.setText("");
    }


    public static void main(String[] args){
        new Verkauf();
    }

}

//TO-DO
/*
JUNit Test noch machen mit Methode
Methode nutzen in der GUI / also vllt Rabattfeld einfügen
fehlende Fehlermeldungen hinzufügen
filter Methode Lösung überlegen
GUI schön machen
 */
