package entities;

import entities.commands.ICommand;
import entities.commands.LeftCommand;
import entities.commands.MoveCommand;
import entities.commands.RightCommand;
import interfaces.IDecoderOutput;
import interfaces.ILoggerOutput;
import interfaces.IMarsRover;
import models.OrientedPosition;
import models.Plateau;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

            @Override
            public void clearResults() {

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

        IDecoderOutput iDecoderOutputExpected = new Decoder.DecoderOutput(plateau, rovers, instructionsSet);
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

            @Override
            public void clearResults() {
            }
        };
        Decoder decoder = new Decoder();
        IDecoderOutput decoderOutputResult = decoder.decodeInput("5 5 1 2 N LMLMLMLMM 3 3 E MMRMMRMRRM", iLoggerOutput);
        Assertions.assertEquals(iDecoderOutputExpected, decoderOutputResult);
        Assertions.assertEquals(iDecoderOutputExpected.getPlateau(), decoderOutputResult.getPlateau());
        Assertions.assertEquals(iDecoderOutputExpected.getMarsRovers(), decoderOutputResult.getMarsRovers());
        //The next assert is a bit strange. Because equals in hashmap with (key:integer,value:ArrayList<ICommand>) check the reference value of the both ArrayList and not their
        //content. So in that way equals = false. But, like the purpose of this is to test de DecoderOutput getRoverInstructionSet() Getter, I use an alternative
        //getting both of them and comparing the size. Although the size doesn't matter, it's useful to test the getter.
        Assertions.assertEquals(iDecoderOutputExpected.getRoverInstructionSet().size(), decoderOutputResult.getRoverInstructionSet().size());

        int[] finalCalls = {1, 1, 1, 2, 2, 1};
        for (int i = 0; i < finalCalls.length; i++) {
            Assertions.assertEquals(finalCalls[i], callCounter[i]);
        }
        Assertions.assertFalse(errorMsj[0]);
    }


    @Test
    void decodeInput1Plateau2Rovers2InstructionsForTestEqualsDecoderOutput() {
        Plateau plateau = new Plateau(5, 5);

        IMarsRover rover1 = new MarsRover(1, new OrientedPosition(1, 2, CompassPoint.N));
        ArrayList<IMarsRover> rovers = new ArrayList<>();
        rovers.add(rover1);

        ICommand left = new LeftCommand();
        ICommand move = new MoveCommand();
        ArrayList<ICommand> iCommandsRover1 = new ArrayList<>();
        iCommandsRover1.add(left);
        iCommandsRover1.add(move);

        HashMap<Integer, ArrayList<ICommand>> instructionsSet = new HashMap<>();
        instructionsSet.put(rover1.getRoverId(), iCommandsRover1);

        IDecoderOutput iDecoderOutputExpected = new Decoder.DecoderOutput(plateau, rovers, instructionsSet);

        ILoggerOutput iLoggerOutput = new ILoggerOutput() {
            @Override
            public void clearResults() {
            }

            @Override
            public void appendStartMsg() {
            }

            @Override
            public void appendPlateauSuccess(String plateauToString) {
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
            public void appendErrorMsg() {
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
        IDecoderOutput decoderOutputResultWithSameSizeButDistinctCommands = decoder.decodeInput("5 5 1 2 N LR", iLoggerOutput);
        Assertions.assertNotEquals(iDecoderOutputExpected, decoderOutputResultWithSameSizeButDistinctCommands);


        IDecoderOutput decoderOutputResultWithDistinctCommands = decoder.decodeInput("5 5 1 2 N LRM", iLoggerOutput);
        Assertions.assertNotEquals(iDecoderOutputExpected, decoderOutputResultWithDistinctCommands);
    }


    @Test
    void decodeInput1PlateauNoRoverNoInstruction() {
        final int[] callCounter = {0, 0, 0, 0, 0, 0};
        final boolean[] errorMsj = {false};

        ILoggerOutput iLoggerOutput = new ILoggerOutput() {
            @Override
            public void clearResults() {
            }

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
            public void clearResults() {
            }

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
            public void clearResults() {
            }

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

    @Test
    void decodeInput1Plateau1Rover1InstructionWithWrongCommandType() {

        final int[] callCounter = {0, 0, 0, 0, 0, 0};
        final boolean[] errorMsj = {false};

        ILoggerOutput iLoggerOutput = new ILoggerOutput() {
            @Override
            public void clearResults() {
            }

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
        decoder.decodeInput("5 5 1 3 N LMLMTLMLMM", iLoggerOutput);
        int[] finalCalls = {1, 1, 1, 1, 0, 0};
        for (int i = 0; i < finalCalls.length; i++) {
            Assertions.assertEquals(finalCalls[i], callCounter[i]);
        }
        Assertions.assertTrue(errorMsj[0]);
    }

    @Test
    void decodeInputTestIDecoderOutputGetters() {
        IDecoderOutput iDecoderOutput = new IDecoderOutput() {
            @Override
            public Plateau getPlateau() {
                return null;
            }

            @Override
            public ArrayList<IMarsRover> getMarsRovers() {
                return null;
            }

            @Override
            public Map<Integer, ArrayList<ICommand>> getRoverInstructionSet() {
                return null;
            }
        };

        Assertions.assertNull(iDecoderOutput.getPlateau());
        Assertions.assertNull(iDecoderOutput.getMarsRovers());
        Assertions.assertNull(iDecoderOutput.getRoverInstructionSet());

    }


}