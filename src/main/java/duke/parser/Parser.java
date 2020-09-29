package duke.parser;

import duke.command.*;

import duke.storage.Storage;
import duke.task.Task;
import duke.tasklist.TaskList;

import java.util.Scanner;

/**
 * Represents a parser that parses input commands by the user.
 * A <code>parser</code> object does not have any values itself.
 */
public class Parser {

    public static final String EXIT_COMMAND = "bye";
    public static final String LIST_COMMAND = "list";
    public static final String DONE_COMMAND = "done";
    public static final String TASK_TYPE_TODO_COMMAND = "todo";
    public static final String TASK_TYPE_DEADLINE_COMMAND = "deadline";
    public static final String TASK_TYPE_EVENT_COMMAND = "event";
    public static final String DELETE_COMMAND = "delete";
    public static final String FIND_COMMAND = "find";
    public static final String HELP_COMMAND = "help";
    private static final int DATA_TASK_TYPE_INDEX = 0;

    /**
     * Returns nothing.
     * Parses and executes the user commands until user input an exit command.
     *
     * @return not applicable.
     */
    public static void receiveCommand() {
        String input;
        Scanner in = new Scanner(System.in);
        Task.numOfTasks = 0;
        Storage.load();

        do {
            input = in.nextLine();
            String[] keywords = input.split(" ",2); //separate command word from other information

            switch(keywords[DATA_TASK_TYPE_INDEX].toLowerCase()) {
            case EXIT_COMMAND:
                new ExitCommand();
                break;
            case LIST_COMMAND:
                new ListCommand(TaskList.tasks);
                break;
            case DONE_COMMAND:
                new CompleteTaskCommand(TaskList.tasks, input);
                break;
            case TASK_TYPE_TODO_COMMAND:
                new AddToDoCommand(input);
                break;
            case TASK_TYPE_DEADLINE_COMMAND:
                new AddDeadlineCommand(input);
                break;
            case TASK_TYPE_EVENT_COMMAND:
                new AddEventCommand(input);
                break;
            case DELETE_COMMAND:
                new DeleteCommand(input);
                break;
            case FIND_COMMAND:
                new FindCommand(input);
                break;
            case HELP_COMMAND:
                new HelpCommand();
                break;
            default:
                new InvalidCommand();
                break;
            }

        } while (!input.equalsIgnoreCase(EXIT_COMMAND));
    }

}