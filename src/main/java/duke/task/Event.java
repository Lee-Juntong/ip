package duke.task;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents the Event tasks
 */
public class Event extends Task {

    protected LocalDateTime at;

    /**
     * convert the information about this event to a string that is to be stored in a file
     *
     * @return the result string to be stored
     */
    public String fileString() {
        return "E//" + (isDone ? 1 : 0) + "//" + description + "//" + at;
    }

    public Event(String description, LocalDateTime at) {
        super(description);
        this.at = at;
    }

    /**
     * prepare the string to be printed in the list
     *
     * @return the string required in a certain format
     * Example of the format: [E][✘]a  (at: Feb 20 2020 08:00)
     */
    public String toString() {
        return "[E]" + super.toString() + " (at: " + at.format(DateTimeFormatter.ofPattern("MMM d yyyy HH':'mm")) + ")";
    }
}
