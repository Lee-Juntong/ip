package duke.TaskList;

import duke.exception.DoneUndefinedTaskException;
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

    /**
     * Adds a task to the list
     * @param taskToBeAdded may be Todo/Event/Deadline based on the usage
     */
    public void addTask(Task taskToBeAdded){
        tasks.add(taskToBeAdded);
    }
    public void deleteTask(int taskIndex){
        tasks.remove(taskIndex);
    }
    public void doneTask(int taskIndex) throws DoneUndefinedTaskException {
        try {
            tasks.get(taskIndex).markAsDone();
        } catch (IndexOutOfBoundsException e) {
            throw new DoneUndefinedTaskException();
        }
    }

    /**
     * Gives the access to the list of tasks
     * @return the <code>ArrayList<task></code> object to be printed
     */
    public ArrayList<Task> getTaskList(){
        return tasks;
    }

    /**
     * @return the size of the ArrayList in the TaskList object
     */
    public int size(){
        return tasks.size();
    }

    /**
     * remove the task indicated by the user
     * @param taskIndex the index of the task that the user want to delete
     */
    public void remove(int taskIndex) {
        tasks.remove(taskIndex);
    }
}
