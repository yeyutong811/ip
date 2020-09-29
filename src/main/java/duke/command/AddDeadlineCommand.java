package duke.command;

import duke.tasklist.TaskList;

public class AddDeadlineCommand extends Command {
    public AddDeadlineCommand(String line) {
        TaskList.addDeadline(line);
    }
}
