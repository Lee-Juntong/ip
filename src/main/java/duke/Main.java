package duke;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import duke.exception.*;
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
    public static final String TASK_DELETE = "delete";

    private static ArrayList<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {

        printGreetingMessage();

        //if the user use this app for the 1st time, the folder and file will be created automatically
        Path filePath = readData();
        Scanner in = new Scanner(System.in);

        String command;

        while (true) {
            command = in.nextLine();

            if (command.equals(EXIT)) {
                break;
            } else if (command.equals(PRINT_TASK_LIST)) {
                Task.printTaskList(tasks);
                continue;
            }
            //the above are single word command

            respondMultiWordCommand(tasks, command);
        }
        writeFile(filePath);
        printExitMessage();
    }


    private static Path readData() {
        Path filePath = createFolderAndFIle();
        File dataFile = new File(String.valueOf(filePath));
        try {
            Scanner s = new Scanner(dataFile);
            while (s.hasNext()) {
                String[] words = s.nextLine().split("//");
                switch (words[0]) {
                    case "T":
                        tasks.add(new Todo(words[2]));
                        if (Integer.parseInt(words[1])==1){
                            tasks.get(tasks.size()-1).markAsDone(true);
                        }
                        break;
                    case "E":
                        tasks.add(new Event(words[2],words[3]));
                        if (Integer.parseInt(words[1])==1){
                            tasks.get(tasks.size()-1).markAsDone(true);
                        }
                        break;
                    case "D":
                        tasks.add(new Deadline(words[2],words[3]));
                        if (Integer.parseInt(words[1])==1){
                            tasks.get(tasks.size()-1).markAsDone(true);
                        }
                        break;
                    default:
                        System.out.println("You edit the file in a wrong format. Please check.");
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        } catch (IndexOutOfBoundsException e){
            System.out.println("You edit the file in a wrong format. Please check.");
        }
        return filePath;
    }

    private static void writeFile(Path filePath) {
        try {
            FileWriter fw = new FileWriter(String.valueOf(filePath));
            for (Task task : tasks) {
                fw.write(task.fileString());
                fw.write(System.lineSeparator());
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("something went wrong when writing to file");
        }
    }


    private static Path createFolderAndFIle() {
        String home = System.getProperty("user.dir");

        Path folderPath = java.nio.file.Paths.get(home, "data");
        Path filePath = java.nio.file.Paths.get(home, "data", "duke.txt");

        if (!java.nio.file.Files.exists(folderPath)) {
            //System.out.println(folderPath); testing
            try {
                java.nio.file.Files.createDirectory(folderPath);
            } catch (IOException e) {
                System.out.println("The folder \"data\" is not created");
            }
        }
        if (!java.nio.file.Files.exists(filePath)) {
            try {
                java.nio.file.Files.createFile(filePath);
            } catch (IOException e) {
                System.out.println("The file \"duke.txt\" is not created");
            }
        }
        return filePath;
    }

    private static void printNumTask() {
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
    }

    private static void deleteTask(int taskIndex) throws DeleteUndefinedTaskException {
        if (taskIndex <= -1 || taskIndex >= tasks.size()) {
            throw new DeleteUndefinedTaskException();
        }

        printLine();
        System.out.println("Noted. I've removed this task: ");
        System.out.println(tasks.get(taskIndex).toString());
        tasks.remove(taskIndex);
        printNumTask();
        printLine();

    }

    private static void doneTask(int taskIndex) throws DoneUndefinedTaskException {
        try {
            tasks.get(taskIndex).markAsDone();
        } catch (IndexOutOfBoundsException e) {
            throw new DoneUndefinedTaskException();
        }
    }

    private static void deleteOrDoneTask(String beginning, String command)
            throws EmptyDoneException, DoneUndefinedTaskException, EmptyDeleteException, DeleteUndefinedTaskException {

        if (beginning.equals(TASK_DONE)) {
            if (command.substring(4).isBlank()) {
                throw new EmptyDoneException();
            }
            doneTask(Integer.parseInt(command.substring(5)) - 1);
        } else {
            if (command.substring(6).isBlank()) {
                throw new EmptyDeleteException();
            }
            deleteTask(Integer.parseInt(command.substring(7)) - 1);
        }
    }

    private static void respondMultiWordCommand(ArrayList<Task> tasks, String command) {
        String[] words = command.split(" ");
        if (words[0].equals(TASK_DONE) || words[0].equals(TASK_DELETE)) {
            try {
                deleteOrDoneTask(words[0], command);

            } catch (DoneUndefinedTaskException | DeleteUndefinedTaskException e) {
                printLine();
                System.out.println("☹ OOPS!!! There isn't a task labeled " + words[1]);
                printLine();
            } catch (EmptyDeleteException e) {
                printLine();
                System.out.println("☹ OOPS!!! You should enter the index of the task you want to delete.");
                printLine();
            } catch (EmptyDoneException e) {
                printLine();
                System.out.println("☹ OOPS!!! You should enter the index of the task you have done.");
                printLine();
            }
        } else {
            try {
                addTask(words[0], tasks, command);
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

    private static void addTask(String beginning, ArrayList<Task> tasks, String command) throws InvalidCommandException {

        int dividerPosition;


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
                throw new WrongCommandException();

        }

        //printing works below
        printLine();
        System.out.println("Got it. I've added this task: ");
        System.out.println(tasks.get(tasks.size() - 1).toString());
        printNumTask();
        printLine();

    }
}


