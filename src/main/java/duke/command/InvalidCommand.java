package duke.command;

import duke.exception.DukeException;

public class InvalidCommand extends Command {
    public static final String INVALID_COMMAND = "invalid";
    /**
     * Prints invalid input messages.
     */
    public InvalidCommand() throws DukeException {
        throw new DukeException(INVALID_COMMAND);
    }
}
