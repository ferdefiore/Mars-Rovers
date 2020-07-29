package util.interfaces;

import util.Decoder;

public interface IDecoder {
    Decoder.Data decodeInput(String input, ILoggerOutput loggerOutput);
}
