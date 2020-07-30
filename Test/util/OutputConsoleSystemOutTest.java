package util;

import entities.CompassPoint;
import entities.OrientedPosition;
import entities.Plateau;
import entities.commands.ICommand;
import interfaces.IDecoderOutput;
import interfaces.ILoggerOutput;
import interfaces.IMarsRover;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Map;

class OutputConsoleSystemOutTest {

    @Test
    void exposeResults() {

        OrientedPosition orientedPosition = new OrientedPosition(1, 1, CompassPoint.N);

        IMarsRover iMarsRover = new IMarsRover() {
            @Override
            public int getRoverId() {
                return 0;
            }

            @Override
            public OrientedPosition getOrientedPosition() {
                return orientedPosition;
            }

            @Override
            public void executeCommands(ArrayList<ICommand> commands, Plateau plateau) {

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
                return null;
            }
        };

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

            }
        };

        OutputConsoleSystemOut outputConsoleSystemOut = new OutputConsoleSystemOut();

        PrintStream originalOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        outputConsoleSystemOut.exposeResults(iLoggerOutput, iDecoderOutput);
        System.setOut(originalOut);
        String expected = "{\"xPos\" : 1, \"yPos\" : 1, \"compassPoint\" : \"N\"}";
        Assertions.assertEquals(expected, outContent.toString());
    }

    @Test
    void exposeResultsWithNulls() {
        OutputConsoleSystemOut outputConsoleSystemOut = new OutputConsoleSystemOut();
        outputConsoleSystemOut.exposeResults(null, null);

    }
}