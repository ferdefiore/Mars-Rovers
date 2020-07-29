package entities.commands;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {

    public static Map<Character, ICommand> charToCommand = new HashMap<Character, ICommand>() {{
        put('L', new LeftCommand());
        put('R', new RightCommand());
        put('M', new MoveCommand());
    }};

}
