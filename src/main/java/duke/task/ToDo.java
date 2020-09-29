package duke.task;

/**
 * Represents a ToDo Task. A <code>ToDo</code> object corresponds to
 * 2 string variables e.g., <code>T, read book</code>
 */
public class ToDo extends Task {

    public ToDo(String taskName) {
        super(taskName);
    }

    /**
     * Return task type icon of ToDo.
     *
     * @return task type.
     * */
    @Override
    public String getTaskType() {
        return "T";
    }

    /**
     * Returns task data in the desired form to be recorded in the file "data.txt".
     *
     * @return task data.
     * */
    @Override
    public String toString() {
        return getTaskType() + " | " + (this.isDone ? "1 | ": "0 | ") + this.taskName;
    }

    /**
     * Prints task data in the desired form to be printed for user interaction.
     * */
    @Override
    public void printTask() {
        System.out.format("[%s][%s] %s%n", this.getTaskType(), this.getStatusIcon(), this.taskName);
    }

}