package controller;

import interfaces.*;

/**
 * This class is the main controller of the program.
 * It has the logic to receive an input string and start the process of decoding instructions,
 * moving rovers and expose information to whom it may concern
 */
public class Controller {
    /**
     * IDecoder used to decode input instruction set
     */
    private final IDecoder decoder;
    /**
     * ILoggerOutput used to write the program output log
     */
    private final ILoggerOutput loggerOutput;

    /**
     * ISimulator used to run rovers movements
     */
    private final ISimulator simulator;

    /**
     * Class constructor
     *
     * @param decoder      IDecoder to read the input string
     * @param loggerOutput ILogger to write the output log
     * @param simulator    ISimulator to run rovers movements
     * @see IDecoder
     * @see ILoggerOutput
     * @see ISimulator
     */
    public Controller(IDecoder decoder, ILoggerOutput loggerOutput, ISimulator simulator) {
        this.decoder = decoder;
        this.loggerOutput = loggerOutput;
        this.simulator = simulator;
    }

    /**
     * This method internally modifies each rover's position and expose the results to whom may it concern
     *
     * @param str     String with the input, this contains the plateau, rovers and instructions set.
     * @param iOutput IOutput used to expose the expedition results
     */
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
