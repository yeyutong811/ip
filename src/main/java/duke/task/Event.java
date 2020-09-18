package duke.task;

public class Event extends Task {

    protected String time;

    public Event(String taskName, String taskTime) {
        super(taskName);
        time = taskTime;
        this.taskType = "E";
    }

    @Override
    public String getTaskType() {
        return "E";
    }

    @Override
    public String toString() {
        return this.getTaskType() + " | " + (this.isDone ? "1 | ": "0 | ") + this.taskName + " | " + this.time;
    }

    @Override
    public void printTask() {
        System.out.format("[%s][%s] %s (at: %s)%n", this.getTaskType(), this.getStatusIcon(), this.taskName, this.time);
    }
}