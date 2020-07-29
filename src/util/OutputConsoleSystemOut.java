package util;

public class OutputConsoleSystemOut implements IOutput {
    @Override
    public void exposeResults(ILoggerOutput loggerOutput, Decoder.Data inputData) {
        if (inputData != null) {
            System.out.println(inputData.getMarsRovers().get(0));
        }
    }
}
