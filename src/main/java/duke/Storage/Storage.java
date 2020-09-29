package duke.Storage;

import duke.exception.LoadingException;
import duke.exception.WritingFileException;
import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.Todo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * this class creates the folder and file path if it's not already created
 * prepare the data in the file to be used
 * writes data when exit
 */
public class Storage {
    public static final String REGEX_IN_FILE = "//";
    private String filePath;

    /**
     * set the <code>filepath </code> according to the user input
     *
     * @param filePath is the path of the file
     */
    public Storage(String filePath) {
        this.filePath = filePath;
        createFolderAndFIle(filePath);
    }

    /**
     * Creates the folder and file if not already crated
     *
     * @param filePath the String of the relative path
     */
    private static void createFolderAndFIle(String filePath) {

        try {
            new File(filePath).createNewFile();
        } catch (IOException e) {
            System.out.println("The file \"" + filePath + "\" is not created");
        }
    }

    /**
     * @return the path of the file
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * save the data of the task list to the file
     *
     * @param tasks the list of tasks provided by a variable from a TaskList object
     * @throws WritingFileException represents the file is not correctly written
     */
    public void writeFile(ArrayList<Task> tasks) throws WritingFileException {
        try {
            FileWriter fw = new FileWriter(filePath);
            for (Task task : tasks) {
                fw.write(task.fileString());
                fw.write(System.lineSeparator());
            }
            fw.close();
        } catch (IOException e) {
            throw new WritingFileException();
        }
    }

    /**
     * Prepares the data in the file as an ArrayList, which is used to construct the TaskList
     *
     * @return the tasks in an ArrayList
     * @throws LoadingException represents the <code>tasks</code> is not correctly created
     */
    public ArrayList<Task> load() throws LoadingException {
        ArrayList<Task> tasks = new ArrayList<Task>();
        File dataFile = new File(filePath);
        try {
            Scanner s = new Scanner(dataFile);
            while (s.hasNext()) {
                String[] words = s.nextLine().split(REGEX_IN_FILE);
                switch (words[0]) {
                    case "T":
                        tasks.add(new Todo(words[2]));
                        if (Integer.parseInt(words[1]) == 1) {
                            tasks.get(tasks.size() - 1).markAsDone(true);
                        }
                        break;
                    case "E":
                        tasks.add(new Event(words[2], words[3]));
                        if (Integer.parseInt(words[1]) == 1) {
                            tasks.get(tasks.size() - 1).markAsDone(true);
                        }
                        break;
                    case "D":
                        tasks.add(new Deadline(words[2], words[3]));
                        if (Integer.parseInt(words[1]) == 1) {
                            tasks.get(tasks.size() - 1).markAsDone(true);
                        }
                        break;
                    default:
                        throw new LoadingException();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        } catch (IndexOutOfBoundsException e) {
            throw new LoadingException();
        }
        return tasks;
    }
}
