package duke.command;

import duke.task.Task;
import duke.tasklist.TaskList;

import java.util.ArrayList;

public class CompleteTaskCommand extends Command {

    /**
     * Updates the task status as completed.
     *
     * @param tasks ArrayList of Task objects.
     * @param line input by user.
     */
    public CompleteTaskCommand(ArrayList<Task> tasks, String line) {
        TaskList.completeTask(TaskList.tasks, line);
    }
}
