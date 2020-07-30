package util;

import entities.OrientedPosition;
import interfaces.IDecoderOutput;
import interfaces.ILoggerOutput;
import interfaces.IOutput;

/**
 * This class represents an IOutput and is used to share information about one rover expedition
 * into System.out as require the backend application
 */
public class OutputConsoleSystemOut implements IOutput {

    /**
     * Method to expose results by System.out
     *
     * @param loggerOutput        ILoggerOutput that contains the log information unused in this class
     * @param inputIDecoderOutput IDecoderOutput with attributes as the rovers list to get the position needed to share
     * @see ILoggerOutput
     * @see IDecoderOutput
     */
    @Override
    public void exposeResults(ILoggerOutput loggerOutput, IDecoderOutput inputIDecoderOutput) {
        if (inputIDecoderOutput != null) {
            OrientedPosition roverPosition = inputIDecoderOutput.getMarsRovers().get(0).getOrientedPosition();
            System.out.print(orientedPositionToJson(roverPosition));
        }
    }


    /**
     * Private method to convert an OrientedPosition to JSON
     *
     * @param orientedPosition Entry oriented position
     * @return a string with oriented position information as JSON
     * @see OrientedPosition
     */
    private String orientedPositionToJson(OrientedPosition orientedPosition) {
        return "{" +
                "\"xPos\" : " + orientedPosition.getXPos() +
                ", \"yPos\" : " + orientedPosition.getYPos() +
                ", \"compassPoint\" : \"" + orientedPosition.getCompassPoint() +
                "\"}";
    }
}

