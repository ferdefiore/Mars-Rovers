package controller;

import util.*;

public class Controller {
    private final IDecoder decoder;
    private final ILoggerOutput loggerOutput;
    private final ISimulator simulator;

    public Controller(IDecoder decoder, ILoggerOutput loggerOutput, ISimulator simulator) {
        this.decoder = decoder;
        this.loggerOutput = loggerOutput;
        this.simulator = simulator;
    }

    public void performMovementsIntoPlateau(String str, IOutput iOutput) {
        Decoder.Data inputData;
        inputData = decoder.decodeInput(str, loggerOutput);
        if (inputData != null) {
            simulator.run(inputData, loggerOutput);
        }
        iOutput.exposeResults(loggerOutput, inputData);
    }

}
