package Projektarbeit;

import javax.swing.*;

public class Verkauf extends JFrame{
    private JPanel myPanel;
    private JLabel label_Marken;
    private JLabel label_Größe;
    private JLabel label_Preis;
    private JTextField tF_Preis;
    private JCheckBox checkBox_Wasserfest;
    private JList list1_Schuhliste;
    private JLabel label_Schuhliste;
    private JButton speichernButton;
    private JButton löschenButton;
    private JComboBox comBox_Marken;
    private JTextField tF_Größe;
    private JLabel label_ObjektAusgeben;
    private JList list2_Objekte;
    private JButton filternButton;
    private JComboBox comBox_Filter;

    //Konstruktor bilden
    public Verkauf() {
        setTitle("Verkauf");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setContentPane(myPanel);
        setVisible(true);
    }
}
