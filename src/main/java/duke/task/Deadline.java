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
    public String getTaskTime() {
        return deadline;
    }
}