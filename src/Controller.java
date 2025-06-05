public class Controller {
    private TreeDAO treedao;
    private View view;

    public Controller() {
        treedao = new TreeDAO();
        view = new View(400,200, "SRH Campus Baum Manager");
    }
}
