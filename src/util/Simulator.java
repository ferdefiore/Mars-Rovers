package util;

import interfaces.IDecoderOutput;
import interfaces.ILoggerOutput;
import interfaces.IMarsRover;
import interfaces.ISimulator;

import java.util.ArrayList;

public class Simulator implements ISimulator {
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