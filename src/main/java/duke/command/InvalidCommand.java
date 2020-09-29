package duke.command;

import duke.ui.Ui;

public class InvalidCommand extends Command {
    public InvalidCommand() {
        Ui.printSeparation();
        Ui.printCommandNotExistMessage();
        Ui.printSeparation();
    }
}
