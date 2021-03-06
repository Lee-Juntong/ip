package duke.Exception;

/**
 * Represents the exception happens when the user trying to create an Event
 * without using \by to give it a time.
 */
public class NoEventTimeMakerException extends EventException {
    /**
     * Prepare the message to be printed when this exception is experienced.
     *
     * @return the message
     */
    public String getMessage() {
        return "☹ OOPS!!! You should mark the time for an event with \"/at\"";
    }
}
