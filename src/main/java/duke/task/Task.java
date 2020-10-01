package duke.task;

import java.time.LocalDate;

/**
 * Represents a Task.
 * A <code>Task</code> object can be of types ToDo, Deadline, or Event.
 */
public abstract class Task {

    protected boolean isDone;
    protected String taskType;
    protected String taskName;
    public static int numOfTasks = 0;
    protected LocalDate date;

    public Task(String description) {
        this.taskName = description;
        this.isDone = false;
    }

    /**
     * Returns the status icon indicating whether task is completed.
     * If the task is completed, return "V", else return "X".
     *
     * @return status icon.
     */
    public String getStatusIcon() {

        return (isDone ? "V" : "X"); //return tick or cross
    }

    /**
     * Marks the task status as completed.
     */
    public void markTaskAsDone() {

        this.isDone = true;
    }

    /**
     * Sets the task date.
     *
     * @param date task date.
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public abstract String getTaskType();

    /**
     * Gets the task name.
     * @return task name.
     */
    public String getTaskName() {

        return taskName;
    }

    public abstract String toString();

    public abstract void printTask();

}