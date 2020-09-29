package duke.command;

import duke.task.Task;
import duke.tasklist.TaskList;

import java.util.ArrayList;

public class CompleteTaskCommand extends Command {
    public CompleteTaskCommand(ArrayList<Task> tasks, String line) {
        TaskList.updateTaskStatus(TaskList.tasks, line);
    }
}
