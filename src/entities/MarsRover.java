package entities;

import entities.commands.ICommand;
import interfaces.IMarsRover;
import models.OrientedPosition;
import models.Plateau;

import java.util.ArrayList;

/**
 * This class implements the interface IMarsRover.
 * The MarsRover class represents a robotic rover who has an identifier and an OrientedPosition.
 *
 * @see OrientedPosition
 */
public class MarsRover implements IMarsRover {

    /**
     * Int as Rover Id which identifies every rover
     */
    private final int roverId;

    /**
     * Oriented Position which represents the rover's position
     *
     * @see OrientedPosition
     */
    private final OrientedPosition orientedPosition;


    /**
     * Class MarsRover constructor
     *
     * @param roverId          int used as Rover id
     * @param orientedPosition OrientedPosition used to locate de Rover
     * @see OrientedPosition
     */
    public MarsRover(int roverId, OrientedPosition orientedPosition) {
        this.roverId = roverId;
        this.orientedPosition = orientedPosition;
    }


    /**
     * @return An int that represent the rover id
     */
    @Override
    public int getRoverId() {
        return roverId;
    }

    /**
     * @return The rover OrientedPosition
     * @see OrientedPosition
     */
    @Override
    public OrientedPosition getOrientedPosition() {
        return orientedPosition;
    }

    /**
     * Method used to perform movements by Mars Rover in a specific plateau.
     * This method changes the Rover's OrientedPosition after running the commands.
     *
     * @param commands ArrayList with ICommand that contains each command to be performed by Mars Rover.
     * @param plateau  Plateau in which Mars Rover will navigate.
     * @see ICommand
     * @see Plateau
     */
    @Override
    public void executeCommands(ArrayList<ICommand> commands, Plateau plateau) {
        for (ICommand command : commands) {
            command.execute(this);
            checkValidPosition(plateau);
        }
    }

    /**
     * A method that checks if the actual position of the rover is valid, by checking the limits of the plateau.
     * If any coordinate of the rover is outside the plateau limits, it throws an IllegalStateException.
     *
     * @param plateau Plateau in which Mars Rover will navigate
     * @see Plateau
     */
    private void checkValidPosition(Plateau plateau) {
        if ((orientedPosition.getXPos() < 0
                || orientedPosition.getYPos() < 0
                || orientedPosition.getXPos() > plateau.getPlateauMaxWidth()
                || orientedPosition.getYPos() > plateau.getPlateauMaxHeight()))
            throw new IllegalStateException(String.format("R.I.P: Invalid moves, rover %d went outside Mars platform. We'll never see him again", roverId));
    }

    /**
     * A method that executes a "Move forward" command and changes the position of the Mars Rover.
     * This evaluates the current cardinal point of the rover and acts in consequence modifying his coordinates.
     */
    @Override
    public void moveForward() {
        switch (orientedPosition.getCompassPoint()) {
            case N:
                orientedPosition.setYPos(orientedPosition.getYPos() + 1);
                break;
            case E:
                orientedPosition.setXPos(orientedPosition.getXPos() + 1);
                break;
            case S:
                orientedPosition.setYPos(orientedPosition.getYPos() - 1);
                break;
            case W:
                orientedPosition.setXPos(orientedPosition.getXPos() - 1);
                break;
        }
    }

    /**
     * Method that executes a "turnRight" command changing the position of the Mars Rover.
     * This method modifies the rover's orientation depending on the actual orientation.
     */
    @Override
    public void turnRight() {
        orientedPosition.setCompassPoint(this.orientedPosition.getCompassPoint().turn90DegreeRight());
    }

    /**
     * A method that executes a "turnLeft" command changing the position of the Mars Rover.
     * This method modifies the rover's orientation depending on the actual orientation.
     */
    @Override
    public void turnLeft() {
        orientedPosition.setCompassPoint(this.orientedPosition.getCompassPoint().turn90DegreeLeft());
    }


    /**
     * @return String with Rover information
     */
    @Override
    public String toString() {
        return "MarsRover{" +
                "Id=" + roverId +
                ", " + orientedPosition +
                '}';
    }

    /**
     * @param o Object to compare with the rover
     * @return true if every attribute of Object o is the same as the rover's
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarsRover marsRover = (MarsRover) o;
        return roverId == marsRover.roverId &&
                orientedPosition.equals(marsRover.orientedPosition);
    }

}
