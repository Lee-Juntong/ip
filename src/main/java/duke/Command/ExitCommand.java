package duke.Command;

import duke.Storage.Storage;
import duke.TaskList.TaskList;
import duke.UI.UI;
import duke.exception.DukeException;

/**
 * Represents the command call when the user exits this program
 */
public class ExitCommand extends Command {
    /**
     * Mark the status of the program, isExit, as true
     * Also prints the exit message
     *
     * @param tasks   the list of tasks
     * @param ui      do outputs
     * @param storage store the data
     * @throws DukeException the exceptions can happen in this program, to be handled based on the specific exception
     */
    @Override
    public void execute(TaskList tasks, UI ui, Storage storage) throws DukeException {
        isExit = true;
        ui.printExitMessage();

    }
}
