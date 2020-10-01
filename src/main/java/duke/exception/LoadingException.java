package duke.exception;

/**
 * Represents the exception when the user edit the file in a wrong way
 * Note that the general IO exception such as file not found is handle immediately,
 * instead of throwing another exception
 */
public class LoadingException extends DukeException {
    /**
     * Prepare the message to be printed when this exception is experienced
     *
     * @return the message
     */
    public String getMessage() {
        return "You edit the file in a wrong format. Please check.";
    }
}
