import java.util.ArrayList;

public class TreeDAO {

    private ArrayList<Tree> treeList;
    public TreeDAO() {
        treeList = new ArrayList<>();
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

    }

    public ArrayList<Tree> loadData(){



        return null;
    }
}