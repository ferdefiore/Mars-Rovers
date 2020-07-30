package interfaces;

/**
 * Interface that provides behavior to serve information to whom it cares.
 * Implemented by a view to show on UI log information and by another class that
 * expose information by standard output
 */
public interface IOutput {
    /**
     * @param loggerOutput        who contains the log information
     * @param inputIDecoderOutput who contains the output decoded
     */
    void exposeResults(ILoggerOutput loggerOutput, IDecoderOutput inputIDecoderOutput);
}
