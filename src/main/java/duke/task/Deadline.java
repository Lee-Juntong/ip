package duke.task;

import duke.task.Task;

public class Deadline extends Task {

    protected String by;

    public String fileString() {
        return "D//"+ (isDone ? 1 : 0) + "//" + description + "//" + by;
    }

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    public String toString() {
        return "[D]" + super.toString() + "(by: " + by + ")";
    }
}
