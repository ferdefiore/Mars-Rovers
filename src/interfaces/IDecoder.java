package interfaces;

public interface IDecoder {
    IDecoderOutput decodeInput(String input, ILoggerOutput loggerOutput);
}
