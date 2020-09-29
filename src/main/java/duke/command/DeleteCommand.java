package duke.command;

import duke.tasklist.TaskList;

public class DeleteCommand extends Command {
    public DeleteCommand(String line) {
        TaskList.deleteTask(line);
    }
}
