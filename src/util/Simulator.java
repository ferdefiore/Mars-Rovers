package util;

import interfaces.IDecoderOutput;
import interfaces.ILoggerOutput;
import interfaces.IMarsRover;
import interfaces.ISimulator;

import java.util.ArrayList;

/**
 * This class implements interface ISimulator
 * This class is used to run the ICommands on the IMarsRovers and log the results
 *
 * @see ISimulator
 */
public class Simulator implements ISimulator {
    /**
     * Method to execute commands in the rovers
     *
     * @param inputIDecoderOutput with the required information to move rovers. It has the plateau, the rovers and the commands
     * @param logger logger used to write the output log
     * @see IDecoderOutput
     * @see ILoggerOutput
     */
    public void run(IDecoderOutput inputIDecoderOutput, ILoggerOutput logger) {
        ArrayList<IMarsRover> marsRovers = inputIDecoderOutput.getMarsRovers();
        for (IMarsRover rover : marsRovers) {
            try {
                rover.executeCommands(inputIDecoderOutput.getRoverInstructionSet().get(rover.getRoverId()), inputIDecoderOutput.getPlateau());
                logger.appendRoverFinalPosition(rover.toString());
            } catch (Exception e) {
                logger.appendSimpleMessage(e.getMessage());
            }
        }
    }
}