package duke.Command;

import duke.Storage.Storage;
import duke.TaskList.TaskList;
import duke.UI.UI;
import duke.exception.DukeException;
import duke.exception.NoMatchingTaskException;
import duke.task.Task;

import java.util.ArrayList;

/**
 * Represents the command call when the user want to find the tasks having a certain keyword
 */
public class FindCommand extends Command {
    private final String filterString;

    public FindCommand(String filterString) {
        this.filterString = filterString;
    }

    /**
     * Find the tasks having the keyword provided by the user, and print that filtered list
     *
     * @param tasks   the list of tasks
     * @param ui      do outputs
     * @param storage store the data
     * @throws DukeException the exceptions can happen in this function, to be handled based on the specific exception
     */
    @Override
    public void execute(TaskList tasks, UI ui, Storage storage) throws DukeException {
        ArrayList<Task> filteredTaskList = tasks.filterWith(filterString);
        if (filteredTaskList.size() == 0) {
            throw new NoMatchingTaskException();
        }
        ui.printFilteredTaskList(filteredTaskList);
    }
}
