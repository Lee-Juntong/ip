package duke.exception;
/**
 * Represents the case when the user types find but do not specify
 * the key word
 */
public class EmptyFindException extends DukeException {
    /**
     * Prepare the message to be printed when this exception is experienced
     *
     * @return the message
     */
    public String getMessage() {
        return "☹ OOPS!!! You should enter the key word of the tasks you want to find.";
    }
}
