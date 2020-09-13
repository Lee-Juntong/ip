package duke.task;

import duke.task.Task;

public class Event extends Task {

    protected String at;

    public String fileString() {
        return "E//" + (isDone ? 1 : 0) + "//" + description + "//" + at;
    }

    public Event(String description, String at) {
        super(description);
        this.at = at;
    }

    public String toString() {
        return "[E]" + super.toString() + " (at: " + at + ")";
    }
}
