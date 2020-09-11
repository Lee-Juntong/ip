package duke.task;

import duke.task.Task;

public class Todo extends Task {

    public Todo(String description) {

        super(description);
    }

    public String toString() {

        return "[T]" + super.toString();
    }
}
