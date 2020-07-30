package util;

import entities.CompassPoint;
import entities.MarsRover;
import entities.OrientedPosition;
import entities.Plateau;
import entities.commands.CommandFactory;
import entities.commands.ICommand;
import interfaces.IDecoder;
import interfaces.IDecoderOutput;
import interfaces.ILoggerOutput;
import interfaces.IMarsRover;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Decoder implements IDecoder {

    @Override
    public IDecoderOutput decodeInput(String input, ILoggerOutput loggerOutput) {
        Scanner scanner = new Scanner(input);
        ArrayList<IMarsRover> marsRoversList = new ArrayList<>();
        HashMap<Integer, ArrayList<ICommand>> instructionsSet = new HashMap<>();
        try {
            Plateau plateau = decodePlateau(scanner, loggerOutput);
            decodeRoversAndInstructions(scanner, marsRoversList, instructionsSet, loggerOutput);
            return new DecoderOutput(plateau, marsRoversList, instructionsSet);
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

    private void decodeRoversAndInstructions(Scanner scanner, ArrayList<IMarsRover> marsRoversList, HashMap<Integer, ArrayList<ICommand>> instructionsSet, ILoggerOutput loggerOutput) {
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
            facingCardinalPoint = CompassPoint.valueOf(scanner.next().toUpperCase());
            marsRoversList.add(new MarsRover(rovId, new OrientedPosition(xPos, yPos, facingCardinalPoint)));
            loggerOutput.appendDecodedRover(marsRoversList.get(rovId - 1).toString());
            instructionsAsString = scanner.next();
            instructionsAsString = instructionsAsString.toUpperCase();
            instructionsSet.put(rovId, stringToICommandList(instructionsAsString));
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

    public static class DecoderOutput implements IDecoderOutput {
        private final Plateau plateau;
        private final ArrayList<IMarsRover> marsRovers;
        private final Map<Integer, ArrayList<ICommand>> roverInstructionSet;

        @Override
        public Plateau getPlateau() {
            return plateau;
        }

        @Override
        public ArrayList<IMarsRover> getMarsRovers() {
            return marsRovers;
        }

        @Override
        public Map<Integer, ArrayList<ICommand>> getRoverInstructionSet() {
            return roverInstructionSet;
        }

        public DecoderOutput(Plateau plateau, ArrayList<IMarsRover> marsRovers, Map<Integer, ArrayList<ICommand>> roverInstructionSet) {
            this.plateau = plateau;
            this.marsRovers = marsRovers;
            this.roverInstructionSet = roverInstructionSet;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            DecoderOutput decoderOutput = (DecoderOutput) o;

            boolean samePlateau = plateau.equals(decoderOutput.plateau);
            boolean sameMarsRovers = marsRovers.equals(decoderOutput.marsRovers);

            for (Integer key : roverInstructionSet.keySet()) {
                if (roverInstructionSet.get(key).size() != decoderOutput.roverInstructionSet.get(key).size()) {
                    return false;
                }
                ArrayList<ICommand> rover2Commands = decoderOutput.roverInstructionSet.get(key);
                int i = 0;
                for (ICommand command : roverInstructionSet.get(key)) {
                    if (!command.equalType(rover2Commands.get(i))) {
                        return false;
                    }
                    i++;
                }
            }

            return (samePlateau && sameMarsRovers);
        }
    }

}

