package duke.Command;

import duke.Storage.Storage;
import duke.TaskList.TaskList;
import duke.UI.UI;
import duke.exception.DukeException;

public class FindCommand extends Command{

    /**
     * Execute the command based on the specific command type
     *
     * @param tasks   the list of tasks
     * @param ui      do outputs
     * @param storage store the data
     * @throws DukeException the exceptions can happen in this program, to be handled based on the specific exception
     */
    @Override
    public void execute(TaskList tasks, UI ui, Storage storage) throws DukeException {

    }
}
