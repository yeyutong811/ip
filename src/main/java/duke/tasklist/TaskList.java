package duke.tasklist;

import duke.exception.DukeException;
import duke.storage.Storage;
import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.ToDo;
import duke.ui.Ui;

import java.io.IOException;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Represents the list of existing tasks.
 */
public class TaskList {
    private static final int LENGTH_OF_TYPE_TO_DO = 4;
    private static final int DATA_TASK_STATUS_INDEX = 1;
    private static final int DATA_TASK_NAME_INDEX = 2;
    private static final int DATA_TASK_TIME_INDEX = 3;

    public static ArrayList<Task> tasks = new ArrayList<>();
    private Storage storage;

    public TaskList(Storage input) {
        tasks = new ArrayList<>();
        storage = input;
    }

    /**
     * Updates task status to completed.
     *
     * @param tasks list of tasks.
     * @param line user input.
     */
    public static void completeTask(ArrayList<Task> tasks, String line) {
        try {
            line = line.trim();
            int startOfTaskIndex = line.indexOf(' ') + 1;
            int taskIndex = Integer.parseInt(line.substring(startOfTaskIndex)) - 1;
            Task task = tasks.get(taskIndex);
            task.markTaskAsDone();
            Storage.writeToFile();
            Ui.printSeparation();
            Ui.printMarkTaskDoneMessage();
            System.out.format("    ");
            tasks.get(taskIndex).printTask();
            Ui.printSeparation();
        } catch (NullPointerException | IndexOutOfBoundsException e) {
            Ui.printTaskNotExistMessage();
        }
    }

    /**
     * Add ToDo object to the list of tasks.
     *
     * @param line user input.
     */
    public static void addToDo(String line) throws DukeException {
        try {

            String taskName = line.substring(LENGTH_OF_TYPE_TO_DO + 1);
            ToDo t = new ToDo(taskName);

            addTaskToList(t);
        } catch (StringIndexOutOfBoundsException | IOException e) {
            throwException("todo");
        }
    }

    /**
     * Add Deadline object to the list of tasks.
     *
     * @param line user input.
     */
    public static void addDeadline(String line) throws DukeException {
        try {

            String[] taskContent = line.split("/by ", 2);

            Deadline d = new Deadline(taskContent[0], taskContent[1]);

            addTaskToList(d);
        } catch (StringIndexOutOfBoundsException | ArrayIndexOutOfBoundsException | IOException e) {
            throwException("deadline");
        } catch (DateTimeParseException e) {
            throwException("dateError");
        }
    }

    /**
     * Add Event object to the list of tasks.
     *
     * @param line user input.
     */
    public static void addEvent(String line) throws DukeException {
        try {
            String[] taskContent = line.split("/at ", 2);

            Event e = new Event(taskContent[0], taskContent[1]);

            addTaskToList(e);
        } catch (StringIndexOutOfBoundsException | ArrayIndexOutOfBoundsException | IOException e) {
            throwException("event");
        } catch (DateTimeParseException e) {
            throwException("dateError");
        }
    }

    /**
     * Throws DukeException.
     *
     * @param command command word to decide which message under DukeException is to be called.
     * @throws DukeException at all times.
     */
    public static void throwException(String command) throws DukeException {
        throw new DukeException(command);
    }

    /**
     * Add ToDo object to the list of tasks.
     *
     * @param t Task object to be added.
     * @throws IOException if any in/output error occurs.
     */
    public static void addTaskToList(Task t) throws IOException {
        tasks.add(t);
        Storage.appendToFile(t);
        Task.numOfTasks++;
        Ui.printTaskAddedMessage(t);
    }

    /**
     * Delete object from the list of tasks, based on task index.
     *
     * @param line user input.
     */
    public static void deleteTask(String line) {
        try {
            line = line.trim();
            int startOfTaskIndex = line.indexOf(' ') + 1;
            int taskIndex = Integer.parseInt(line.substring(startOfTaskIndex)) - 1;


            Ui.printSeparation();

            Ui.printRemovingTaskMessage();
            System.out.format("    ");
            tasks.get(taskIndex).printTask();;
            tasks.remove(taskIndex);
            Storage.writeToFile();

            Task.numOfTasks--;
            Ui.printTaskRemovedMessage();
            Ui.printSeparation();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("");
            Ui.printTaskNotExistMessage();
        }
    }

    public static void findList(String command) {
        String keyword = command.substring(5);
        ArrayList<Task> foundTasks = find(keyword);
        Ui.printFindList(foundTasks);
    }

    public static ArrayList<Task> find(String keyword) {
        return (ArrayList<Task>) tasks.stream()
                .filter(t -> t.getTaskName().toLowerCase().contains(keyword))
                .collect(Collectors.toList());
    }

    /**
     * Creates ToDo task from reading the data in the file "data.txt"
     *
     * @param todoArgs line of data presenting a ToDo object
     * @return ToDo object created
     */
    public static Task createToDoTask(ArrayList<String> todoArgs) {
        String taskStatus = todoArgs.get(DATA_TASK_STATUS_INDEX);
        String taskName = todoArgs.get(DATA_TASK_NAME_INDEX);

        Task todo;
        if (taskStatus.equals("1")) {
            todo = new ToDo(taskName);
            todo.markTaskAsDone();
        } else {
            todo = new ToDo(taskName);
        }
        return todo;
    }

    /**
     * Creates Deadline task from reading the data in the file "data.txt"
     *
     * @param deadlineArgs line of data presenting a Deadline object
     * @return Deadline object created
     */
    public static Task createDeadlineTask(ArrayList<String> deadlineArgs) {
        String taskStatus = deadlineArgs.get(DATA_TASK_STATUS_INDEX);
        String taskName = deadlineArgs.get(DATA_TASK_NAME_INDEX);
        String taskTime = deadlineArgs.get(DATA_TASK_TIME_INDEX);

        Task deadline;
        if (taskStatus.equals("1")) {
            deadline = new Deadline(taskName, taskTime);
            deadline.markTaskAsDone();
        } else {
            deadline = new Deadline(taskName, taskTime);
        }
        return deadline;
    }

    /**
     * Creates Event task from reading the data in the file "data.txt"
     *
     * @param eventArgs line of data presenting a Event object
     * @return Event object created
     */
    public static Task createEventTask(ArrayList<String> eventArgs) {
        String taskStatus = eventArgs.get(DATA_TASK_STATUS_INDEX);
        String taskName = eventArgs.get(DATA_TASK_NAME_INDEX);
        String taskTime = eventArgs.get(DATA_TASK_TIME_INDEX);

        Task event;
        if (taskStatus.equals("1")) {
            event = new Event(taskName, taskTime);
            event.markTaskAsDone();
        } else {
            event = new Event(taskName, taskTime);
        }
        return event;
    }
}
