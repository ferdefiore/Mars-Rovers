package controller;

import interfaces.*;

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
        IData inputIData;
        inputIData = decoder.decodeInput(str, loggerOutput);
        if (inputIData != null) {
            simulator.run(inputIData, loggerOutput);
        }
        iOutput.exposeResults(loggerOutput, inputIData);
    }

}
