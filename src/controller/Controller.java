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
    private String expeditionLog = "";

    public Controller(IOManager ioManager) {
        this.ioManager = ioManager;
    }

    public void performMovementsIntoPlateau(String str) {

        if (ioManager.decodeInput(str)) {
            initData();
            for (MarsRover rover : marsRovers) {
                try {
                    rover.executeCommands(roverInstructionSet.get(rover.getRoverId()), marsPlateau);
                    ioManager.appendToExpeditionLog(rover.toString());
                } catch (Exception e) {
                    ioManager.appendToExpeditionLog(e.getMessage());
                }
            }
        }
    }

    private void initData() {
        marsPlateau = ioManager.getDecodedPlateau();
        marsRovers = ioManager.getMarsRovers();
        roverInstructionSet = ioManager.getRoverInstructionSet();
    }

    public MarsRover getRoverByIndex(int index) {
        return marsRovers.get(index);
    }

    public String getOutputLog() {
        return ioManager.getInstructionsLog() + ioManager.getExpeditionLog();
    }

    public void viewDisposed() {
        ioManager.clearData();
        ioManager.clearLogs();
    }
}
