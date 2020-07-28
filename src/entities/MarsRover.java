package entities;

import entities.commands.ICommand;

import java.util.ArrayList;

public class MarsRover {
    private final int roverId;
    private final OrientedPosition orientedPosition;

    public MarsRover(int roverId, OrientedPosition orientedPosition) {
        this.roverId = roverId;
        this.orientedPosition = orientedPosition;
    }

    public void executeCommands(ArrayList<ICommand> commands, Plateau plateau){
        for(ICommand command : commands){
            command.execute(this);
            checkValidPosition(plateau);
        }
    }

    private void checkValidPosition(Plateau plateau) {
        if ((orientedPosition.getXPos() < 0
                || orientedPosition.getYPos() < 0
                || orientedPosition.getXPos() > plateau.getPlateauMaxWidth()
                || orientedPosition.getYPos() > plateau.getPlateauMaxHeight()))
            throw new IllegalStateException(String.format("MARS ROVER %d R.I.P: Invalid moves, rover %d went outside Mars platform. We'll never see him again", roverId, roverId));
    }

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

    public void turnRight() {
        orientedPosition.setCompassPoint(this.orientedPosition.getCompassPoint().turn90DegreeRight());
    }

    public void turnLeft() {
        orientedPosition.setCompassPoint(this.orientedPosition.getCompassPoint().turn90DegreeLeft());
    }

    public int getRoverId() {
        return roverId;
    }

    public OrientedPosition getOrientedPosition() {
        return orientedPosition;
    }
}
