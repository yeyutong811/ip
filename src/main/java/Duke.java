import java.util.Scanner;

public class Duke {

    private static Task[] commandStorage = new Task[100];

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
            }else if (line.equalsIgnoreCase("list")) {
                printList(commandStorage);
            }else if (line.contains("done")) {
                updateTaskStatus(commandStorage, line);
            }else if (line.contains("todo")) {
                addToDo(line);
            }else if (line.contains("deadline")) {
                addDeadline(line);
            }else if (line.contains("event")) {
                addEvent(line);
            }
        } while (line.equalsIgnoreCase("bye") == false);
    }

    public static void addTaskToList(Task t) {
        commandStorage[Task.numOfTasks] = t;
        Task.numOfTasks++;

        printSeparation();
        System.out.println("    " + "Got it. I've added this task: ");

        System.out.format("    ");
        printTaskDescription(t);

        System.out.format("    Now you have %d task%s in the list.%n", Task.numOfTasks,
                (Task.numOfTasks == 1) ? "" : "s");
        printSeparation();
    }

    public static void addToDo(String line) {
        int endOfTypeIndex = 4;
        String taskName = line.substring(endOfTypeIndex+1);
        ToDo t = new ToDo(taskName);
        addTaskToList(t);
    }

    public static void addDeadline(String line) {
        int endOfTypeIndex = 8;

        int endOfTaskNameIndex = line.indexOf('/', endOfTypeIndex) - 1;
        String taskName = line.substring(endOfTypeIndex+1, endOfTaskNameIndex);

        int startOfTaskTimeIndex = line.indexOf("/by") + 4;
        String taskTime = line.substring(startOfTaskTimeIndex);

        Deadline d = new Deadline(taskName, taskTime);

        addTaskToList(d);
    }

    public static void addEvent(String line) {
        int endOfTypeIndex = 5;

        int endOfTaskNameIndex = line.indexOf('/', endOfTypeIndex) - 1;
        String taskName = line.substring(endOfTypeIndex+1, endOfTaskNameIndex);

        int startOfTaskTimeIndex = line.indexOf("/at") + 4;
        String taskTime = line.substring(startOfTaskTimeIndex);

        Event e = new Event(taskName, taskTime);

        addTaskToList(e);
    }

    private static void printTaskDescription(Task t) {
        switch (t.getTaskType()) {
        case "T":
            System.out.println("[" + t.getTaskType() + "][" + t.getStatusIcon() + "] " + t.getTaskName());
            break;
        case "D":
            System.out.println("[" + t.getTaskType() + "][" + t.getStatusIcon() + "] " + t.getTaskName() + " (by: "
                    + t.getTaskTime() + ")");
            break;
        case "E":
            System.out.println("[" + t.getTaskType() + "][" + t.getStatusIcon() + "] " + t.getTaskName() + " (at: "
                    + t.getTaskTime() + ")");
            break;
        }
    }

    public static void printList(Task[] commandStorage) {
        printSeparation();
        if (Task.numOfTasks==0) {
            System.out.println("    Dude, the list is empty! o_O");
        }else {
            System.out.println("    Here is the list of your tasks: ");
            for (int i = 0; i < Task.numOfTasks; i++) {
                int index = i+1;
                System.out.format("    %d.", index);
                printTaskDescription(commandStorage[i]);
            }
        }
        printSeparation();
    }

    public static void updateTaskStatus(Task[] commandStorage, String line) {
        line = line.trim();
        int startOfTaskIndex = line.indexOf(' ') + 1;
        int taskIndex = Integer.parseInt(line.substring(startOfTaskIndex)) - 1;
        commandStorage[taskIndex].markTaskAsDone();

        printSeparation();
        System.out.println("    Nice! I've marked this task as done: ");
        System.out.format("    ");
        printTaskDescription(commandStorage[taskIndex]);
        printSeparation();

    }

    private static void printSeparation() {
        System.out.println("    ____________________________________________________________");
    }

}
