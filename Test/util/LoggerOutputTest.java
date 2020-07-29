package util;

import entities.CompassPoint;
import entities.MarsRover;
import entities.OrientedPosition;
import entities.Plateau;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.interfaces.ILoggerOutput;

class LoggerOutputTest {

    private static final String TEST = "TEST";

    //logger constants
    private final String LINE = "\n";
    private final String DOUBLE_LINE = "\n\n";
    private static final String NASA_HISTORY = "------------------------------------NASA NAVIGATION HISTORY------------------------------------ \n\n";
    private final String START_DECODING = "********************************STARTING DECODING INSTRUCTIONS******************************** \n\n";
    private final String TRY_DECODE_PLATEAU = "***********************************TRYING TO DECODE PLATEAU*********************************** \n\n";
    private final String PLATEAU_SUCCESS = "PLATEAU DECODED SUCCESSFULLY: ";
    private final String TRY_DECODE_RAI = "*************************TRYING TO DECODE ROVERS AND INSTRUCTIONS SET************************* \n\n";
    private final String DECODED_ROVER = "DECODED ROVER: ";
    private final String DECODED_INS_SET = "DECODED INSTRUCTION SET: ";
    private final String FINISH_DECODE = "******************************DECODING INSTRUCTIONS FINISHED********************************** \n\n";
    private final String ROVERS_LANDED = "*****************MARS ROVERS ARE SUCCESSFULLY LANDED AND STARTING NAVIGATION****************** \n\n";
    private final String ROVERS_OUTPUT = "*******************************MARS ROVERS OUTPUT INFORMATION********************************* \n\n";
    private final String INPUT_ERROR = "*****************THE ROVERS CANT START NAVIGATION BECAUSE OF SOME INPUT ERROR***************** \n\n";
    private ILoggerOutput loggerOutput;
    MarsRover marsRover = new MarsRover(1, new OrientedPosition(1, 1, CompassPoint.N));

    @BeforeEach
    void setUp() {
        loggerOutput = new LoggerOutput();
    }

    @Test
    void getOutput() {
    }

    @Test
    void appendSimpleMessage() {
        loggerOutput.appendSimpleMessage(TEST);
        Assertions.assertEquals(TEST + LINE, loggerOutput.getOutput());
    }

    @Test
    void appendPlateauSuccess() {
        Plateau plateau = new Plateau(5, 5);
        loggerOutput.appendPlateauSuccess(plateau.toString());
        Assertions.assertEquals(PLATEAU_SUCCESS + plateau.toString() + DOUBLE_LINE, loggerOutput.getOutput());
    }

    @Test
    void appendErrorMsg() {
        loggerOutput.appendErrorMsg();
        Assertions.assertEquals(INPUT_ERROR, loggerOutput.getOutput());
    }

    @Test
    void appendStartMsg() {
        loggerOutput.appendStartMsg();
        Assertions.assertEquals(NASA_HISTORY + START_DECODING + TRY_DECODE_PLATEAU, loggerOutput.getOutput());
    }

    @Test
    void appendStartDecodeRAI() {
        loggerOutput.appendStartDecodeRAI();
        Assertions.assertEquals(TRY_DECODE_RAI, loggerOutput.getOutput());
    }

    @Test
    void appendDecodedRover() {
        loggerOutput.appendDecodedRover(marsRover.toString());
        Assertions.assertEquals(DECODED_ROVER + marsRover.toString() + LINE, loggerOutput.getOutput());
    }

    @Test
    void appendInstructions() {
        String instructions = "LMLMLMLMM";
        loggerOutput.appendInstructions(instructions);
        Assertions.assertEquals(DECODED_INS_SET + instructions + DOUBLE_LINE, loggerOutput.getOutput());
    }

    @Test
    void appendFinishMsg() {
        loggerOutput.appendFinishMsg();
        Assertions.assertEquals(FINISH_DECODE + ROVERS_LANDED + ROVERS_OUTPUT, loggerOutput.getOutput());
    }

    @Test
    void appendRoverFinalPosition() {
        loggerOutput.appendRoverFinalPosition(marsRover.toString());
        Assertions.assertEquals(marsRover.toString() + LINE, loggerOutput.getOutput());
    }
}