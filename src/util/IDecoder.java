package util;

public interface IDecoder {
    Decoder.Data decodeInput(String input, ILoggerOutput loggerOutput);
}
