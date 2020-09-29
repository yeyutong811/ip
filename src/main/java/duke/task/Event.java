package duke.task;

/**
 * Represents a Event Task. A <code>Event</code> object corresponds to
 * 3 string variables e.g., <code>E, read book, 9-11am</code>
 */
public class Event extends Task {

    protected String time;

    public Event(String taskName, String taskTime) {
        super(taskName);
        time = taskTime;
        this.taskType = "E";
    }

    /**
     * Returns task type icon of Event.
     *
     * @return task type.
     * */
    @Override
    public String getTaskType() {
        return "E";
    }

    /**
     * Returns task data in the desired form to be recorded in the file "data.txt".
     *
     * @return task data.
     * */
    @Override
    public String toString() {
        return this.getTaskType() + " | " + (this.isDone ? "1 | ": "0 | ") + this.taskName + " | " + this.time;
    }

    /**
     * Prints task data in the desired form to be printed for user interaction.
     * */
    @Override
    public void printTask() {
        System.out.format("[%s][%s] %s (at: %s)%n", this.getTaskType(), this.getStatusIcon(), this.taskName, this.time);
    }
}