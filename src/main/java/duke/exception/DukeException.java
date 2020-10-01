package duke.exception;

/**
 * Represents all exceptions that may happen in this project
 * that should be handled in UI
 */
public class DukeException extends Exception {
    /**
     * Prepare the message to be printed when the exception is experienced
     * Generally, DukeException should not be thrown in this program
     * @return the message
     */
    public String getMessage(){
        return "There is an unexpected error.";
    };
}
