package duke.command;

import duke.task.Task;
import duke.ui.Ui;

import java.util.ArrayList;

public class ListCommand extends Command {
    /**
     * Prints the list of existing tasks.
     *
     * @param tasks ArrayList of Task objects.
     */
    public ListCommand(ArrayList<Task> tasks) {
        Ui.printList(tasks);
    }
}
