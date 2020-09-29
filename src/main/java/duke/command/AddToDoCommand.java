package duke.command;

import duke.tasklist.TaskList;

public class AddToDoCommand extends Command {
    public AddToDoCommand(String line) {
        TaskList.addToDo(line);
    }
}
