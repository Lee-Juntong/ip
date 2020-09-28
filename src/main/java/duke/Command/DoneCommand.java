package duke.Command;

import duke.Storage.Storage;
import duke.TaskList.TaskList;
import duke.UI.UI;
import duke.exception.DoneUndefinedTaskException;
import duke.exception.DukeException;

public class DoneCommand extends Command {
    private int taskIndex;
    public DoneCommand(int taskIndex){
        this.taskIndex=taskIndex;
    }
    public void execute(TaskList tasks, UI ui, Storage storage)throws DukeException{
        tasks.doneTask(taskIndex);
        ui.printDoneMessage();
    };
}
