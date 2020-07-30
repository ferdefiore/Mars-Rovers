package entities.commands;

import java.util.HashMap;
import java.util.Map;

/**
 * Command Factory is a class used to get ICommand instances depending on his types.
 */
public class CommandFactory {

    /**
     * Returns a new class that implements ICommand, can be LeftCommand, RightCommand or MoveCommand depending
     * is used doing a charToCommand.get(c) where c is the instruction letter
     */
    public static final Map<Character, ICommand> charToCommand = new HashMap<Character, ICommand>() {{
        put('L', new LeftCommand());
        put('R', new RightCommand());
        put('M', new MoveCommand());
    }};

}
