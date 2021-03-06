package duke.Command;

import duke.Storage.Storage;
import duke.TaskList.TaskList;
import duke.UI.UI;
import duke.Exception.DukeException;
import duke.Task.Task;

/**
 * Represents the command call when the user adds some task.
 */
public class AddCommand extends Command {
    private final Task taskToBeAdded;


    public AddCommand(Task taskToBeAdded) {
        this.taskToBeAdded = taskToBeAdded;
    }

    /**
     * Adds the task, and update the file.
     *
     * @param tasks   the list of tasks
     * @param ui      do outputs
     * @param storage store the data
     * @throws DukeException the exceptions can happen in this function, to be handled based on the specific exception
     */
    @Override
    public void execute(TaskList tasks, UI ui, Storage storage) throws DukeException {
        tasks.addTask(taskToBeAdded);
        ui.printAddTaskMessage(taskToBeAdded);
        ui.printNumTask(tasks.size());
        storage.writeFile(tasks.getTaskList());
    }
}
