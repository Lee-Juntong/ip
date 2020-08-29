public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public void markAsDone() {
        this.isDone = true;
        System.out.println("____________________________________________________________");
        System.out.println("Nice! I've marked this task as done: ");
        System.out.println(toString());
        System.out.println("____________________________________________________________");
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718");
        //return tick or X symbols
    }

    public static void printTaskList(Task[] tasks) {
        int numPrintedTasks = 0;
        System.out.println("____________________________________________________________");
        System.out.println(" Here are the tasks in your list:");
        for (Task task : tasks) {
            if (task == null) {
                break;
            }
            numPrintedTasks++;
            System.out.println(numPrintedTasks + ". " + task.toString());

        }
        System.out.println("____________________________________________________________");
    }

    public String toString() {
        return "[" + getStatusIcon() + "]" + description;
    }
}


