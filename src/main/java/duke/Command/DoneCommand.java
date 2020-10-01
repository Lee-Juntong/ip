package duke.Command;

import duke.Storage.Storage;
import duke.TaskList.TaskList;
import duke.UI.UI;
import duke.exception.DoneUndefinedTaskException;
import duke.exception.DukeException;

/**
 * Represents the command call when the user mark a task as done
 */
public class DoneCommand extends Command {
    private final int taskIndex;

    public DoneCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    /**
     * Mark the task as done, and update the file
     *
     * @param tasks   the list of tasks
     * @param ui      do outputs
     * @param storage store the data
     * @throws DukeException the exceptions can happen in this function, to be handled based on the specific exception
     */
    @Override
    public void execute(TaskList tasks, UI ui, Storage storage) throws DukeException {
        if (taskIndex <= -1 || taskIndex >= tasks.size()) {
            throw new DoneUndefinedTaskException(taskIndex + 1);
        }
        tasks.doneTask(taskIndex);
        ui.printDoneMessage(tasks.get(taskIndex));
        storage.writeFile(tasks.getTaskList());
    }
}
