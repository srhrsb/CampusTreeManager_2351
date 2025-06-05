import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class View extends JFrame{
    private JButton saveBtn;

    private JTextField nameTf, lngTf, latTf, typeTf;
    private JCheckBox isSickChkBox;

    public View(int width, int height, String windowTitle) {
            createUserInterface( width, height);
    }
    private  void createUserInterface( int width, int height ){

        setSize( width, height ); //Fenstergröße setzen
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Verhalten bei Fenster
        //schließen festlegen

        JPanel bottomPanel = new JPanel(); //ein Panel gruppiert Elemente
        saveBtn = new JButton("Speichern"); //Button erstellen
        bottomPanel.add( saveBtn ); // panel hat eine Methode add
        add( bottomPanel );//Die Methode add für das Fenster

        JPanel topPanel = new JPanel();
        topPanel.setLayout( new GridLayout(5,2, 10, 10));
        topPanel.setBorder( new EmptyBorder( 5,5,5,5 ));
        add( topPanel, BorderLayout.NORTH );

        JLabel nameLabel = new JLabel("Name des Baums");
        nameTf = new JTextField();
        topPanel.add(nameLabel);
        topPanel.add(nameTf);

        JLabel lngLabel = new JLabel("Position lng");
        lngTf = new JTextField();
        topPanel.add(lngLabel);
        topPanel.add(lngTf);

        JLabel latLabel = new JLabel("Position lat");
        latTf = new JTextField();
        topPanel.add(latLabel);
        topPanel.add(latTf);

        JLabel typeLabel = new JLabel("Baumart");
        typeTf = new JTextField();
        topPanel.add(typeLabel);
        topPanel.add(typeTf);

        JLabel isSickLabel = new JLabel("Baum ist krank");
        isSickChkBox = new JCheckBox();
        topPanel.add(isSickLabel);
        topPanel.add(isSickChkBox);

        //(von JFrame geerbt)
        setVisible(true); //Fenster sichtbar machen
    }
}
