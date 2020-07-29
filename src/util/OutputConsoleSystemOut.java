package util;

import entities.OrientedPosition;
import util.interfaces.ILoggerOutput;
import util.interfaces.IOutput;

public class OutputConsoleSystemOut implements IOutput {
    @Override
    public void exposeResults(ILoggerOutput loggerOutput, Decoder.Data inputData) {
        if (inputData != null) {
            OrientedPosition roverPosition = inputData.getMarsRovers().get(0).getOrientedPosition();
            System.out.println(orientedPositionToJson(roverPosition));
        }
    }

    private String orientedPositionToJson(OrientedPosition orientedPosition) {
        return "{" +
                "\"xPos\" : " + orientedPosition.getXPos() +
                ", \"yPos\" : " + orientedPosition.getYPos() +
                ", \"compassPoint\" : \"" + orientedPosition.getCompassPoint() +
                "\"}";
    }
}

