package duke.UI;


import duke.task.Task;


import java.util.ArrayList;
import java.util.Scanner;

/**
 * UI receives all user inputs, and produces outputs show to the user
 */
public class UI {

    private final Scanner in;
    public UI() {
        in=new Scanner(System.in);
    }

    /**
     * reads the user input line by line
     * @return the string of the line
     */
    public String readCommand(){
        return in.nextLine();
    }

    /**
     * prints the logo of DUKE and greet the user
     */
    public void printGreetingMessage() {
        printLine();

        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        System.out.println("What can I do for you?");
    }

    /**
     * prints the separator
     */
    public void printLine() {
        System.out.println("____________________________________________________________");
    }

    /**
     * prints all the tasks with labels, based on the input list
     * @param tasks an <\code>ArrayList</\code> of tasks to be printed one by one
     */
    public void printTaskList(ArrayList<Task> tasks) {
        int numPrintedTasks = 0;

        System.out.println(" Here are the tasks in your list:");
        for (Task task : tasks) {
            numPrintedTasks++;
            System.out.println(numPrintedTasks + ". " + task.toString());
        }
    }

    /**
     * shows the error message when experiencing exceptions
     * @param message the message get from the error
     */
    public void showError(String message){
        System.out.println(message);
    }

    /**
     * shows the error message during loading. Since the general IO exception is
     * handled when executing the process, the error leads to this would be the file
     * is edited in a wrong way
     */
    public void showLoadingError(){
        System.out.println("You edit the file in a wrong format. Please check.");
    }

    /**
     * prints the message during executing commands.
     * this function is used to make all printing being done in UI
     * @param message determined by the command
     */
    public void print(String message){
        System.out.print(message);
    }
}
