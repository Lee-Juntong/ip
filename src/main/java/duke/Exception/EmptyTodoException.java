package duke.Exception;

/**
 * Represents the case when the user want to create an empty Todo.
 */
public class EmptyTodoException extends TodoException {
    /**
     * Prepare the message to be printed when this exception is experienced.
     *
     * @return the message
     */
    public String getMessage() {
        return "☹ OOPS!!! The description of a todo cannot be empty.";
    }
}
