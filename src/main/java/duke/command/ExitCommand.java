package duke.command;

import duke.ui.Ui;

public class ExitCommand extends Command {

    public ExitCommand() {

        Ui.printBye();
    }

}
