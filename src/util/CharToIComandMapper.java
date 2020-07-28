package util;

import entities.commands.ICommand;
import entities.commands.LeftCommand;
import entities.commands.MoveCommand;
import entities.commands.RightCommand;

import java.util.HashMap;
import java.util.Map;

public class CharToIComandMapper {

    public static Map<Character, ICommand> charToCommand = new HashMap<Character, ICommand>() {{
        put('L', new LeftCommand());
        put('R', new RightCommand());
        put('M', new MoveCommand());
    }};

}
