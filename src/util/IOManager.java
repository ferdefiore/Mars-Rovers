package util;

import entities.CompassPoint;
import entities.MarsRover;
import entities.OrientedPosition;
import entities.Plateau;
import entities.commands.ICommand;
import entities.commands.LeftCommand;
import entities.commands.MoveCommand;
import entities.commands.RightCommand;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class IOManager {
    private Scanner scanner;
    private String instructionsLog = "";
    private String expeditionLog = "";
    private Plateau decodedPlateau;
    private final ArrayList<MarsRover> marsRovers = new ArrayList<>();
    private final Map<Integer, ArrayList<ICommand>> roverInstructionSet = new HashMap<>();


    public boolean decodeInput(String input) {
        scanner = new Scanner(input);
        try {
            decodePlateau();
            decodeRoversAndInstructions();
        } catch (Exception e) {
            instructionsLog += "**********THE ROVERS CANT START NAVIGATION BECAUSE OF SOME INPUT ERROR********** \n\n";
            return false;
        }
        return true;
    }

    private void decodePlateau() {
        instructionsLog += "*************************STARTING DECODING INSTRUCTIONS************************* \n\n";
        instructionsLog += "****************************TRYING TO DECODE PLATEAU**************************** \n\n";
        int plateauDimensionWidth = scanner.nextInt();
        int plateauDimensionHeight = scanner.nextInt();
        decodedPlateau = new Plateau(plateauDimensionWidth, plateauDimensionHeight);
        instructionsLog += "PLATEAU DECODED SUCCESSFULLY: " + decodedPlateau + "\n\n";
    }

    private void decodeRoversAndInstructions() {
        int rovId = 1;
        int xPos;
        int yPos;
        String instructionsAsString;
        CompassPoint facingCardinalPoint;
        instructionsLog += "******************TRYING TO DECODE ROVERS AND INSTRUCTIONS SET****************** \n\n";
        canRead();
        while (scanner.hasNext()) {
            xPos = scanner.nextInt();
            yPos = scanner.nextInt();
            facingCardinalPoint = CompassPoint.valueOf(scanner.next());
            marsRovers.add(new MarsRover(rovId, new OrientedPosition(xPos, yPos, facingCardinalPoint)));
            canRead();
            instructionsAsString = scanner.next();
            roverInstructionSet.put(rovId, stringToICommandList(instructionsAsString));
            instructionsLog += "DECODED ROVER: " + marsRovers.get(rovId - 1) + "\n";
            instructionsLog += "DECODED INSTRUCTION SET: " + instructionsAsString + "\n\n";
            rovId++;
        }
        instructionsLog += "***********************DECODING INSTRUCTIONS FINISHED*************************** \n\n";
        instructionsLog += "**********MARS ROVERS ARE SUCCESSFULLY LANDED AND STARTING NAVIGATION*********** \n\n";
        instructionsLog += "************************MARS ROVERS OUTPUT INFORMATION************************** \n\n";
    }

    private boolean canRead() {
        if (!scanner.hasNext()) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    private ArrayList<ICommand> stringToICommandList(String str) {
        ArrayList<ICommand> commands = new ArrayList<>();
        for (char c : str.toCharArray()) {
            if (CharToIComandMapper.charToCommand.containsKey(c)) {
                commands.add(CharToIComandMapper.charToCommand.get(c));
            } else throw new IllegalArgumentException("Illegal argument " + c + " in instructions.");

        }
        return commands;
    }

    private static Map<Character, ICommand> charToCommand = new HashMap<Character, ICommand>() {{
        put('L', new LeftCommand());
        put('R', new RightCommand());
        put('M', new MoveCommand());
    }};


    public String getInstructionsLog() {
        return instructionsLog;
    }

    public Plateau getDecodedPlateau() {
        return decodedPlateau;
    }

    public ArrayList<MarsRover> getMarsRovers() {
        return marsRovers;
    }

    public Map<Integer, ArrayList<ICommand>> getRoverInstructionSet() {
        return roverInstructionSet;
    }

    public void clearLogs() {
        instructionsLog = "";
        expeditionLog = "";
    }

    public void clearData() {
        marsRovers.clear();
        roverInstructionSet.clear();
    }

    public void appendToExpeditionLog(String log) {
        expeditionLog += log;
    }

    public String getExpeditionLog() {
        return expeditionLog;
    }
}
