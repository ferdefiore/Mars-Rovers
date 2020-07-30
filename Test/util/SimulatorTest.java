package util;

import entities.OrientedPosition;
import entities.Plateau;
import entities.commands.ICommand;
import interfaces.IDecoderOutput;
import interfaces.ILoggerOutput;
import interfaces.IMarsRover;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class SimulatorTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void runByTryBranch() {

        IMarsRover iMarsRover = new IMarsRover() {
            @Override
            public int getRoverId() {
                return 0;
            }

            @Override
            public OrientedPosition getOrientedPosition() {
                return null;
            }

            @Override
            public void executeCommands(ArrayList<ICommand> commands, Plateau plateau) {
                Assertions.assertNull(commands);
                Assertions.assertNull(plateau);
            }

            @Override
            public void moveForward() {

            }

            @Override
            public void turnRight() {

            }

            @Override
            public void turnLeft() {

            }
        };

        IDecoderOutput iDecoderOutput = new IDecoderOutput() {
            @Override
            public Plateau getPlateau() {
                return null;
            }

            @Override
            public ArrayList<IMarsRover> getMarsRovers() {
                ArrayList<IMarsRover> rovers = new ArrayList<>();
                rovers.add(iMarsRover);
                return rovers;
            }

            @Override
            public Map<Integer, ArrayList<ICommand>> getRoverInstructionSet() {
                return new HashMap<>();
            }
        };

        final int[] c = {0};

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
                c[0]++;
            }

            @Override
            public void appendSimpleMessage(String message) {
            }

            @Override
            public void clearResults() {

            }
        };

        Simulator simulator = new Simulator();
        simulator.run(iDecoderOutput, iLoggerOutput);
        Assertions.assertEquals(1, c[0]);
    }

    @Test
    void runByCatchBranchWithException() {
        String exception = "CATCH ERROR";
        IMarsRover iMarsRover = new IMarsRover() {
            @Override
            public int getRoverId() {
                return 0;
            }

            @Override
            public OrientedPosition getOrientedPosition() {
                return null;
            }

            @Override
            public void executeCommands(ArrayList<ICommand> commands, Plateau plateau) {
                Assertions.assertNull(commands);
                Assertions.assertNull(plateau);
                throw new IllegalStateException(exception);
            }

            @Override
            public void moveForward() {

            }

            @Override
            public void turnRight() {

            }

            @Override
            public void turnLeft() {

            }
        };

        IDecoderOutput iDecoderOutput = new IDecoderOutput() {
            @Override
            public Plateau getPlateau() {
                return null;
            }

            @Override
            public ArrayList<IMarsRover> getMarsRovers() {
                ArrayList<IMarsRover> rovers = new ArrayList<>();
                rovers.add(iMarsRover);
                return rovers;
            }

            @Override
            public Map<Integer, ArrayList<ICommand>> getRoverInstructionSet() {
                return new HashMap<>();
            }
        };

        final int[] c = {0};

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
                c[0]++;
            }

            @Override
            public void clearResults() {

            }
        };

        Simulator simulator = new Simulator();
        simulator.run(iDecoderOutput, iLoggerOutput);
        Assertions.assertEquals(1, c[0]);
    }
}