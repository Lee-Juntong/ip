package duke.Command;

import duke.Storage.Storage;
import duke.TaskList.TaskList;
import duke.UI.UI;
import duke.exception.DukeException;

public abstract class Command {
    protected boolean isExit = false;

    public abstract void execute(TaskList tasks, UI ui, Storage storage) throws DukeException;

    public boolean isExit() {
        return isExit;
    }
}
