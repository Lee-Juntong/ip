package duke.Parser;

import duke.Command.*;
import duke.exception.*;
import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.Todo;

public abstract class Parser {
    public static final String EXIT = "bye";
    public static final String PRINT_TASK_LIST = "list";
    public static final String TASK_DONE = "done";
    public static final String ADD_EVENT = "event";
    public static final String ADD_DEADLINE = "deadline";
    public static final String ADD_TODO = "todo";
    public static final String TASK_DELETE = "delete";

    public static Command parse(String fullCommand) throws DukeException {
    // this block deals with exit and list command
        if (fullCommand.equals(EXIT)) {
            return new ExitCommand();
        } else if (fullCommand.equals(PRINT_TASK_LIST)) {
            return new PrintFullListCommand();
        }

        String[] words = fullCommand.split(" ");

        int taskIndex;//to indicate what is the task we are dealing with. may not be used.

        //this block deals with done command
        if (words[0].equals(TASK_DONE)) {
            if (fullCommand.substring(4).isBlank()) {
                throw new EmptyDoneException();
            }
            try {
                taskIndex=Integer.parseInt(fullCommand.substring(5))-1;
            } catch (NumberFormatException e) {
                throw new DoneNumberFormatException();
            }
            try {
                return new DoneCommand(taskIndex);
            } catch (IndexOutOfBoundsException e) {
                throw new DoneUndefinedTaskException();
            }
        }
        //this block deals with delete command
        if (words[0].equals(TASK_DELETE)) {
            if (fullCommand.substring(6).isBlank()) {//parse
                throw new EmptyDeleteException();
            }
            try {
                taskIndex = Integer.parseInt(fullCommand.substring(7)) - 1;
            } catch (NumberFormatException e) {
                throw new DeleteNumberFormatException();
            }
            //DeleteUndefinedTaskException is thrown when performing DeleteCommand.execute
            return new DeleteCommand(taskIndex);
        }

        //this block deals with add command
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







        throw new WrongCommandException();
    }
}
