package duke.command;

import duke.tasklist.TaskList;

public class AddEventCommand extends Command {

    /**
     * Adds an event task to the TaskList.
     *
     * @param line input by user
     */
    public AddEventCommand (String line) {
        TaskList.addEvent(line);
    }
}
