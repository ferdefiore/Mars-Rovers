package interfaces;

/**
 * This class provides behaviour to save messages in a log.
 * It expose method to every possible message to append to the log,
 * and also have method to append unset messages and clear the log.
 * <p>
 * There are two types of methods.
 * One of them receive a String parameter to append it in the log,
 * there are several of them because by each possible input string
 * the logger should append an extra message.
 * <p>
 * The other has not a parameter. It means that the logger should
 * know what message to append.
 * <p>
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
