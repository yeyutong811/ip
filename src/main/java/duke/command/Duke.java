package duke.command;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.ToDo;

import java.util.Scanner;
import java.util.ArrayList;

public class Duke {

    //private static Task[] commandStorage = new Task[100];
    private static ArrayList<Task> tasks = new ArrayList<>();

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
            } else {
                //CommandDoesNotExist
                printSeparation();
                System.out.println("    OOPS!!! I'm sorry, but I don't know what that means :-(");
                printSeparation();
            }
        } while (line.equalsIgnoreCase("bye") == false);
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
                printTaskDescription(tasks.get(i));
            }
        }
        printSeparation();
    }

    public static void updateTaskStatus(ArrayList<Task> tasks, String line) {
        try {
            line = line.trim();
            int startOfTaskIndex = line.indexOf(' ') + 1;
            int taskIndex = Integer.parseInt(line.substring(startOfTaskIndex)) - 1;
            tasks.get(taskIndex).markTaskAsDone();

            printSeparation();
            System.out.println("    Nice! I've marked this task as done: ");
            System.out.format("    ");
            printTaskDescription(tasks.get(taskIndex));
            printSeparation();
        } catch (NullPointerException e) {
            printSeparation();
            System.out.println("    OOPS!!! The task does not exist.");
            printSeparation();
        } catch (ArrayIndexOutOfBoundsException e) {
            printSeparation();
            System.out.println("    OOPS!!! There is no such thing as task number 0.");
            printSeparation();
        }
    }

    private static void printTaskDescription(Task t) {
        System.out.format("[%s][%s] %s ", t.getTaskType(), t.getStatusIcon(), t.getTaskName());
        switch (t.getTaskType()) {
            case "T":
                System.out.println("");
                break;
            case "D":
                System.out.println("(by: " + t.getTaskTime() + ")");
                break;
            case "E":
                System.out.println("(at: " + t.getTaskTime() + ")");
                break;
        }
    }

    public static void addToDo(String line) {
        try {
            String taskName = line.substring(lengthOfTypeToDo + 1);
            ToDo t = new ToDo(taskName);
            addTaskToList(t);
        } catch (StringIndexOutOfBoundsException e) {
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
        } catch (StringIndexOutOfBoundsException e) {
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
        } catch (StringIndexOutOfBoundsException e) {
            printSeparation();
            System.out.println("    OOPS!!! Both the description and time of a event cannot be empty.");
            printSeparation();
        }
    }

    public static void addTaskToList(Task t) {
        //commandStorage[Task.numOfTasks] = t;
        //added
        tasks.add(t);

        Task.numOfTasks++;

        printSeparation();
        System.out.println("    " + "Got it. I've added this task: ");

        System.out.format("    ");
        printTaskDescription(t);

        System.out.format("    Now you have %d task%s in the list.%n", Task.numOfTasks,
                (Task.numOfTasks == 1) ? "" : "s");
        printSeparation();
    }
    

    private static void printSeparation() {
        System.out.println("    ____________________________________________________________");
    }

}
