package duke.task;

public class ToDo extends Task {

    public ToDo(String taskName) {
        super(taskName);
    }

    @Override
    public String getTaskType() {
        return "T";
    }

    @Override
    public String toString() {
        return getTaskType() + " | " + (this.isDone ? "1 | ": "0 | ") + this.taskName;
    }

    @Override
    public void printTask() {
        System.out.format("[%s][%s] %s%n", this.getTaskType(), this.getStatusIcon(), this.taskName);
    }

}