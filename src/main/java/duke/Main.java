package duke;

import java.util.Scanner;

import duke.exception.NonCommandException;
import duke.exception.TodoException;
import duke.exception.WrongCommandException;

public class Main {
    public static final int MAX_TASK_CAPACITY = 100;
    public static final String EXIT = "bye";
    public static final String PRINT_TASK_LIST = "list";
    public static final String TASK_DONE = "done";
    public static final String ADD_EVENT = "event";
    public static final String ADD_DEADLINE = "deadline";
    public static final String ADD_TODO = "todo";


    public static void main(String[] args) {

        printGreetingMessage();

        Scanner in = new Scanner(System.in);
        Task[] tasks = new Task[MAX_TASK_CAPACITY];
        String command;
        int numTask = 0;

        while (true) {
            command = in.nextLine();

            if (command.equals(EXIT)) {
                break;
            } else if (command.equals(PRINT_TASK_LIST)) {
                Task.printTaskList(tasks);
                continue;
            }
            //the above are single word command


            numTask = respondMultiWordCommand(tasks, command, numTask);


        }


        printExitMessage();
    }

    private static int respondMultiWordCommand(Task[] tasks, String command, int numTask)  {
        String[] words = command.split(" ");
        if (words[0].equals(TASK_DONE)) {
            tasks[Integer.parseInt(words[1]) - 1].markAsDone();
        } else {

            try {
                numTask = addTask(words[0], tasks, command, numTask);
            } catch (WrongCommandException e) {
                printLine();
                System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                printLine();
            } catch (TodoException e){
                System.out.println("☹ OOPS!!! The description of a todo cannot be empty.");
            }
        }
        return numTask;
    }

    private static void printExitMessage() {
        printLine();
        System.out.println("Bye. Hope to see you again soon!");
        printLine();
    }

    public static void printLine() {
        System.out.println("____________________________________________________________");
    }

    private static void printGreetingMessage() {
        printLine();

        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        System.out.println("What can I do for you?");
    }

    private static int addTask(String beginning, Task[] tasks, String command, int numTask) throws WrongCommandException, TodoException {

        int dividerPosition;
        if (!beginning.equals(ADD_TODO)
                && !beginning.equals(ADD_DEADLINE)
                && !beginning.equals(ADD_EVENT)) {
            throw new WrongCommandException();
        }

        switch (beginning) {
            case ADD_EVENT:
                dividerPosition = command.indexOf("/at");
                tasks[numTask] = new Event(command.substring(6, dividerPosition), command.substring(dividerPosition + 4));
                break;
            case ADD_DEADLINE:
                dividerPosition = command.indexOf("/by");
                tasks[numTask] = new Deadline(command.substring(9, dividerPosition), command.substring(dividerPosition + 4));
                break;
            case ADD_TODO:
                try {
                    tasks[numTask] = new Todo(command.substring(5));
                } catch(StringIndexOutOfBoundsException e){
                    throw new TodoException();
                }
                break;
            default:
                break;
        }

        //printing works below
        printLine();
        System.out.println("Got it. I've added this task: ");
        System.out.println(tasks[numTask].toString());
        //if you don't enter event/deadline/todo here, then there will be error as a null pointer is being accessed
        numTask++;
        System.out.println("Now you have " + numTask + " tasks in the list.");
        printLine();
        return numTask;
    }
}


