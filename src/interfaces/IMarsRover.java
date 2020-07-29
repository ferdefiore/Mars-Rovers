package interfaces;

import entities.OrientedPosition;
import entities.Plateau;
import entities.commands.ICommand;

import java.util.ArrayList;

public interface IMarsRover {
    int getRoverId();

    OrientedPosition getOrientedPosition();

    void executeCommands(ArrayList<ICommand> commands, Plateau plateau);

    void moveForward();

    void turnRight();

    void turnLeft();

    @Override
    String toString();

    @Override
    boolean equals(Object o);
}
