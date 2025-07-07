import java.awt.event.ActionEvent;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Controller {
    private TreeDAO treedao;
    private View view;

    public Controller() {
        treedao = new TreeDAO();
        view = new View(400,200, "SRH Campus Baum Manager");
        view.addSaveHandler(this::onSaveClick);
        view.addShowHandler(this::onShowTreeList);

//        if(view.showConfirmWindow("Frage")){
//            System.out.println("wurde bestätigt");
//        }
//        else{
//            System.out.println( "wurde nicht bestätigt");
//        }

    }
    private void onSaveClick(ActionEvent event){
        System.out.println( event.getActionCommand() );

        String name = view.getNameText();

        double lng = getDoubleValueFromText( view.getLngText(), 0, 180 ); //Problem: da kein String
        double lat = getDoubleValueFromText( view.getLatText(),0, 180 ); //Problem: da kein String

        String type = view.getTypeText();
        boolean isSick = view.getIsSickChkBox();

        int id = getUniqueId();
        System.out.println(id);
        treedao.addTree( id , name, lng, lat, type, isSick);
    }

    private void onShowTreeList(ActionEvent event){
        System.out.println( "Liste anzeigen" );

        //ToDo: Zeigen sie die Baumliste in einem Info Fenster an
        String list = treedao.getTreeListAsText();
        view.showInfoWindow(list);
    }

    private int getUniqueId( ){
        Random random = new Random();
        int number = random.nextInt(90000) +10000; // 5-stellige Zufallszahl

        long unixTime = TimeUnit.MILLISECONDS.
                toSeconds(System.currentTimeMillis());

       return (int)(unixTime/1000) + number;
    }

    private double getDoubleValueFromText( String text, double min, double max ){

        //Parse auf double mit Exception Handling um auf evtl. Fehler zu reagieren
        double value = 0;
        try{
            value = Double.parseDouble(text); //wenn das hier fehl schlägt, weil keine Kommazahl
                                              //eingetragen ist, dann geht es in den Catch-Block
             if(value > max || value < min){  //falls hier keine gültiges Argument
                 throw new IllegalArgumentException(); // => IllegalArgumentException
             }

        }
        catch( NumberFormatException e ){  //reagiert nur auf NumberFormatException
            //ToDo: Meldung an Nutzer, dass falsche Eingabe
            view.showErrorWindow("Bitte geben Sie eine Kommazahl mit Punkt an");

            //System.err.println( e.getMessage()); wenig Aussagekräftig
            throw new RuntimeException(e);//Darf nicht frei bleiben
        }
        catch( IllegalArgumentException e){ //reagiert nur auf IllegalArgumentException
            view.showErrorWindow("Das ist keine gültige Koordinate");
            throw new RuntimeException(e);
        }
        catch( Exception e){ //regiert auf alle Exceptions
            throw new RuntimeException(e);
        }
        return value;
    }
}
