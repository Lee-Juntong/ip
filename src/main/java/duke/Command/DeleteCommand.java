package duke.Command;

import duke.Storage.Storage;
import duke.TaskList.TaskList;
import duke.UI.UI;
import duke.exception.DeleteUndefinedTaskException;
import duke.exception.DukeException;

/**
 * Represents the command call when the user deletes some task
 */
public class DeleteCommand extends Command{
    private int taskIndex;

    public DeleteCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }
    /**
     * Delete the task, and update the file
     *
     * @param tasks   the list of tasks
     * @param ui      do outputs
     * @param storage store the data
     * @throws DukeException the exceptions can happen in this program, to be handled based on the specific exception
     */
    @Override
    public void execute(TaskList tasks, UI ui, Storage storage) throws DukeException {
        if (taskIndex <= -1 || taskIndex >= tasks.size()) {
            throw new DeleteUndefinedTaskException(taskIndex+1);
        }
        ui.printDeleteMessage(tasks.get(taskIndex));
        tasks.remove(taskIndex);
        ui.printNumTask(tasks.size());
        storage.writeFile(tasks.getTaskList());
    }
}
