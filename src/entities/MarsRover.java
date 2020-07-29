package entities;

import entities.commands.ICommand;
import interfaces.IMarsRover;

import java.util.ArrayList;

public class MarsRover implements IMarsRover {
    private final int roverId;
    private final OrientedPosition orientedPosition;

    public MarsRover(int roverId, OrientedPosition orientedPosition) {
        this.roverId = roverId;
        this.orientedPosition = orientedPosition;
    }

    @Override
    public int getRoverId() {
        return roverId;
    }

    @Override
    public OrientedPosition getOrientedPosition() {
        return orientedPosition;
    }

    @Override
    public void executeCommands(ArrayList<ICommand> commands, Plateau plateau) {
        for (ICommand command : commands) {
            //todo check if command is valid for this rover
            command.execute(this);
            checkValidPosition(plateau);
        }
    }

    private void checkValidPosition(Plateau plateau) {
        if ((orientedPosition.getXPos() < 0
                || orientedPosition.getYPos() < 0
                || orientedPosition.getXPos() > plateau.getPlateauMaxWidth()
                || orientedPosition.getYPos() > plateau.getPlateauMaxHeight()))
            throw new IllegalStateException(String.format("R.I.P: Invalid moves, rover %d went outside Mars platform. We'll never see him again", roverId));
    }

    @Override
    public void moveForward() {
        switch (orientedPosition.getCompassPoint()){
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

    @Override
    public void turnRight() {
        orientedPosition.setCompassPoint(this.orientedPosition.getCompassPoint().turn90DegreeRight());
    }

    @Override
    public void turnLeft() {
        orientedPosition.setCompassPoint(this.orientedPosition.getCompassPoint().turn90DegreeLeft());
    }

    @Override
    public String toString() {
        return "MarsRover{" +
                "Id=" + roverId +
                ", " + orientedPosition +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarsRover marsRover = (MarsRover) o;
        return roverId == marsRover.roverId &&
                orientedPosition.equals(marsRover.orientedPosition);
    }

}
