package interfaces;

/**
 * This class provides behavior  to save messages in a log.
 * It exposes a method to every possible message to append to the log,
 * and also have a method to append unset messages and clear the log.
 * There are two types of methods.
 * One of them receives a String parameter to append it in the log,
 * there are several of them because by each possible input string
 * the logger should append an extra message.
 * The other has not a parameter. It means that the logger should
 * know what message to append.
 * Also, it provides a method to clean the log.
 */
public interface ILoggerOutput {
    /**
     * @return should return the output log
     */
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

    void clearResults();
}
