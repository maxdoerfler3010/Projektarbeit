package Projektarbeit;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Verkauf extends JFrame{

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
    private JComboBox comBox_Groesse;


    public Verkauf() {
        setTitle("Verkauf");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1050, 800);
        setContentPane(myPanel);
        //add(imageLabel("SchuheBanner.jpeg"));
        setVisible(true);

        comBox_Rabatt.setModel(new DefaultComboBoxModel<>(new String[] {"Kein Rabatt", "10%", "20%"}));

        comboBox1_Filter.setModel(new DefaultComboBoxModel<>(new String[] {
                "Nike",
                "Adidas",
                "Puma",
                "Wasserdicht",
                "Nicht wasserdicht"
        }));


        initObjekte();
        zeigeAlleSchuhe();


        speichernButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                speichereSchuh();
                rabattbenutzen();
            }
        });


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

    public static ArrayList<Schuhe> schuhListe = new ArrayList<>();

    public static ArrayList<Schuhe> gefilterteDaten = new ArrayList<>();


    public static void initObjekte() {
        schuhListe.add(new Schuhe("Nike", 42, 110, false));
        schuhListe.add(new Schuhe("Adidas", 38, 119.99, true));
        schuhListe.add(new Schuhe("Puma", 40, 150, false));
    }

    public static void addSchuhe(Schuhe s){
        schuhListe.add(s);
    }

    public void zeigeAlleSchuhe() {

        textArea1_Schuhliste.setText("");
        for (Schuhe s : schuhListe) {
            textArea1_Schuhliste.setText(textArea1_Schuhliste.getText() + s.toString() + "\n\n");
        }
    }


    public void zeigeGefilterteSchuhe() {
        textArea1_Filter.setText("");
        for (Schuhe s : gefilterteDaten) {
            textArea1_Filter.setText(textArea1_Filter.getText() + s.toString() + "\n\n");
        }
    }


    public void speichereSchuh() {
        try {
            boolean istWasserdicht = checkBox_Wasserfest.isSelected();

            marke = comBox_Marken.getSelectedItem().toString();
            groesse = comBox_Groesse.getSelectedItem().toString();
            preis = tF_Preis.getText();

            int groesseInt = Integer.parseInt(groesse);
            double preisDouble = Double.parseDouble(preis);

            Schuhe neuerSchuh = new Schuhe(marke, groesseInt, preisDouble, istWasserdicht);
            addSchuhe(neuerSchuh);

            zeigeAlleSchuhe();

            tF_Preis.setText("");
            checkBox_Wasserfest.setSelected(false);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Bitte gültige Zahlen für Größe und Preis eingeben!",
                    "Eingabefehler",
                    JOptionPane.ERROR_MESSAGE);
        }
    }


    public void rabattbenutzen() {
        String rabatt = (String) comBox_Rabatt.getSelectedItem();
        if (rabatt == null) return;

        if (rabatt.equals("Kein Rabatt")) {
            return;
        }

        Schuhe letzter = schuhListe.get(schuhListe.size() - 1);

        switch (rabatt) {
            case "10%":
                letzter.applyDiscount(0.9);
                break;
            case "20%":
                letzter.applyDiscount(0.8);
                break;
            default:
                return;
        }

        zeigeAlleSchuhe();

        comBox_Rabatt.setSelectedItem("Kein Rabatt");
    }

    private void filtereNachMarke() {

        gefilterteDaten.clear();

        String filter = comboBox1_Filter.getSelectedItem().toString();

        for (Schuhe s : schuhListe) {

            switch (filter) {
                case "Nike":
                case "Adidas":
                case "Puma":
                    if (s.getMarke().equalsIgnoreCase(filter)) {
                        gefilterteDaten.add(s);
                    }
                    break;

                case "Wasserdicht":
                    if (s.istWasserdicht()) {
                        gefilterteDaten.add(s);
                    }
                    break;

                case "Nicht wasserdicht":
                    if (!s.istWasserdicht()) {
                        gefilterteDaten.add(s);
                    }
                    break;
            }
        }
        zeigeGefilterteSchuhe();
    }


    private void loeschen(){
        textArea1_Schuhliste.setText("");
        textArea1_Filter.setText("");
    }


    public static void main(String[] args){
        new Verkauf();
    }

}

