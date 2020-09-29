package duke.command;

import duke.ui.Ui;

public class HelpCommand extends Command {
    /**
     * Prints help messages.
     */
    public HelpCommand() {

        Ui.printHelpMessage();
    }
}
