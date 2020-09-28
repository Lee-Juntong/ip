package duke.TaskList;

import duke.task.Task;

import java.util.ArrayList;

/**
 * contains the list of the tasks and provides ways to delete/add/mark as done tasks
 */
public class TaskList {
    private ArrayList<Task> tasks;

    /**
     * construct the tasks as an empty ArrayList
     */
    public TaskList(){
        tasks=new ArrayList<Task>();
    }

    /**
     * when loading from the file, create the list as provided in the file
     * @param tasks provided by <code>Storage::load()</code>
     * @see duke.Storage.Storage
     */
    public TaskList(ArrayList<Task> tasks){
        this.tasks=tasks;
    }
    public void addTask
}
