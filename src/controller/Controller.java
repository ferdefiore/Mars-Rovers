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
        IDecoderOutput inputIDecoderOutput;
        inputIDecoderOutput = decoder.decodeInput(str, loggerOutput);
        if (inputIDecoderOutput != null) {
            simulator.run(inputIDecoderOutput, loggerOutput);
        }
        iOutput.exposeResults(loggerOutput, inputIDecoderOutput);
        loggerOutput.clearResults();
    }

}
