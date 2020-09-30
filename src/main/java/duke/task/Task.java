package duke.task;

import java.util.ArrayList;

public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public void markAsDone(boolean isFromFile) {
        if (isFromFile) {
            this.isDone = true;
        }
    }

    public void markAsDone() {
        this.isDone = true;
    }

    public String fileString() {
        return null;
    }

    private static void printLine() {
        System.out.println("____________________________________________________________");
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718");
        //return tick or X symbols
    }

    public static void printTaskList(ArrayList<Task> tasks) {
        int numPrintedTasks = 0;
        printLine();
        System.out.println(" Here are the tasks in your list:");
        for (Task task : tasks) {
            numPrintedTasks++;
            System.out.println(numPrintedTasks + ". " + task.toString());

        }
        printLine();
    }

    public String toString() {
        return "[" + getStatusIcon() + "]" + description;
    }
}



