package duke.command;

import duke.ui.Ui;

public class InvalidCommand extends Command {

    /**
     * Prints invalid input messages.
     */
    public InvalidCommand() {
        Ui.printCommandNotExistMessage();
    }
}
