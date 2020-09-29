package duke.task;

public abstract class Task {

    //public boolean isDone;
    protected boolean isDone;
    protected String taskType;
    protected String taskName;
    public static int numOfTasks = 0;

    public Task(String description) {
        this.taskName = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "V" : "X"); //return tick or cross
    }

    public void markTaskAsDone() {
        this.isDone = true;
    }
    public abstract String getTaskType();

    public String getTaskName() {
        return taskName;
    }

    public abstract String toString();

    public abstract void printTask();

}