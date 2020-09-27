package duke.ui;

import duke.task.Task;

import java.util.ArrayList;

public class Ui {
    public static void printGreet() {
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

    public static void printSeparation() {
        System.out.println("    ____________________________________________________________");
    }

    public static void printTaskAddedMessage(Task t) {
        System.out.println("    " + "Got it. I've added this task: ");

        System.out.format("    ");
        t.printTask();
        ;

        System.out.format("    Now you have %d task%s in the list.%n", Task.numOfTasks,
                (Task.numOfTasks == 1) ? "" : "s");
    }

    public static void printTaskNotExistMessage() {
        System.out.println("    OOPS!!! The task does not exist.");
    }

    public static void printMissingTaskDescriptionMessage(String s) {
        System.out.println("    OOPS!!! The description of a" + s + " cannot be empty.");
    }

    public static void printMarkTaskDoneMessage() {
        System.out.println("    Nice! I've marked this task as done: ");
    }

    public static void printTaskRemovedMessage() {
        System.out.println("    Task removed successfully!");
        System.out.println("    Now you have " + Task.numOfTasks + " task" + (Task.numOfTasks>1?"s":"") + " in the list.");
    }

    public static void printRemovingTaskMessage() {
        System.out.println("    Noted. I'll removed this task: ");
    }
}
