package duke.UI;


import duke.task.Task;


import java.util.ArrayList;
import java.util.Scanner;

public class UI {

    private final Scanner in;
    public UI() {
        in=new Scanner(System.in);
    }

    public String readCommand(){
        return in.nextLine();
    }
    public static void printGreetingMessage() {
        printLine();

        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        System.out.println("What can I do for you?");
    }
    public static void printLine() {
        System.out.println("____________________________________________________________");
    }
    public static void printTaskList(ArrayList<Task> tasks) {
        int numPrintedTasks = 0;

        System.out.println(" Here are the tasks in your list:");
        for (Task task : tasks) {
            numPrintedTasks++;
            System.out.println(numPrintedTasks + ". " + task.toString());
        }
    }
    public static void showError(String message){
        System.out.println(message);
    }
}
