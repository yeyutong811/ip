package duke.command;

import duke.tasklist.TaskList;

public class AddDeadlineCommand extends Command {

    /**
     * Adds a deadline task to the TaskList.
     *
     * @param line input by user
     */
    public AddDeadlineCommand(String line) {
        TaskList.addDeadline(line);
    }
}
