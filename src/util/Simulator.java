package util;

import interfaces.IData;
import interfaces.ILoggerOutput;
import interfaces.IMarsRover;
import interfaces.ISimulator;

import java.util.ArrayList;

public class Simulator implements ISimulator {
    public void run(IData inputIData, ILoggerOutput logger) {
        ArrayList<IMarsRover> marsRovers = inputIData.getMarsRovers();
        for (IMarsRover rover : marsRovers) {
            try {
                rover.executeCommands(inputIData.getRoverInstructionSet().get(rover.getRoverId()), inputIData.getPlateau());
                logger.appendRoverFinalPosition(rover.toString());
            } catch (Exception e) {
                logger.appendSimpleMessage(e.getMessage());
            }
        }
    }
}