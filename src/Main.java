import controller.Controller;
import util.IOManager;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            inicView();
        }else {
            runWithoutView(args[0]);
        }
    }

    private static void inicView(){
        //todo inciar desde vista mandando controller
        //new MenuView(new Controller(new IOManager()));
    }

    private static void runWithoutView(String instructions){
        Controller controller = new Controller(new IOManager());
        controller.performMovementsIntoPlateau(instructions);
        System.out.println(controller.getRoverByIndex(0).getOrientedPosition().toJsonString());
        System.out.println(controller.getOutput());
    }
}
