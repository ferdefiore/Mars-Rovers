package entities;

import entities.commands.CommandFactory;
import entities.commands.ICommand;
import interfaces.IMarsRover;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MarsRoverTest {

    private Plateau plateau;
    private IMarsRover marsRover1;

    @BeforeEach
    void setUP() {
        plateau = new Plateau(5, 5);
        marsRover1 = new MarsRover(1, new OrientedPosition(1, 2, CompassPoint.N));
    }

//    @Test
//    void executeCommand(){
//        ArrayList<ICommand> commands = new ArrayList<>();
//        ICommand iCommand = marsRover -> Assertions.assertEquals(marsRover, marsRover1);
//        commands.add(iCommand);
//        marsRover1.executeCommands(commands, plateau);
//    }

    @Test
    void executeCommandsSuccess() {
        OrientedPosition expectedPosition = new OrientedPosition(1, 3, CompassPoint.N);
        ArrayList<ICommand> commands = new ArrayList<>();
        String validSequenceOfMovements = "LMLMLMLMM";
        for (char c : validSequenceOfMovements.toCharArray()) {
            commands.add(CommandFactory.charToCommand.get(c));
        }
        marsRover1.executeCommands(commands, plateau);
        Assertions.assertEquals(expectedPosition, marsRover1.getOrientedPosition());
    }

    @Test
    void executeCommandsFailMove() {
        ArrayList<ICommand> commands = new ArrayList<>();
        String invalidSequenceOfMovements = "LMLMLRMLMMMMMMMM";
        for (char c : invalidSequenceOfMovements.toCharArray()) {
            commands.add(CommandFactory.charToCommand.get(c));
        }
        Assertions.assertThrows(IllegalStateException.class, () -> marsRover1.executeCommands(commands, plateau));
    }

    @Test
    void moveForwardWhenNorth() {
        OrientedPosition expectedPosition = new OrientedPosition(1, 3, CompassPoint.N);
        marsRover1.moveForward();
        assertEquals(expectedPosition, marsRover1.getOrientedPosition());
    }

    @Test
    void moveForwardWhenSouth() {
        marsRover1.getOrientedPosition().setCompassPoint(CompassPoint.S);
        OrientedPosition expectedPosition = new OrientedPosition(1, 1, CompassPoint.S);
        marsRover1.moveForward();
        assertEquals(expectedPosition, marsRover1.getOrientedPosition());
    }

    @Test
    void moveForwardWhenEast() {
        marsRover1.getOrientedPosition().setCompassPoint(CompassPoint.E);
        OrientedPosition expectedPosition = new OrientedPosition(2, 2, CompassPoint.E);
        marsRover1.moveForward();
        assertEquals(expectedPosition, marsRover1.getOrientedPosition());
    }

    @Test
    void moveForwardWhenWest() {
        marsRover1.getOrientedPosition().setCompassPoint(CompassPoint.W);
        OrientedPosition expectedPosition = new OrientedPosition(0, 2, CompassPoint.W);
        marsRover1.moveForward();
        assertEquals(expectedPosition, marsRover1.getOrientedPosition());
    }

    @Test
    void turnRight() {
        OrientedPosition expectedPosition = new OrientedPosition(1, 2, CompassPoint.E);
        marsRover1.turnRight();
        assertEquals(expectedPosition, marsRover1.getOrientedPosition());
    }

    @Test
    void turnLeft() {
        OrientedPosition expectedPosition = new OrientedPosition(1, 2, CompassPoint.W);
        marsRover1.turnLeft();
        assertEquals(expectedPosition, marsRover1.getOrientedPosition());
    }
}