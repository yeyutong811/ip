package duke.parser;

import duke.storage.Storage;
import duke.task.Task;
import duke.tasklist.TaskList;
import duke.ui.Ui;

import java.util.Scanner;

public class Parser {

    public static void receiveCommand() {
        String input;
        Scanner in = new Scanner(System.in);
        Task.numOfTasks = 0;
        Storage.load();

        do {
            input = in.nextLine();
            String[] keywords = input.split(" ",2);

            switch(keywords[0].toLowerCase()) {
            case "bye":
                Ui.printBye();
                break;
            case "list":
                Ui.printList(TaskList.tasks);
                break;
            case "done":
                TaskList.updateTaskStatus(TaskList.tasks, input);
                break;
            case "todo":
                TaskList.addToDo(input);
                break;
            case "deadline":
                TaskList.addDeadline(input);
                break;
            case "event":
                TaskList.addEvent(input);
                break;
            case "delete":
                TaskList.deleteTask(input);
                break;
            case "find":
                TaskList.findList(input);
                break;
            default:
                //CommandDoesNotExist
                Ui.printSeparation();
                Ui.printCommandNotExistMessage();
                Ui.printSeparation();
            }

        } while (!input.equalsIgnoreCase("bye"));
    }

}
