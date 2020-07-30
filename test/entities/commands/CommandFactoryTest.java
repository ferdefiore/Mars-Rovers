package entities.commands;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CommandFactoryTest {
    @Test
    void testFactoryLeftCommand() {
        LeftCommand leftCommand = new LeftCommand();
        Assertions.assertTrue(leftCommand.equalType(CommandFactory.charToCommand.get('L')));
    }

    @Test
    void testFactoryRightCommand() {
        RightCommand rightCommand = new RightCommand();
        Assertions.assertTrue(rightCommand.equalType(CommandFactory.charToCommand.get('R')));
    }

    @Test
    void testFactoryMoveCommand() {
        MoveCommand moveCommand = new MoveCommand();
        Assertions.assertTrue(moveCommand.equalType(CommandFactory.charToCommand.get('M')));
    }
}