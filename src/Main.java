import controller.Controller;
import util.Decoder;
import util.LoggerOutput;
import util.OutputConsoleSystemOut;
import util.Simulator;
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
        MainMenuView mainMenuView = new MainMenuView();
        Controller controller = new Controller(new Decoder(), new LoggerOutput(), new Simulator());
        mainMenuView.setController(controller);
        mainMenuView.runView();
    }

    private static void runWithoutView(String instructions) {
        Controller controller = new Controller(new Decoder(), new LoggerOutput(), new Simulator());
        controller.performMovementsIntoPlateau(instructions, new OutputConsoleSystemOut());
    }
}
