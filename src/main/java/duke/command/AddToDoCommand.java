package duke.command;

import duke.tasklist.TaskList;

public class AddToDoCommand extends Command {

    /**
     * Adds a todo task to the TaskList.
     *
     * @param line input by user
     */
    public AddToDoCommand(String line) {
        TaskList.addToDo(line);
    }
}
