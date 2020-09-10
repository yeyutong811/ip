package duke.task;

public class Event extends Task {

    protected String time;

    public Event(String taskName, String taskTime) {
        super(taskName);
        time = taskTime;
    }

    @Override
    public String getTaskType() {
        return "E";
    }

    @Override
    public String getTaskTime() {
        return time;
    }

}