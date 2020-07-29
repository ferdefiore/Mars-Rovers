package util;


public class LoggerOutput implements ILoggerOutput {

    private final String LINE = "\n";
    private final String DOUBLE_LINE = "\n\n";
    private static final String NASA_HISTORY = "------------------------------------NASA NAVIGATION HISTORY------------------------------------ \n\n";
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

    private String output = "";

    @Override
    public String getOutput() {
        return output;
    }

    @Override
    public void appendSimpleMessage(String msg) {
        output += msg;
        output += LINE;
    }

    @Override
    public void appendPlateauSuccess(String plateauToString) {
        output += PLATEAU_SUCCESS;
        output += plateauToString;
        output += DOUBLE_LINE;
    }

    @Override
    public void appendErrorMsg() {
        output += INPUT_ERROR;
    }


    @Override
    public void appendStartMsg() {
        output += NASA_HISTORY;
        output += START_DECODING;
        output += TRY_DECODE_PLATEAU;
    }

    @Override
    public void appendStartDecodeRAI() {
        output += TRY_DECODE_RAI;
    }

    @Override
    public void appendDecodedRover(String roverToString) {
        output += DECODED_ROVER;
        output += roverToString;
        output += LINE;
    }

    @Override
    public void appendInstructions(String instruction) {
        output += DECODED_INS_SET;
        output += instruction;
        output += DOUBLE_LINE;
    }

    @Override
    public void appendFinishMsg() {
        output += FINISH_DECODE;
        output += ROVERS_LANDED;
        output += ROVERS_OUTPUT;
    }

    @Override
    public void appendRoverFinalPosition(String roverToString) {
        output += roverToString;
        output += LINE;
    }
}
