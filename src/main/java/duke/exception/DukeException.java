package duke.exception;

/**
 * Represents all exceptions that may happen in this project
 * that should be handled in UI
 */
public class DukeException extends Exception {
    /**
     * A trivial message of an error
     * @return the message
     */
    public String getMessage(){
        return "this is an error";
    }
}
