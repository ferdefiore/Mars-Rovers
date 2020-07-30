package interfaces;

/**
 * This interface provides a method heather to run the ICommands on the IMarsRovers and log the results.
 * The needed information is inside inputIDecoderOutput, that was provided by the IDecoder who reads the input string
 * and create a data object with all this information.
 */
public interface ISimulator {
    void run(IDecoderOutput inputIDecoderOutput, ILoggerOutput logger);
}
