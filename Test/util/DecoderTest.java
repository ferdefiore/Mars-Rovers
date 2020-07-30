package util;

import entities.CompassPoint;
import entities.MarsRover;
import entities.OrientedPosition;
import entities.Plateau;
import entities.commands.ICommand;
import entities.commands.LeftCommand;
import entities.commands.MoveCommand;
import entities.commands.RightCommand;
import interfaces.IData;
import interfaces.ILoggerOutput;
import interfaces.IMarsRover;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

class DecoderTest {
    private final static String EMPTY = "";


    @Test
    void decodeInputWithEmptyString() {
        final int[] callCounter = {0};
        ILoggerOutput iLoggerOutput = new ILoggerOutput() {
            @Override
            public String getOutput() {
                return null;
            }

            @Override
            public void appendPlateauSuccess(String plateauToString) {

            }

            @Override
            public void appendErrorMsg() {
                callCounter[0]++;
            }

            @Override
            public void appendStartMsg() {

            }

            @Override
            public void appendStartDecodeRAI() {

            }

            @Override
            public void appendDecodedRover(String roverToString) {

            }

            @Override
            public void appendInstructions(String instruction) {

            }

            @Override
            public void appendFinishMsg() {

            }

            @Override
            public void appendRoverFinalPosition(String roverToString) {

            }

            @Override
            public void appendSimpleMessage(String message) {

            }
        };
        Decoder decoder = new Decoder();
        decoder.decodeInput(EMPTY, iLoggerOutput);
        Assertions.assertEquals(callCounter[0], 1);
    }

    @Test
    void decodeInput1Plateau2Rovers2Instructions() {
        Plateau plateau = new Plateau(5, 5);

        IMarsRover rover1 = new MarsRover(1, new OrientedPosition(1, 2, CompassPoint.N));
        IMarsRover rover2 = new MarsRover(2, new OrientedPosition(3, 3, CompassPoint.E));
        ArrayList<IMarsRover> rovers = new ArrayList<>();
        rovers.add(rover1);
        rovers.add(rover2);

        ICommand left = new LeftCommand();
        ICommand right = new RightCommand();
        ICommand move = new MoveCommand();
        ArrayList<ICommand> iCommandsRover1 = new ArrayList<>();
        iCommandsRover1.add(left);
        iCommandsRover1.add(move);
        iCommandsRover1.add(left);
        iCommandsRover1.add(move);
        iCommandsRover1.add(left);
        iCommandsRover1.add(move);
        iCommandsRover1.add(left);
        iCommandsRover1.add(move);
        iCommandsRover1.add(move);
        ArrayList<ICommand> iCommandsRover2 = new ArrayList<>();
        iCommandsRover2.add(move);
        iCommandsRover2.add(move);
        iCommandsRover2.add(right);
        iCommandsRover2.add(move);
        iCommandsRover2.add(move);
        iCommandsRover2.add(right);
        iCommandsRover2.add(move);
        iCommandsRover2.add(right);
        iCommandsRover2.add(right);
        iCommandsRover2.add(move);

        HashMap<Integer, ArrayList<ICommand>> instructionsSet = new HashMap<>();
        instructionsSet.put(rover1.getRoverId(), iCommandsRover1);
        instructionsSet.put(rover2.getRoverId(), iCommandsRover2);

        IData IDataExpected = new Decoder.DecoderOutput(plateau, rovers, instructionsSet);
        final int[] callCounter = {0, 0, 0, 0, 0, 0};
        final boolean[] errorMsj = {false};

        ILoggerOutput iLoggerOutput = new ILoggerOutput() {
            @Override
            public void appendStartMsg() {
                callCounter[0]++;
            }

            @Override
            public void appendPlateauSuccess(String plateauToString) {
                callCounter[1]++;
            }

            @Override
            public void appendStartDecodeRAI() {
                callCounter[2]++;
            }

            @Override
            public void appendDecodedRover(String roverToString) {
                callCounter[3]++;
            }

            @Override
            public void appendInstructions(String instruction) {
                callCounter[4]++;
            }

            @Override
            public void appendFinishMsg() {
                callCounter[5]++;
            }

            @Override
            public void appendErrorMsg() {
                errorMsj[0] = true;
            }

            @Override
            public String getOutput() {
                return null;
            }

            @Override
            public void appendRoverFinalPosition(String roverToString) {

            }

            @Override
            public void appendSimpleMessage(String message) {

            }
        };
        Decoder decoder = new Decoder();
        IData result = decoder.decodeInput("5 5 1 2 N LMLMLMLMM 3 3 E MMRMMRMRRM", iLoggerOutput);
        Assertions.assertEquals(IDataExpected, result);
        int[] finalCalls = {1, 1, 1, 2, 2, 1};
        for (int i = 0; i < finalCalls.length; i++) {
            Assertions.assertEquals(finalCalls[i], callCounter[i]);
        }
        Assertions.assertFalse(errorMsj[0]);
    }

