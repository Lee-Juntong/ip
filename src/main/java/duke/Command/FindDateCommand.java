package duke.Command;

import duke.Storage.Storage;
import duke.TaskList.TaskList;
import duke.UI.UI;
import duke.exception.DukeException;
import duke.exception.NoTaskDateException;
import duke.task.Task;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Represents the command call when the user want to find the tasks in certain date
 */
public class FindDateCommand extends Command {
    private final LocalDate date;

    public FindDateCommand(LocalDate date) {
        this.date = date;
    }

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
        ArrayList<Task> filteredTaskList = tasks.filterDateWith(date);
        if (filteredTaskList.size() == 0) {
            throw new NoTaskDateException();
        }
        ui.printFilteredDateTaskList(filteredTaskList);
    }
}
