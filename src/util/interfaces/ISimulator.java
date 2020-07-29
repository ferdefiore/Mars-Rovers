package util.interfaces;

import util.Decoder;

public interface ISimulator {
    void run(Decoder.Data inputData, ILoggerOutput logger);
}
