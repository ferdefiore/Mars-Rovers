package entities;

import entities.commands.CommandFactory;
import entities.commands.ICommand;
import interfaces.IDecoder;
import interfaces.IDecoderOutput;
import interfaces.ILoggerOutput;
import interfaces.IMarsRover;
import models.OrientedPosition;
import models.Plateau;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * This class implements IDecoder
 * This class represents a decoder used to read the input information
 *
 * @see IDecoder
 */
public class Decoder implements IDecoder {

    /**
     * Main method used to decode input String
     *
     * @param input        String with the input information
     * @param loggerOutput ILoggerOutput used to log every decoding steps and errors
     * @return IDecoderOutput based on the DecoderOutput inner class with the decoded information served
     */
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

    /**
     * Private method to decode the Plateau from the input String
     */
    private Plateau decodePlateau(Scanner scanner, ILoggerOutput loggerOutput) {
        loggerOutput.appendStartMsg();
        int plateauDimensionWidth = scanner.nextInt();
        int plateauDimensionHeight = scanner.nextInt();
        Plateau decodedPlateau = new Plateau(plateauDimensionWidth, plateauDimensionHeight);
        loggerOutput.appendPlateauSuccess(decodedPlateau.toString());
        return decodedPlateau;
    }

    /**
     * Private method to decode from the input String the Rovers and Instructions set for each rover
     */
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

    /**
     * Private method that iterates every char in a String, and return the
     * corresponded list of ICommand for that string. If some char of the string
     * not matches with a Command it will throw an IllegalArgumentException
     */
    private ArrayList<ICommand> stringToICommandList(String str) {
        ArrayList<ICommand> commands = new ArrayList<>();
        for (char c : str.toCharArray()) {
            if (CommandFactory.charToCommand.containsKey(c)) {
                commands.add(CommandFactory.charToCommand.get(c));
            } else throw new IllegalArgumentException("Illegal argument " + c + " in instructions.");
        }
        return commands;
    }

    /**
     * InnerClass used to return the decoded information.
     * As this class is only created here, that's why its placed as InnerClass
     * This class implements IDecoderOutput
     * @see IDecoderOutput
     */
    public static class DecoderOutput implements IDecoderOutput {
        /**
         * @see Plateau
         */
        private final Plateau plateau;

        /**
         * @see MarsRover
         */
        private final ArrayList<IMarsRover> marsRovers;

        /**
         * @see ICommand
         */
        private final Map<Integer, ArrayList<ICommand>> roverInstructionSet;

        /**
         * @return Plateau
         * @see Plateau
         */
        @Override
        public Plateau getPlateau() {
            return plateau;
        }


        /**
         * @return An ArrayList with IMarsRovers
         * @see IMarsRover
         */
        @Override
        public ArrayList<IMarsRover> getMarsRovers() {
            return marsRovers;
        }


        /**
         * @return A Map with < key:Integer,value:ArrayList < ICommand > >
         * @see ICommand
         */
        @Override
        public Map<Integer, ArrayList<ICommand>> getRoverInstructionSet() {
            return roverInstructionSet;
        }


        /**
         * Class Constructor
         *
         * @param plateau             Plateau
         * @param marsRovers          List of IMarsRovers
         * @param roverInstructionSet Hash with (roverId, List rover's ICommand)
         * @see Plateau
         * @see IMarsRover
         * @see ICommand
         */
        public DecoderOutput(Plateau plateau, ArrayList<IMarsRover> marsRovers, Map<Integer, ArrayList<ICommand>> roverInstructionSet) {
            this.plateau = plateau;
            this.marsRovers = marsRovers;
            this.roverInstructionSet = roverInstructionSet;
        }

        /**
         * @param o Object to compare with the DecoderOutput
         * @return true if every attribute(recursive equals) of Object o is the same as the DecoderOutput
         */
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

