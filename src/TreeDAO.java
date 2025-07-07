import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TreeDAO {
    private ArrayList<Tree> treeList;
    private final String SEPARATOR = ";"; //Konstanten immer groß
    private final String PATH = "data/saveFile.csv";

    public TreeDAO() {
        treeList = loadData();
    }

    public boolean addTree( int id, String name, double lng, double lat, String type, boolean isSick )
    {
        //Aufgabe b:
        //Schritt 1: Objekt von Tree mit den Daten erzeugen
        Tree tree = new Tree(id, name, lng, lat, type, isSick);

        //Schritt 2: erzeugtes Objekt zuweisen
        treeList.add(tree);

        //kürzer
        //treeList.add( new Tree(id, name, lng, lat, type, isSick) );

        return false;
    }

    public String getTreeListAsText(){
        String listString = "";
        String br = "\n";

        for( Tree tree : treeList){ //durch Treeliste laufen
            listString += "ID: " + tree.getId() + br;
            listString += "Name: " + tree.getName() + br;

            //ToDO: Für alle weiteren Getter analog
            listString += "Längengrad: " + tree.getLng() + br;
            listString += "Breitengrad: " + tree.getLat() + br;
            listString += "Typ: " + tree.getType() + br;

            String sick = "nein";
            if( tree.isSick() ){
                sick = "ja";
            }

            listString += "Ist krank: " + sick + br;
            listString += br + "-------------------------" + br;
        }
        return listString;
    }

    public void saveData(){
        FileWriter csv = null; //Filewriter Objekt
        try{
            csv = new FileWriter( PATH );
            for(Tree tree : treeList ){
                if(tree != null) {
                    String line = tree.getId() + SEPARATOR;
                    line += tree.getName() + SEPARATOR;
                    line += tree.getLng() + SEPARATOR;
                    line += tree.getLat() + SEPARATOR;
                    line += tree.getType() + SEPARATOR;
                    line += tree.isSick() + SEPARATOR;

                    line += "\n"; //Zeilenumbruch
                    csv.write(line);
                }
            }
        }
        catch( IOException e ){
            //in der Variable e wird der Fehler angenommen
            System.err.println("IO Error: "+ e.getMessage());
        }
        catch( Exception e ){
            System.err.println("Error: "+ e.getMessage());
        }
        finally {
            //wird immer ausgeführt, egal ob ein Fehler auftrat oder nicht,
            //Beispiel: Schließen von Dateien
            if (csv != null) {
                try {
                    csv.close();
                } catch( IOException e ) {
                    System.err.println("Error" + e.getMessage() );
                }
            }
        }
    }

    public ArrayList<Tree> loadData(){
        //Leere Liste erzeugen
        ArrayList<Tree> tempTreeList = new ArrayList<>();
        //Objekt FileReader zunächst ungültig
        FileReader file = null;

        try{
            file = new FileReader( PATH ); //FileReader (jetzt gültig)

            //Reader zum zeilenweise Lesen
            BufferedReader reader = new BufferedReader( file );
            String line; //einzelne Zeile, zunächst leer
            //Schleife => Lese solange line nicht null ist
            while( ( line = reader.readLine() ) != null){
                //Zeichen zwischen den Trennern separieren und in Array speichern
                String[] data = line.split( SEPARATOR );
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                double lng = Double.parseDouble(data[2]);
                double lat = Double.parseDouble(data[3]);
                String type = data[4];
                boolean isSick = Boolean.parseBoolean(data[5]);

                Tree tree = new Tree(id, name, lng,lat, type, isSick);
                tempTreeList.add(tree);
                //Treeliste hinzufügen

            }
        }
        catch( IOException e){
            System.err.println("Error: " + e.getMessage());
        }
        return tempTreeList;
    }

    public void removeTree( int id ){
        for( Tree tree : treeList){
            if(tree.getId() == id){
                treeList.remove(tree);
            }
        }
    }
    //HA: Verwenden Sie die Remove-Methode in dem Sie im View einen
    // Löschen-Button und ID Eingabefeld hinzufügen und falls dor eine ID eingegeben ist
    //löschen Sie den Baum

}