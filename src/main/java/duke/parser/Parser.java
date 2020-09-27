package duke.parser;

import duke.storage.Storage;
import duke.task.Task;
import duke.tasklist.TaskList;
import duke.ui.Ui;

import java.util.Scanner;

public class Parser {

    public static void receiveCommand() {
        String line;
        Scanner in = new Scanner(System.in);
        Task.numOfTasks = 0;
        Storage.load();

        do {
            line = in.nextLine();
            if (line.equalsIgnoreCase("bye")) {
                Ui.printBye();
                break;
            } else if (line.equalsIgnoreCase("list")) {
                Ui.printList(TaskList.tasks);
            } else if (line.contains("done")) {
                TaskList.updateTaskStatus(TaskList.tasks, line);
            } else if (line.contains("todo")) {
                TaskList.addToDo(line);
            } else if (line.contains("deadline")) {
                TaskList.addDeadline(line);
            } else if (line.contains("event")) {
                TaskList.addEvent(line);
            } else if (line.contains("delete")) {
                TaskList.deleteTask(line);
            } else {
                //CommandDoesNotExist
                Ui.printSeparation();
                System.out.println("    OOPS!!! I'm sorry, but I don't know what that means :-(");
                Ui.printSeparation();
            }
        } while (!line.equalsIgnoreCase("bye"));
    }

}
