package duke.command;

import duke.task.Task;
import duke.ui.Ui;

import java.util.ArrayList;

public class ListCommand extends Command {
    public ListCommand(ArrayList<Task> tasks) {
        Ui.printList(tasks);
    }
}
