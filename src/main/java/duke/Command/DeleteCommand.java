package duke.Command;

import duke.Storage.Storage;
import duke.TaskList.TaskList;
import duke.UI.UI;
import duke.exception.DeleteUndefinedTaskException;
import duke.exception.DukeException;

public class DeleteCommand {
    private int taskIndex;
    public DeleteCommand(int taskIndex){
        this.taskIndex=taskIndex;
    }
    public void execute(TaskList tasks, UI ui, Storage storage)throws DukeException{
        if (taskIndex <= -1 || taskIndex >= tasks.size()) {
            throw new DeleteUndefinedTaskException();
        }

        ui.printLine();
        System.out.println("Noted. I've removed this task: ");
        System.out.println(tasks.getTaskList().get(taskIndex).toString());
        tasks.remove(taskIndex);
        ui.printNumTask(tasks.size());
        ui.printLine();
    }
}
