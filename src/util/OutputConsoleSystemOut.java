package util;

import entities.OrientedPosition;
import interfaces.IDecoderOutput;
import interfaces.ILoggerOutput;
import interfaces.IOutput;

public class OutputConsoleSystemOut implements IOutput {
    @Override
    public void exposeResults(ILoggerOutput loggerOutput, IDecoderOutput inputIDecoderOutput) {
        if (inputIDecoderOutput != null) {
            OrientedPosition roverPosition = inputIDecoderOutput.getMarsRovers().get(0).getOrientedPosition();
            System.out.print(orientedPositionToJson(roverPosition));
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

