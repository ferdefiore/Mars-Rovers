package entities.commands;

import entities.OrientedPosition;
import entities.Plateau;
import interfaces.IMarsRover;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class MoveCommandTest {

    ICommand moveCommand;

    @BeforeEach
    void setUp() {
        moveCommand = new MoveCommand();
    }

    @Test
    void execute() {
        final int[] callCounter = {0};
        IMarsRover iMarsRover = new IMarsRover() {
            @Override
            public int getRoverId() {
                return 0;
            }

            @Override
            public OrientedPosition getOrientedPosition() {
                return null;
            }

            @Override
            public void executeCommands(ArrayList<ICommand> commands, Plateau plateau) {

            }

            @Override
            public void moveForward() {
                callCounter[0]++;
            }

            @Override
            public void turnRight() {

            }

            @Override
            public void turnLeft() {

            }
        };

        moveCommand.execute(iMarsRover);
        Assertions.assertEquals(1, callCounter[0]);
    }

    @Test
    void equalTypeTrue() {
        MoveCommand anotherMoveCommand = new MoveCommand();
        Assertions.assertTrue(moveCommand.equalType(anotherMoveCommand));
    }

    @Test
    void equalTypeFalse() {
        LeftCommand leftCommand = new LeftCommand();
        Assertions.assertFalse(moveCommand.equalType(leftCommand));
    }
}