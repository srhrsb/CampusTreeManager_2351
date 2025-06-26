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

}