    @Test
    void decodeInput1PlateauNoRoverNoInstruction() {
        final int[] callCounter = {0, 0, 0, 0, 0, 0};
        final boolean[] errorMsj = {false};

        ILoggerOutput iLoggerOutput = new ILoggerOutput() {
            @Override
            public void appendStartMsg() {
                callCounter[0]++;
            }

            @Override
            public void appendPlateauSuccess(String plateauToString) {
                callCounter[1]++;
            }

            @Override
            public void appendStartDecodeRAI() {
                callCounter[2]++;
            }

            @Override
            public void appendDecodedRover(String roverToString) {
                callCounter[3]++;
            }

            @Override
            public void appendInstructions(String instruction) {
                callCounter[4]++;
            }

            @Override
            public void appendFinishMsg() {
                callCounter[5]++;
            }

            @Override
            public void appendErrorMsg() {
                errorMsj[0] = true;
            }

            @Override
            public String getOutput() {
                return null;
            }

            @Override
            public void appendRoverFinalPosition(String roverToString) {

            }

            @Override
            public void appendSimpleMessage(String message) {

            }
        };
        Decoder decoder = new Decoder();
        decoder.decodeInput("5 5", iLoggerOutput);
        int[] finalCalls = {1, 1, 1, 0, 0, 0};
        for (int i = 0; i < finalCalls.length; i++) {
            Assertions.assertEquals(finalCalls[i], callCounter[i]);
        }
        Assertions.assertTrue(errorMsj[0]);
    }

    @Test
    void decodeInput1Plateau1RoverNoInstruction() {

        final int[] callCounter = {0, 0, 0, 0, 0, 0};
        final boolean[] errorMsj = {false};

        ILoggerOutput iLoggerOutput = new ILoggerOutput() {
            @Override
            public void appendStartMsg() {
                callCounter[0]++;
            }

            @Override
            public void appendPlateauSuccess(String plateauToString) {
                callCounter[1]++;
            }

            @Override
            public void appendStartDecodeRAI() {
                callCounter[2]++;
            }

            @Override
            public void appendDecodedRover(String roverToString) {
                callCounter[3]++;
            }

            @Override
            public void appendInstructions(String instruction) {
                callCounter[4]++;
            }

            @Override
            public void appendFinishMsg() {
                callCounter[5]++;
            }

            @Override
            public void appendErrorMsg() {
                errorMsj[0] = true;
            }

            @Override
            public String getOutput() {
                return null;
            }

            @Override
            public void appendRoverFinalPosition(String roverToString) {

            }

            @Override
            public void appendSimpleMessage(String message) {

            }
        };
        Decoder decoder = new Decoder();
        decoder.decodeInput("5 5 1 3 N", iLoggerOutput);
        int[] finalCalls = {1, 1, 1, 1, 0, 0};
        for (int i = 0; i < finalCalls.length; i++) {
            Assertions.assertEquals(finalCalls[i], callCounter[i]);
        }
        Assertions.assertTrue(errorMsj[0]);
    }

    @Test
    void decodeInput1Plateau1Rover1Instruction() {

        final int[] callCounter = {0, 0, 0, 0, 0, 0};
        final boolean[] errorMsj = {false};

        ILoggerOutput iLoggerOutput = new ILoggerOutput() {
            @Override
            public void appendStartMsg() {
                callCounter[0]++;
            }

            @Override
            public void appendPlateauSuccess(String plateauToString) {
                callCounter[1]++;
            }

            @Override
            public void appendStartDecodeRAI() {
                callCounter[2]++;
            }

            @Override
            public void appendDecodedRover(String roverToString) {
                callCounter[3]++;
            }

            @Override
            public void appendInstructions(String instruction) {
                callCounter[4]++;
            }

            @Override
            public void appendFinishMsg() {
                callCounter[5]++;
            }

            @Override
            public void appendErrorMsg() {
                errorMsj[0] = true;
            }

            @Override
            public String getOutput() {
                return null;
            }

            @Override
            public void appendRoverFinalPosition(String roverToString) {

            }

            @Override
            public void appendSimpleMessage(String message) {

            }
        };
        Decoder decoder = new Decoder();
        decoder.decodeInput("5 5 1 3 N LMLMLMLMM", iLoggerOutput);
        int[] finalCalls = {1, 1, 1, 1, 1, 1};
        for (int i = 0; i < finalCalls.length; i++) {
            Assertions.assertEquals(finalCalls[i], callCounter[i]);
        }
        Assertions.assertFalse(errorMsj[0]);
    }
}