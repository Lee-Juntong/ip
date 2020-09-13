package duke;

import java.util.ArrayList;
import java.util.Scanner;

import duke.exception.EmptyEventException;
import duke.exception.WrongCommandException;
import duke.exception.InvalidCommandException;
import duke.exception.EmptyTodoException;
import duke.exception.EmptyDeadlineException;
import duke.exception.NoEventTimeMakerException;
import duke.exception.NoEventTimeException;
import duke.exception.NoDeadlineTimeMarkerException;
import duke.exception.NoDeadlineTimeException;
import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.Todo;

public class Main {

    public static final String EXIT = "bye";
    public static final String PRINT_TASK_LIST = "list";
    public static final String TASK_DONE = "done";
    public static final String ADD_EVENT = "event";
    public static final String ADD_DEADLINE = "deadline";
    public static final String ADD_TODO = "todo";

    private static ArrayList<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {

        printGreetingMessage();

        Scanner in = new Scanner(System.in);


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

    private static int respondMultiWordCommand(ArrayList<Task> tasks, String command, int numTask) {
        String[] words = command.split(" ");
        if (words[0].equals(TASK_DONE)) {
            tasks.get(Integer.parseInt(words[1]) - 1).markAsDone();
        } else {

            try {
                numTask = addTask(words[0], tasks, command, numTask);
            } catch (WrongCommandException e) {
                printLine();
                System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                printLine();
            } catch (EmptyTodoException e) {
                System.out.println("☹ OOPS!!! The description of a todo cannot be empty.");
            } catch (EmptyDeadlineException e) {
                System.out.println("☹ OOPS!!! The description of a deadline cannot be empty.");
            } catch (NoDeadlineTimeMarkerException e) {
                System.out.println("☹ OOPS!!! You should mark the time for a deadline with \"/by\"");
            } catch (NoDeadlineTimeException e) {
                System.out.println("☹ OOPS!!! You should enter a time for deadline.");
            } catch (EmptyEventException e) {
                System.out.println("☹ OOPS!!! The description of a event cannot be empty.");
            } catch (NoEventTimeMakerException e) {
                System.out.println("☹ OOPS!!! You should mark the time for an event with \"/at\"");
            } catch (NoEventTimeException e) {
                System.out.println("☹ OOPS!!! You should enter a time for event.");
            } catch (InvalidCommandException e) {
                System.out.println("unknown error happens.");
                //this is not reachable as all Invalid Commands are dealt above
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

    private static int addTask(String beginning, ArrayList<Task> tasks, String command, int numTask) throws InvalidCommandException {

        int dividerPosition;
        if (!beginning.equals(ADD_TODO)
                && !beginning.equals(ADD_DEADLINE)
                && !beginning.equals(ADD_EVENT)) {
            throw new WrongCommandException();
        }

        switch (beginning) {
            case ADD_EVENT:
                dividerPosition = command.indexOf("/at");

                if (command.substring(5).isBlank()) {
                    throw new EmptyEventException();
                }
                if (dividerPosition == -1) {
                    throw new NoEventTimeMakerException();
                }
                if (command.substring(5, dividerPosition).isBlank()) {
                    throw new EmptyEventException();
                }
                try {
                    command.substring(dividerPosition + 4);
                } catch (StringIndexOutOfBoundsException e) {
                    throw new NoEventTimeException();
                }

                tasks.add(new Event(command.substring(6, dividerPosition), command.substring(dividerPosition + 4)));
                break;
            case ADD_DEADLINE:
                dividerPosition = command.indexOf("/by");

                if (command.substring(8).isBlank()) {
                    throw new EmptyDeadlineException();
                }
                if (dividerPosition == -1) {
                    throw new NoDeadlineTimeMarkerException();
                }
                if (command.substring(8, dividerPosition).isBlank()) {
                    throw new EmptyDeadlineException();
                }
                try {
                    command.substring(dividerPosition + 4);
                } catch (StringIndexOutOfBoundsException e) {
                    throw new NoDeadlineTimeException();
                }

                tasks.add(new Deadline(command.substring(9, dividerPosition), command.substring(dividerPosition + 4)));
                break;
            case ADD_TODO:

                try {
                    if (command.substring(5).isBlank()) {
                        throw new EmptyTodoException();
                    }
                    tasks.add(new Todo(command.substring(5)));
                } catch (StringIndexOutOfBoundsException e) {
                    throw new EmptyTodoException();
                }

                break;
            default:
                break;
        }

        //printing works below
        printLine();
        System.out.println("Got it. I've added this task: ");
        System.out.println(tasks.get(numTask).toString());
        //if you don't enter event/deadline/todo here, then there will be error as a null pointer is being accessed
        numTask++;
        System.out.println("Now you have " + numTask + " tasks in the list.");
        printLine();
        return numTask;
    }
}


