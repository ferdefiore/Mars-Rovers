package entities.commands;

import interfaces.IMarsRover;
import models.OrientedPosition;
import models.Plateau;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class RightCommandTest {

    ICommand rightCommand;

    @BeforeEach
    void setUp() {
        rightCommand = new RightCommand();
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

            }

            @Override
            public void turnRight() {
                callCounter[0]++;
            }

            @Override
            public void turnLeft() {

            }
        };

        rightCommand.execute(iMarsRover);
        Assertions.assertEquals(1, callCounter[0]);
    }

    @Test
    void equalTypeTrue() {
        RightCommand anotherRightCommand = new RightCommand();
        Assertions.assertTrue(rightCommand.equalType(anotherRightCommand));
    }

    @Test
    void equalTypeFalse() {
        LeftCommand leftCommand = new LeftCommand();
        Assertions.assertFalse(rightCommand.equalType(leftCommand));
    }
}