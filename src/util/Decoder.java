package util;

import entities.CompassPoint;
import entities.MarsRover;
import entities.OrientedPosition;
import entities.Plateau;
import entities.commands.CommandFactory;
import entities.commands.ICommand;
import util.interfaces.IDecoder;
import util.interfaces.ILoggerOutput;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Decoder implements IDecoder {

    @Override
    public Data decodeInput(String input, ILoggerOutput loggerOutput) { //plateu, marrovers, roverinstructionset
        Scanner scanner = new Scanner(input);
        ArrayList<MarsRover> marsRoversList = new ArrayList<>();
        HashMap<Integer, ArrayList<ICommand>> instructionsSet = new HashMap<>();
        try {
            Plateau plateau = decodePlateau(scanner, loggerOutput);
            decodeRoversAndInstructions(scanner, marsRoversList, instructionsSet, loggerOutput);
            return new Data(plateau, marsRoversList, instructionsSet);
        } catch (Exception e) {
            loggerOutput.appendErrorMsg();
            return null;
        }
    }

    private Plateau decodePlateau(Scanner scanner, ILoggerOutput loggerOutput) {
        loggerOutput.appendStartMsg();
        int plateauDimensionWidth = scanner.nextInt();
        int plateauDimensionHeight = scanner.nextInt();
        Plateau decodedPlateau = new Plateau(plateauDimensionWidth, plateauDimensionHeight);
        loggerOutput.appendPlateauSuccess(decodedPlateau.toString());
        return decodedPlateau;
    }

    private void decodeRoversAndInstructions(Scanner scanner, ArrayList<MarsRover> marsRoversList, HashMap<Integer, ArrayList<ICommand>> instructionsSet, ILoggerOutput loggerOutput) {
        int rovId = 1;
        int xPos;
        int yPos;
        String instructionsAsString;
        CompassPoint facingCardinalPoint;
        loggerOutput.appendStartDecodeRAI();
        if (!scanner.hasNext()) {
            throw new IllegalArgumentException("Missing input parameters");
        }
        while (scanner.hasNext()) {
            xPos = scanner.nextInt();
            yPos = scanner.nextInt();
            facingCardinalPoint = CompassPoint.valueOf(scanner.next());
            marsRoversList.add(new MarsRover(rovId, new OrientedPosition(xPos, yPos, facingCardinalPoint)));
            instructionsAsString = scanner.next();
            instructionsSet.put(rovId, stringToICommandList(instructionsAsString));
            loggerOutput.appendDecodedRover(marsRoversList.get(rovId - 1).toString());
            loggerOutput.appendInstructions(instructionsAsString);
            rovId++;
        }
        loggerOutput.appendFinishMsg();
    }

    private ArrayList<ICommand> stringToICommandList(String str) {
        ArrayList<ICommand> commands = new ArrayList<>();
        for (char c : str.toCharArray()) {
            if (CommandFactory.charToCommand.containsKey(c)) {
                commands.add(CommandFactory.charToCommand.get(c));
            } else throw new IllegalArgumentException("Illegal argument " + c + " in instructions.");

        }
        return commands;
    }

    public static class Data {
        private final Plateau plateau;
        private final ArrayList<MarsRover> marsRovers;
        private final Map<Integer, ArrayList<ICommand>> roverInstructionSet;

        public Plateau getPlateau() {
            return plateau;
        }

        public ArrayList<MarsRover> getMarsRovers() {
            return marsRovers;
        }

        public Map<Integer, ArrayList<ICommand>> getRoverInstructionSet() {
            return roverInstructionSet;
        }

        public Data(Plateau plateau, ArrayList<MarsRover> marsRovers, Map<Integer, ArrayList<ICommand>> roverInstructionSet) {
            this.plateau = plateau;
            this.marsRovers = marsRovers;
            this.roverInstructionSet = roverInstructionSet;
        }
    }

}

