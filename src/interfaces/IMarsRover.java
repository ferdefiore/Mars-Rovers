package interfaces;

import entities.commands.ICommand;
import models.OrientedPosition;
import models.Plateau;

import java.util.ArrayList;

/**
 * This interface provided behaviour that will be used by MarsRovers to perform movements into a Plateau
 */
public interface IMarsRover {
    /**
     * @return An int that represent the rover id
     */
    int getRoverId();

    /**
     * @return The rover OrientedPosition
     * @see OrientedPosition
     */
    OrientedPosition getOrientedPosition();

    /**
     * Method used to perform movements by Mars Rover in a specific plateau.
     * This method should change the Rover's OrientedPosition after running the commands.
     * Each rover should verify that the movements don't make him fall out the plateau.
     *
     * @param commands ArrayList with ICommand that contains each command to be performed by Mars Rover.
     * @param plateau  Plateau in which Mars Rover will navigate.
     * @see ICommand
     * @see Plateau
     */
    void executeCommands(ArrayList<ICommand> commands, Plateau plateau);


    /**
     * This method should execute a move forward and change the rover (x,y) position
     */
    void moveForward();

    /**
     * This method should execute a turn right and change the rover orientation
     */
    void turnRight();

    /**
     * This method should execute a turn left and change the rover orientation
     */
    void turnLeft();

    /**
     * @return String with the rover information
     */
    @Override
    String toString();


    /**
     * This method should compare every rover's attribute with another object
     * and return true if all have the same value, or false if not.
     */
    @Override
    boolean equals(Object o);
}
