package duke.command;

import duke.exception.DukeException;
import duke.tasklist.TaskList;

public class AddDeadlineCommand extends Command {

    /**
     * Adds a deadline task to the TaskList.
     *
     * @param line input by user
     */
    public AddDeadlineCommand(String line) {
        try {
            TaskList.addDeadline(line);
        } catch(DukeException e) {

        }
    }
}
