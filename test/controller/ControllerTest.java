package controller;

import entities.Decoder;
import interfaces.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ControllerTest {

    private static final String EMPTY = "";
    private ILoggerOutput iLoggerOutput;

    @BeforeEach
    void setUp() {
        iLoggerOutput = new ILoggerOutput() {
            @Override
            public String getOutput() {
                return EMPTY;
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

            @Override
            public void clearResults() {

            }
        };
    }

    @Test
    void performMovementsIntoPlateauWithNullData() {
        IDecoder iDecoder = (input, loggerOutput) -> {
            Assertions.assertEquals(input, EMPTY);
            Assertions.assertEquals(loggerOutput, iLoggerOutput);
            return null;
        };
        IOutput iOutput = (loggerOutput, inputData) -> {
            Assertions.assertEquals(iLoggerOutput, loggerOutput);
            Assertions.assertNull(inputData);
        };
        Controller controller = new Controller(iDecoder, iLoggerOutput, null);
        controller.performMovementsIntoPlateau(EMPTY, iOutput);
    }

    @Test
    void performMovementsIntoPlateau() {
        IDecoderOutput iDecoderOutput = new Decoder.DecoderOutput(null, null, null);

        IDecoder iDecoder = (input, loggerOutput) -> {
            Assertions.assertEquals(input, EMPTY);
            Assertions.assertEquals(loggerOutput, iLoggerOutput);
            return iDecoderOutput;
        };

        IOutput iOutput = (loggerOutput, inputData) -> {
            Assertions.assertEquals(iLoggerOutput, loggerOutput);
            Assertions.assertEquals(iDecoderOutput, inputData);
        };

        ISimulator iSimulator = (inputData, logger) -> {
            Assertions.assertEquals(inputData, iDecoderOutput);
            Assertions.assertEquals(logger, iLoggerOutput);
        };

        Controller controller = new Controller(iDecoder, iLoggerOutput, iSimulator);
        controller.performMovementsIntoPlateau(EMPTY, iOutput);
    }
}