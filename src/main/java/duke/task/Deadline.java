package duke.task;

public class Deadline extends Task {

    protected String deadline;

    public Deadline(String taskName, String taskTime) {
        super(taskName);
        deadline = taskTime;
    }

    @Override
    public String getTaskType() {
        return "D";
    }

    @Override
    public String toString() {
        return getTaskType() + " | " + (this.isDone ? "1 | ": "0 | ") + this.taskName + " | " + this.deadline;
    }

    @Override
    public void printTask() {
        System.out.format("[%s][%s] %s (at: %s)%n", this.getTaskType(), this.getStatusIcon(), this.taskName, this.deadline);
    }
}