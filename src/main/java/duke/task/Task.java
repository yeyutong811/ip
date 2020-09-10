package duke.task;

public class Task {

    protected String taskType;
    protected String taskName;
    protected String taskTime;
    protected boolean isDone;
    public static int numOfTasks = 0;

    public Task(String description) {
        this.taskName = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "V" : "X"); //return tick or cross
    }

    public String getTaskType() {
        return taskType;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskTime() {
        return taskTime;
    }

    public void markTaskAsDone() {
        this.isDone = true;
    }

}