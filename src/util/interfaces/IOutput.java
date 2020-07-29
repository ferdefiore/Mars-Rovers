package util.interfaces;

import util.Decoder;

public interface IOutput {
    void exposeResults(ILoggerOutput loggerOutput, Decoder.Data inputData);
}
