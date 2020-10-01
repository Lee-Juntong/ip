package duke.Command;

import duke.Storage.Storage;
import duke.TaskList.TaskList;
import duke.UI.UI;
import duke.exception.DukeException;

/**
 * Represents the command to be executed
 */
public abstract class Command {
    protected boolean isExit = false;

    /**
     * Execute the command based on the specific command type
     *
     * @param tasks   the list of tasks
     * @param ui      do outputs
     * @param storage store the data
     * @throws DukeException the exceptions can happen in this program, to be handled based on the specific exception
     */
    public abstract void execute(TaskList tasks, UI ui, Storage storage) throws DukeException;

    public boolean isExit() {
        return isExit;
    }
}
