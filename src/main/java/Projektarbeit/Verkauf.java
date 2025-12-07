package Projektarbeit;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Verkauf extends JFrame{
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
    private JList list2_Objekte;
    private JButton filternButton;
    private JComboBox comBox_Filter;
    private JTextArea textArea1_Schuhliste;

    //Konstruktor bilden
    public Verkauf() {
        setTitle("Verkauf");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setContentPane(myPanel);
        setVisible(true);

        speichernButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String wasserfest;
                if (checkBox_Wasserfest.isSelected()) {
                    wasserfest = "Ist wasserfest";
                }else{
                    wasserfest = "Ist nicht wasserfest";
                }
                String marke = comBox_Marken.getSelectedItem().toString();
                String groesse = tF_Groesse.getText();
                String preis = tF_Preis.getText();

                //extra (textArea1.getText() um es in Liste zu speichern
                textArea1_Schuhliste.setText(textArea1_Schuhliste.getText() + "neuer Schuh:" + "\nMarke: " + marke + "\nGröße: " + groesse
                        + "\nPreis: " + preis + "\n" + wasserfest + "\n\n");

                tF_Groesse.setText("");
                tF_Preis.setText("");
                checkBox_Wasserfest.setSelected(false);

            }
        });


        loeschenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1_Schuhliste.setText("");
            }
        });

    }
    public static void main(String[] args) {
        new Verkauf();
    }
}
