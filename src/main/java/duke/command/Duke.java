package duke.command;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.ToDo;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Duke {

    private static ArrayList<Task> tasks = new ArrayList<>();
    public static final String FILE_PATH = ("D:\\CS2113T\\ip\\data\\data.txt");

    private static final int LENGTH_OF_TYPE_DEADLINE = 8;
    private static final int LENGTH_OF_TYPE_TO_DO = 4;
    private static final int LENGTH_OF_TYPE_EVENT = 5;

    private static final int DATA_TASK_TYPE_INDEX = 0;
    private static final int DATA_TASK_STATUS_INDEX = 1;
    private static final int DATA_TASK_NAME_INDEX = 2;
    private static final int DATA_TASK_TIME_INDEX = 3;

    public static void main(String[] args) {
        printGreet();
        receiveCommand();
    }

    private static void printGreet() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        printSeparation();
        System.out.println("    Hey kid! I'm Duke *^u^*");
        System.out.println("    Seems like... you need some help? 0v0");
        printSeparation();
    }

    public static void printBye() {
        printSeparation();
        System.out.println("    Ok cool. Hope to see you again soon... QAQ");
        printSeparation();
    }

    public static void receiveCommand() {
        String line;
        Scanner in = new Scanner(System.in);

        try {
            createFile();
        } catch (IllegalStateException e) {
            System.out.println("    File error at receive command!");
        }

        do {
            line = in.nextLine();
            if (line.equalsIgnoreCase("bye")) {
                printBye();
                break;
            } else if (line.equalsIgnoreCase("list")) {
                printList(tasks);
            } else if (line.contains("done")) {
                updateTaskStatus(tasks, line);
            } else if (line.contains("todo")) {
                addToDo(line);
            } else if (line.contains("deadline")) {
                addDeadline(line);
            } else if (line.contains("event")) {
                addEvent(line);
            } else if (line.contains("delete")) {
                deleteTask(line);
            } else {
                //CommandDoesNotExist
                printSeparation();
                System.out.println("    OOPS!!! I'm sorry, but I don't know what that means :-(");
                printSeparation();
            }
        } while (!line.equalsIgnoreCase("bye"));
    }

    public static void printList(ArrayList<Task> tasks) {
        printSeparation();
        if (Task.numOfTasks==0) {
            //EmptyListException
            System.out.println("    Dude, the list is empty! o_O");
        } else {
            System.out.println("    Here is the list of your tasks: ");
            for (int i = 0; i < Task.numOfTasks; i++) {
                int index = i+1;
                System.out.format("    %d.", index);
                tasks.get(i).printTask();
            }
        }
        printSeparation();
    }

    public static void updateTaskStatus(ArrayList<Task> tasks, String line) {
        try {
            line = line.trim();
            int startOfTaskIndex = line.indexOf(' ') + 1;
            int taskIndex = Integer.parseInt(line.substring(startOfTaskIndex)) - 1;
            Task task = tasks.get(taskIndex);
            task.markTaskAsDone();
            writeToFile();
            printSeparation();
            System.out.println("    Nice! I've marked this task as done: ");
            System.out.format("    ");
            tasks.get(taskIndex).printTask();
            printSeparation();
        } catch (ArrayIndexOutOfBoundsException e) {
            printSeparation();
            System.out.println("    OOPS!!! There is no such thing as task number 0.");
            printSeparation();
        } catch (NullPointerException | IndexOutOfBoundsException e) {
            printSeparation();
            System.out.println("    OOPS!!! The task does not exist.");
            printSeparation();
        }
    }

    public static void addToDo(String line) {
        try {
            String taskName = line.substring(LENGTH_OF_TYPE_TO_DO + 1);
            ToDo t = new ToDo(taskName);
            addTaskToList(t);
        } catch (StringIndexOutOfBoundsException | IOException e) {
            printSeparation();
            System.out.println("    OOPS!!! The description of a todo cannot be empty.");
            printSeparation();
        }
    }

    public static void addDeadline(String line) {
        try {
            int endOfTaskNameIndex = line.indexOf('/', LENGTH_OF_TYPE_DEADLINE) - 1;
            String taskName = line.substring(LENGTH_OF_TYPE_DEADLINE +1, endOfTaskNameIndex);

            int startOfTaskTimeIndex = line.indexOf("/by") + 4;
            String taskTime = line.substring(startOfTaskTimeIndex);

            Deadline d = new Deadline(taskName, taskTime);
            addTaskToList(d);
        } catch (StringIndexOutOfBoundsException | IOException e) {
            printSeparation();
            System.out.println("    OOPS!!! Both the description and time of a deadline cannot be empty.");
            printSeparation();
        }
    }

    public static void addEvent(String line) {
        try {
            int endOfTaskNameIndex = line.indexOf('/', LENGTH_OF_TYPE_EVENT) - 1;
            String taskName = line.substring(LENGTH_OF_TYPE_EVENT +1, endOfTaskNameIndex);

            int startOfTaskTimeIndex = line.indexOf("/at") + 4;
            String taskTime = line.substring(startOfTaskTimeIndex);

            Event e = new Event(taskName, taskTime);

            addTaskToList(e);
        } catch (StringIndexOutOfBoundsException | IOException e) {
            printSeparation();
            System.out.println("    OOPS!!! Both the description and time of an event cannot be empty.");
            printSeparation();
        }
    }

    public static void addTaskToList(Task t) throws IOException {
        tasks.add(t);
        appendToFile(t);

        Task.numOfTasks++;

        printSeparation();
        System.out.println("    " + "Got it. I've added this task: ");

        System.out.format("    ");
        t.printTask();;

        System.out.format("    Now you have %d task%s in the list.%n", Task.numOfTasks,
                (Task.numOfTasks == 1) ? "" : "s");
        printSeparation();
    }

    public static void deleteTask(String line) {
        try {
            line = line.trim();
            int startOfTaskIndex = line.indexOf(' ') + 1;
            int taskIndex = Integer.parseInt(line.substring(startOfTaskIndex)) - 1;


            printSeparation();

            System.out.println("    Noted. I'll removed this task: ");
            System.out.format("    ");
            tasks.get(taskIndex).printTask();;
            tasks.remove(taskIndex);
            writeToFile();

            Task.numOfTasks--;
            System.out.println("    Task removed successfully!");
            System.out.println("    Now you have " + Task.numOfTasks + " task" + (Task.numOfTasks>1?"s":"") + " in the list.");
            printSeparation();
        } catch (IndexOutOfBoundsException e) {
            printSeparation();
            System.out.println("    OOPS!!! The task does not exist.");
            printSeparation();
        }
    }

    private static void printSeparation() {
        System.out.println("    ____________________________________________________________");
    }

    public static void createFile() {
        try {
            File f = new File(FILE_PATH); // create a File for the given file path

            if (!f.exists()) {
                f.createNewFile();
            } else {
                readFile();
                System.out.println("    File already exists.");
            }
        } catch (IOException e) {
            System.out.println("Something went wrong when creating file: " + e.getMessage());
        }
    }

    private static void writeToFile () {
        try {
            FileWriter fw = new FileWriter(FILE_PATH);
            for (int i = 0; i<tasks.size(); i++) {
                String fileInput = tasks.get(i).toString();
                fw.write(System.lineSeparator() + fileInput);
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Something went wrong when writing to file: " + e.getMessage());
        }
    }

    private static void appendToFile (Task t) throws IOException {
        FileWriter fw = new FileWriter(FILE_PATH, true);
        String fileInput = t.toString();
        fw.write(System.lineSeparator() + fileInput);
        fw.close();
    }

    private static void readFile() {
        ArrayList<String> dataList = new ArrayList<>();

        try {
            String line;
            BufferedReader br = new BufferedReader(new FileReader(FILE_PATH));
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
     * This function decodes the data in data.txt according to Task types
     * @param dataList
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
                    Task toDo = createToDoTask(taskArgs);
                    tasks.add(toDo);
                    Task.numOfTasks++;
                    break;
                case ('D'):
                    Task deadline = createDeadlineTask(taskArgs);
                    tasks.add(deadline);
                    Task.numOfTasks++;
                    break;
                case ('E'):
                    Task event = createEventTask(taskArgs);
                    tasks.add(event);
                    Task.numOfTasks++;
                    break;
                default:
                    System.out.println("None of the Task types.");
            }
        }
    }

    /**
     * The following 3 functions create task from reading the file data.txt
     * @param todoArgs or deadlineArgs or eventArgs
     * @return todo or deadline or event
     */
    private static Task createToDoTask(ArrayList<String> todoArgs) {
        String taskStatus = todoArgs.get(DATA_TASK_STATUS_INDEX);
        String taskName = todoArgs.get(DATA_TASK_NAME_INDEX);

        Task todo;
        if (taskStatus.equals("1")) {
            todo = new ToDo(taskName);
            todo.markTaskAsDone();
        } else {
            todo = new ToDo(taskName);
        }
        return todo;
    }

    private static Task createDeadlineTask(ArrayList<String> deadlineArgs) {
        String taskStatus = deadlineArgs.get(DATA_TASK_STATUS_INDEX);
        String taskName = deadlineArgs.get(DATA_TASK_NAME_INDEX);
        String taskTime = deadlineArgs.get(DATA_TASK_TIME_INDEX);

        Task deadline;
        if (taskStatus.equals("1")) {
            deadline = new Deadline(taskName, taskTime);
            deadline.markTaskAsDone();
        } else {
            deadline = new Deadline(taskName, taskTime);
        }
        return deadline;
    }

    private static Task createEventTask(ArrayList<String> deadlineArgs) {
        String taskStatus = deadlineArgs.get(DATA_TASK_STATUS_INDEX);
        String taskName = deadlineArgs.get(DATA_TASK_NAME_INDEX);
        String taskTime = deadlineArgs.get(DATA_TASK_TIME_INDEX);

        Task event;
        if (taskStatus.equals("1")) {
            event = new Event(taskName, taskTime);
            event.markTaskAsDone();
        } else {
            event = new Event(taskName, taskTime);
        }
        return event;
    }

}
