package duke.Exception;

/**
 * Represents the exception happens when the user trying to create an Event
 * without giving it a time.
 */
public class NoEventTimeException extends EventException {
    /**
     * Prepare the message to be printed when this exception is experienced.
     *
     * @return the message
     */
    public String getMessage() {
        return "☹ OOPS!!! You should enter a time for event.";
    }
}
