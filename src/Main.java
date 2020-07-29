import controller.Controller;
import util.IOManager;
import view.MainMenuView;

public class Main {

    public static void main(String[] args) {
        if (args.length == 0) {
            initView();
        } else {
            runWithoutView(args[0]);
        }
    }

    private static void initView() {
        new MainMenuView(new Controller(new IOManager()));
    }

    private static void runWithoutView(String instructions) {
        Controller controller = new Controller(new IOManager());
        controller.performMovementsIntoPlateau(instructions);
        System.out.println(controller.getRoverByIndex(0).getOrientedPosition().toJsonString());
    }
}
