package entities.commands;

import entities.OrientedPosition;
import entities.Plateau;
import interfaces.IMarsRover;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class LeftCommandTest {

    ICommand leftCommand;

    @BeforeEach
    void setUp() {
        leftCommand = new LeftCommand();
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

            }

            @Override
            public void turnLeft() {
                callCounter[0]++;
            }
        };

        leftCommand.execute(iMarsRover);
        Assertions.assertEquals(1, callCounter[0]);
    }

    @Test
    void equalTypeFalse() {
        RightCommand rightCommand = new RightCommand();
        Assertions.assertTrue(leftCommand.equalType(rightCommand));
    }

    @Test
    void equalTypeTrue() {
        LeftCommand anotherLeftCommand = new LeftCommand();
        Assertions.assertFalse(this.leftCommand.equalType(anotherLeftCommand));
    }
}