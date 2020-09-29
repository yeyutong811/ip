package duke.command;

import duke.tasklist.TaskList;

public class AddEventCommand extends Command {
    public AddEventCommand (String line) {
        TaskList.addEvent(line);
    }
}
