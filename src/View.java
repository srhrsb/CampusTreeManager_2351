import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class View extends JFrame{
    private JButton saveBtn;

    private JTextField nameTf, lngTf, latTf, typeTf;
    private JCheckBox isSickChkBox;

    //Konstruktor
    public View(int width, int height, String windowTitle) {
        setTitle(windowTitle);
        createUserInterface( width, height);
    }

    //Methode createUserInterface
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

    //Methode addSaveHandler
    public void addSaveHandler( ActionListener listener){
        saveBtn.addActionListener( listener );
    }

    //Getter für Textfelder
    public String getNameText(){
        return nameTf.getText();
    }

    public String getLngText(){
        return lngTf.getText();
    }

    public String getLatText(){
        return latTf.getText();
    }

    public String getTypeText(){
        return typeTf.getText();
    }

    public boolean getIsSickChkBox(){
        return isSickChkBox.isSelected();
    }

    public void showErrorWindow( String message ){
        JOptionPane.showMessageDialog( this, message, "Fehler", JOptionPane.ERROR_MESSAGE);
    }


    //ToDo erstellen Sie zwei weitere Methoden
    //ToDo: showInfoWindow und showConfirmWindow
    public void showInfoWindow( String message ){
        JOptionPane.showMessageDialog( this, message, "Info", JOptionPane.INFORMATION_MESSAGE);
    }

    public boolean showConfirmWindow( String message ){
        return JOptionPane.showConfirmDialog( this, message, "Bitte bestätigen", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION;
    }


}
