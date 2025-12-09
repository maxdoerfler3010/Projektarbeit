package Projektarbeit;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Verkauf extends JFrame {

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


    //Konstruktor bilden
    public Verkauf() {
        setTitle("Verkauf");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setContentPane(myPanel);
        setVisible(true);


//Action Listener, um neue Objekte in einer Liste zu speichern
        speichernButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String wasserfest;
                if (checkBox_Wasserfest.isSelected()) {
                    wasserfest = "Ist wasserfest";
                } else {
                    wasserfest = "Ist nicht wasserfest";
                }
                marke = comBox_Marken.getSelectedItem().toString();
                groesse = tF_Groesse.getText();
                preis = tF_Preis.getText();

                //extra (textArea1_Filter.getText() um es in Liste zu speichern
                textArea1_Schuhliste.setText(textArea1_Schuhliste.getText() + "neuer Schuh:" + "\nMarke: " + marke + "\nGröße: " + groesse
                        + "\nPreis: " + preis + " €" + "\n" + wasserfest + "\n\n");

//die Texteingabefelder löschen sich automatisch
                tF_Groesse.setText("");
                tF_Preis.setText("");
                checkBox_Wasserfest.setSelected(false);

            }
        });


//Action listener, um alle Textfelder zu löschen
        loeschenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1_Schuhliste.setText("");//Schuh-Liste löschen
                textArea1_Filter.setText("");
            }
        });


        filternButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}