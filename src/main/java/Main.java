import java.util.Scanner;


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

    private static int respondMultiWordCommand(Task[] tasks, String command, int numTask) {
        String[] words = command.split(" ");
        if (words[0].equals(TASK_DONE)) {
            tasks[Integer.parseInt(words[1]) - 1].markAsDone();
        } else {
            numTask = addTask(words[0], tasks, command, numTask);
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
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
    }

    private static int addTask(String beginning, Task[] tasks, String command, int numTask) {
        printLine();
        int dividerPosition;
        System.out.println("Got it. I've added this task: ");
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
                tasks[numTask] = new Todo(command.substring(5));
                break;
            default:
                System.out.println("芜湖 起飞");
                break;
        }
        System.out.println(tasks[numTask].toString());
        //if you don't enter event/deadline/todo here, then there will be error as a null pointer is being accessed
        numTask++;
        System.out.println("Now you have " + numTask + " tasks in the list.");
        printLine();
        return numTask;
    }
}


