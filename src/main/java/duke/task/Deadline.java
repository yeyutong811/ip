package duke.task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Represents a Event Task. A <code>Event</code> object corresponds to
 * 3 string variables e.g., <code>D, read book, 9am</code>
 */
public class Deadline extends Task {

    protected String deadline;

    public Deadline(String taskName, String taskTime) {
        super(taskName);
        deadline = taskTime;
        this.taskType = "D";
        this.setDate(LocalDate.parse(taskTime));
    }

    /**
     * Returns task type icon of Deadline.
     *
     * @return task type.
     * */
    @Override
    public String getTaskType() {

        return this.taskType;
    }

    /**
     * Returns task data in the desired form to be recorded in the file "data.txt".
     *
     * @return task data.
     * */
    @Override
    public String toString() {

        return getTaskType() + " | " + (this.isDone ? "1 | ": "0 | ") + this.taskName + " | " + this.deadline;
    }

    /**
     * Prints task data in the desired form to be printed for user interaction.
     * */
    @Override
    public void printTask() {
        System.out.format("[%s][%s] %s (by: %s)%n", this.getTaskType(), this.getStatusIcon(), this.taskName,
                this.date.format(DateTimeFormatter.ofPattern("MMM d yyyy")));
    }
}