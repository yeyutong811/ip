package duke.storage;

import duke.task.Task;
import duke.tasklist.TaskList;

import java.io.*;
import java.util.ArrayList;

/**
 * Represents storage data.
 */
public class Storage {
    public static String filePath;

    public Storage(String input) {
        filePath = input;
        load();
    }

    /**
     * If the file "data.txt" exists, reads the file.
     * If the file "data.txt" does not exist, creates the file.
     */
    public static void createFile() {
        try {
            File f = new File(filePath); // create a File for the given file path

            if (!f.exists()) {
                f.createNewFile();
            } else {
                readFile();
            }
        } catch (IOException e) {
            System.out.println("Something went wrong when creating file: " + e.getMessage());
        }
    }

    /**
     * Writes data into the file "data.txt".
     */
    public static void writeToFile () {
        try {
            FileWriter fw = new FileWriter(filePath);
            for (int i = 0; i< TaskList.tasks.size(); i++) {
                String fileInput = TaskList.tasks.get(i).toString();
                fw.write(System.lineSeparator() + fileInput);
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Something went wrong when writing to file: " + e.getMessage());
        }
    }

    /**
     * Appends data into the end of the file "data.txt".
     */
    public static void appendToFile (Task t) throws IOException {
        FileWriter fw = new FileWriter(filePath, true);
        String fileInput = t.toString();
        fw.write(System.lineSeparator() + fileInput);
        fw.close();
    }

    /**
     * Reads data from the file "data.txt".
     */
    private static void readFile() {
        ArrayList<String> dataList = new ArrayList<>();

        try {
            String line;
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null) {
                dataList.add(line);
            }
        } catch (IOException e) {
            System.out.println("Something went wrong when reading file.");
        } finally {
            decodeTaskData(dataList);
        }
    }

    /**
     * Decodes the data in data.txt according to Task types.
     * @param dataList ArrayList of the data string in the file "data.txt".
     */

    private static void decodeTaskData(ArrayList<String> dataList) {
        for (int i=1; i< dataList.size(); i++) {
            char taskType = dataList.get(i).charAt(0);
            ArrayList<String> taskArgs = new ArrayList<>();
            String[] taskArgsArray = dataList.get(i).split("[|]");

            for (String arg: taskArgsArray) {
                taskArgs.add(arg.trim());
            }

            switch (taskType) {
                case ('T'):
                    Task toDo = TaskList.createToDoTask(taskArgs);
                    TaskList.tasks.add(toDo);
                    Task.numOfTasks++;
                    break;
                case ('D'):
                    Task deadline = TaskList.createDeadlineTask(taskArgs);
                    TaskList.tasks.add(deadline);
                    Task.numOfTasks++;
                    break;
                case ('E'):
                    Task event = TaskList.createEventTask(taskArgs);
                    TaskList.tasks.add(event);
                    Task.numOfTasks++;
                    break;
                default:
                    System.out.println("None of the Task types.");
            }
        }
    }

    /**
     * Loads the file "data.txt".
     */
    public static void load() {
        try {
            createFile();
        } catch (IllegalStateException e) {
            System.out.println("    File error at receive command!");
        }
    }
}
