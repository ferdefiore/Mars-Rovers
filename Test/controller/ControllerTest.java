
package controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.*;

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
        Decoder.Data decoderData = new Decoder.Data(null, null, null);

        IDecoder iDecoder = (input, loggerOutput) -> {
            Assertions.assertEquals(input, EMPTY);
            Assertions.assertEquals(loggerOutput, iLoggerOutput);
            return decoderData;
        };

        IOutput iOutput = (loggerOutput, inputData) -> {
            Assertions.assertEquals(iLoggerOutput, loggerOutput);
            Assertions.assertEquals(decoderData, inputData);
        };

        ISimulator iSimulator = (inputData, logger) -> {
            Assertions.assertEquals(inputData, decoderData);
            Assertions.assertEquals(logger, iLoggerOutput);
        };

        Controller controller = new Controller(iDecoder, iLoggerOutput, iSimulator);
        controller.performMovementsIntoPlateau(EMPTY, iOutput);
    }
}