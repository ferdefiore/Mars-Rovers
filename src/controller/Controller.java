package controller;

import entities.MarsRover;
import entities.Plateau;
import entities.commands.ICommand;
import util.IOManager;

import java.util.ArrayList;
import java.util.Map;

public class Controller {
    private Plateau marsPlateau;
    private ArrayList<MarsRover> marsRovers;
    private Map<Integer, ArrayList<ICommand>> roverInstructionSet;
    private IOManager ioManager;

    public Controller(IOManager ioManager) {
        this.ioManager = ioManager;
    }

    private void initData(String str) {
        ioManager.decodeInput(str);
        marsPlateau = ioManager.getDecodedPlateau();
        marsRovers = ioManager.getMarsRovers();
        roverInstructionSet = ioManager.getRoverInstructionSet();
    }

    public void performMovementsIntoPlateau(String str) {
        initData(str);
        for (MarsRover rover : marsRovers) {
            rover.executeCommands(roverInstructionSet.get(rover.getRoverId()), marsPlateau);
        }
    }

    public MarsRover getRoverByIndex(int index) {
        return marsRovers.get(index);
    }

    public String getOutput() {
        return ioManager.getInstructionsLog();
    }
}
