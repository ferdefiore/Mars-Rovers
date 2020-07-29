package util.interfaces;

public interface ILoggerOutput {
    String getOutput();

    void appendPlateauSuccess(String plateauToString);

    void appendErrorMsg();

    void appendStartMsg();

    void appendStartDecodeRAI();

    void appendDecodedRover(String roverToString);

    void appendInstructions(String instruction);

    void appendFinishMsg();

    void appendRoverFinalPosition(String roverToString);

    void appendSimpleMessage(String message);
}
