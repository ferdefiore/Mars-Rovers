package entities;


import interfaces.ILoggerOutput;

/**
 * This class implements ILoggerOutput.
 * It represents a logger that save every log message.
 * It expose method to every possible message to append to the log,
 * and also have method to append unset messages and clear the log.
 */
public class LoggerOutput implements ILoggerOutput {

    //Constants strings used to write the log
    private final String LINE = "\n";
    private final String DOUBLE_LINE = "\n\n";
    private static final String NASA_HISTORY = "------------------------------------NASA EXPEDITION RESULTS------------------------------------ \n\n";
    private final String START_DECODING = "********************************STARTING DECODING INSTRUCTIONS******************************** \n\n";
    private final String TRY_DECODE_PLATEAU = "***********************************TRYING TO DECODE PLATEAU*********************************** \n\n";
    private final String PLATEAU_SUCCESS = "PLATEAU DECODED SUCCESSFULLY: ";
    private final String TRY_DECODE_RAI = "*************************TRYING TO DECODE ROVERS AND INSTRUCTIONS SET************************* \n\n";
    private final String DECODED_ROVER = "DECODED ROVER: ";
    private final String DECODED_INS_SET = "DECODED INSTRUCTION SET: ";
    private final String FINISH_DECODE = "******************************DECODING INSTRUCTIONS FINISHED********************************** \n\n";
    private final String ROVERS_LANDED = "*****************MARS ROVERS ARE SUCCESSFULLY LANDED AND STARTING NAVIGATION****************** \n\n";
    private final String ROVERS_OUTPUT = "*******************************MARS ROVERS OUTPUT INFORMATION********************************* \n\n";
    private final String INPUT_ERROR = "*****************THE ROVERS CANT START NAVIGATION BECAUSE OF SOME INPUT ERROR***************** \n\n";
    //End of constants

    /**
     * String used to append all the messages
     */
    private String output = "";

    /**
     * @return a String with the output information saved
     */
    @Override
    public String getOutput() {
        return output;
    }

    /**
     * Method used to append unset messages to the log
     *
     * @param msg String with the message
     */
    @Override
    public void appendSimpleMessage(String msg) {
        output += msg;
        output += LINE;
    }

    /**
     * Method used to clear the log information
     */
    @Override
    public void clearResults() {
        output = "";
    }

    /**
     * Method to append a success decoded message and plateau information
     *
     * @param plateauToString Plateau information
     * @see models.Plateau
     */
    @Override
    public void appendPlateauSuccess(String plateauToString) {
        output += PLATEAU_SUCCESS;
        output += plateauToString;
        output += DOUBLE_LINE;
    }

    /**
     * Method to append an error message
     */
    @Override
    public void appendErrorMsg() {
        output += INPUT_ERROR;
    }


    /**
     * Method to append the start decoding message
     */
    @Override
    public void appendStartMsg() {
        output += NASA_HISTORY;
        output += START_DECODING;
        output += TRY_DECODE_PLATEAU;
    }

    /**
     * Method to append message when starting decoding rovers and instructions
     */
    @Override
    public void appendStartDecodeRAI() {
        output += TRY_DECODE_RAI;
    }


    /**
     * Method to append a decoded rover information
     */
    @Override
    public void appendDecodedRover(String roverToString) {
        output += DECODED_ROVER;
        output += roverToString;
        output += LINE;
    }


    /**
     * Method to append the decoded rover's instructions
     */
    @Override
    public void appendInstructions(String instruction) {
        output += DECODED_INS_SET;
        output += instruction;
        output += DOUBLE_LINE;
    }


    /**
     * Method to append an the finish decode message
     */
    @Override
    public void appendFinishMsg() {
        output += FINISH_DECODE;
        output += ROVERS_LANDED;
        output += ROVERS_OUTPUT;
    }


    /**
     * Method to append a rover position
     */
    @Override
    public void appendRoverFinalPosition(String roverToString) {
        output += roverToString;
        output += LINE;
    }
}
