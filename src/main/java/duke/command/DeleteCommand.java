package duke.command;

import duke.tasklist.TaskList;

public class DeleteCommand extends Command {

    /**
     * Deletes the task.
     *
     * @param line input by user.
     */
    public DeleteCommand(String line) {
        TaskList.deleteTask(line);
    }
}
