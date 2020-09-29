package duke.command;

import duke.ui.Ui;

public class ExitCommand extends Command {

    /**
     * Prints exit messages.
     */
    public ExitCommand() {

        Ui.printBye();
    }

}
