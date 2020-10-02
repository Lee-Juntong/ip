package duke.Task;


import java.time.LocalDate;

/**
 * Represents the task objects.
 * Contains a String <\code>description</\code> , which is the description of the task,
 * and a boolean <\code>isDone</\code>, which is the status of the task.
 * Provides methods to mark a task as done(either during user input or reading from file),
 * get the value of <\code>isDone</\code>,
 * convert the <\code>Task</\code> object to a string to be printed out or write to a file.
 */
public abstract class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Mark a task's status as done.
     */
    public void markAsDone() {
        this.isDone = true;
    }

    public abstract String fileString();

    /**
     * Provides the status of the task as a icon.
     *
     * @return returns a tick if the task is done, and returns a cross if the task is not done
     */
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718");
        //return tick or X symbols
    }

    /**
     * Prepare the string to be printed in the list.
     *
     * @return the common part for Event, Deadline, Todo
     */
    public String toString() {
        return "[" + getStatusIcon() + "]" + description;
    }

    /**
     * Provides the date of the task.
     *
     * @return the LocalDate get from LocalDateTime
     */
    public LocalDate getDate() {
        return null;
    }

    /**
     * Provides the String variable of the description of this task.
     *
     * @return the description of this task
     */
    public String getDescription() {
        return description;
    }
}



