package duke.Exception;

/**
 * Represents the exception when the file is not correctly written.
 */
public class WritingFileException extends DukeException {
    /**
     * Prepare the message to be printed when this exception is experienced.
     *
     * @return the message
     */
    public String getMessage() {
        return "something went wrong when writing to file";
    }
}
