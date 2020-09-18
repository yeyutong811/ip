package duke.command;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.ToDo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Duke {

    private static ArrayList<Task> tasks = new ArrayList<>();
    public static final String FILE_PATH = ("D:\\CS2113T\\ip\\data\\data.txt");

    private static final int lengthOfTypeDeadline = 8;
    private static final int lengthOfTypeToDo = 4;
    private static final int lengthOfTypeEvent = 5;

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
            String taskName = line.substring(lengthOfTypeToDo + 1);
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
            int endOfTaskNameIndex = line.indexOf('/', lengthOfTypeDeadline) - 1;
            String taskName = line.substring(lengthOfTypeDeadline+1, endOfTaskNameIndex);

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
            int endOfTaskNameIndex = line.indexOf('/', lengthOfTypeEvent) - 1;
            String taskName = line.substring(lengthOfTypeEvent+1, endOfTaskNameIndex);

            int startOfTaskTimeIndex = line.indexOf("/at") + 4;
            String taskTime = line.substring(startOfTaskTimeIndex);

            Event e = new Event(taskName, taskTime);

            addTaskToList(e);
        } catch (StringIndexOutOfBoundsException | IOException e) {
            printSeparation();
            System.out.println("    OOPS!!! Both the description and time of a event cannot be empty.");
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
                System.out.println("    File already exists.");
            }
        } catch  (IOException e) {
            System.out.println("Something went wrong when creating file: " + e.getMessage());
        }
    }

    private static void writeToFile () {
        try {
            FileWriter fw = new FileWriter(FILE_PATH);
            for (Task task : tasks) {
                String fileInput = task.toString();
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
}
