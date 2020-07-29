package util;

import entities.OrientedPosition;
import util.interfaces.ILoggerOutput;
import util.interfaces.IOutput;

public class OutputConsoleSystemOut implements IOutput {
    @Override
    public void exposeResults(ILoggerOutput loggerOutput, Decoder.Data inputData) {
        if (inputData != null) {
            OrientedPosition roverPosition = inputData.getMarsRovers().get(0).getOrientedPosition();
            String outInformation = "{" +
                    "\"xPos\" : " + roverPosition.getXPos() +
                    ", \"yPos\" : " + roverPosition.getYPos() +
                    ", \"compassPoint\" : \"" + roverPosition.getCompassPoint() +
                    "\"}";
            System.out.println(outInformation);
        }
    }
}

