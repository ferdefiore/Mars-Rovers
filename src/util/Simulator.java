package util;

import entities.MarsRover;
import util.interfaces.ILoggerOutput;
import util.interfaces.ISimulator;

import java.util.ArrayList;

public class Simulator implements ISimulator {
    public void run(Decoder.Data inputData, ILoggerOutput logger) {
        ArrayList<MarsRover> marsRovers = inputData.getMarsRovers();
        for (MarsRover rover : marsRovers) {
            try {
                rover.executeCommands(inputData.getRoverInstructionSet().get(rover.getRoverId()), inputData.getPlateau());
                logger.appendRoverFinalPosition(rover.toString());
            } catch (Exception e) {
                logger.appendSimpleMessage(e.getMessage());
            }
        }
    }
}