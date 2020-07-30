package interfaces;

/**
 * This interface should provide behavior to read the information in an input string,
 * log the decoding results and return the decoded data.
 */
public interface IDecoder {

    /**
     * Return the decoded data
     *
     * @param input        String with the instructions to be decoded
     * @param loggerOutput ILoggerOutput to save the decoding log results
     * @return decoded information in a IDecoderOutput
     * @see IDecoderOutput
     * @see ILoggerOutput
     */
    IDecoderOutput decodeInput(String input, ILoggerOutput loggerOutput);
}
