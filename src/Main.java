import controller.Controller;
import entities.Decoder;
import entities.LoggerOutput;
import entities.OutputConsoleSystemOut;
import entities.Simulator;
import view.MainMenuView;

/**
 * Main class to launch the application.
 * It has a little logic inside:
 * If the user run the .Jar file this main will init the first screen view, showing to the user a UI that can interact with.
 * If the .jar is invoked by the console, it will not start the UI screen. However it will run with the input information
 * placed in the first String[] args. Then a call to System.out.print will be performed by OutputConsoleSystemOut
 * to show the results to whom it will wait for it.
 */
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
