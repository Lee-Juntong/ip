package duke.Task;


/**
 * Represents the Todo tasks.
 */
public class Todo extends Task {

    public Todo(String description) {
        super(description);
    }

    /**
     * Convert the information about this Todo to a string that is to be stored in a file.
     *
     * @return the result string to be stored
     */
    public String fileString() {
        return "T//" + (isDone ? 1 : 0) + "//" + description;
    }

    /**
     * Prepare the string to be printed in the list.
     *
     * @return the string required in a certain format
     * Example of the format: [T][✘]a
     */
    public String toString() {
        return "[T]" + super.toString();
    }
}
