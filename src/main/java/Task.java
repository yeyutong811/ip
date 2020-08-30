public class Task {
    protected String description;
    protected boolean isDone;
    public static int numOfTasks = 0;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "V" : "X"); //return tick or cross
    }

    public void markTaskAsDone() {
        this.isDone = true;
    }
}