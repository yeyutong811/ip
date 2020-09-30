package duke.exception;

import duke.ui.Ui;

/**
 * Represents exceptions unique to Duke.
 */
public class DukeException extends Exception {
    protected String command;

    public DukeException(String command) {
        this.command = command;
        selectDukeException();
    }

    /**
     * Prints the messages to show that the command the user entered is invalid.
     */
    public void invalidCommandError() {
        Ui.printSeparation();
        System.out.println("    OOPS!!! I'm sorry, but I don't know what that means :-(");
        Ui.printSeparation();
    }

    /**
     * Prints the messages to show that the user missed out task description when adding todo.
     * @param taskType name of task type.
     */
    public static void missingToDoArgsMessage(String taskType) {
        Ui.printSeparation();
        System.out.println("    OOPS!!! The description of a " + taskType + " cannot be empty.");
        Ui.printSeparation();
    }

    /**
     * Prints the messages to show that the user missed out task description or time when adding deadline or event.
     * @param taskType name of task type.
     */
    public static void missingDeadlineEventArgsMessage(String taskType) {
        Ui.printSeparation();
        System.out.println("    OOPS!!! Both the description and time of a" + ((taskType=="event")?"n ":" ")+ taskType
                + " cannot be empty.");
        Ui.printSeparation();
    }

    /**
     * Selects the error message to print.
     */
    public void selectDukeException() {
        if (command.equals("todo")) {
            missingToDoArgsMessage(command);
        } else if (command.equals("event") || command.equals("deadline")) {
            missingDeadlineEventArgsMessage(command);
        } else if (!command.contains("todo") && !command.contains("deadline") && !command.contains("event")) {
            invalidCommandError();
        }
    }

}