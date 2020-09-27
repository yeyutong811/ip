package duke;

import duke.parser.Parser;
import duke.storage.Storage;
import duke.task.Task;
import duke.tasklist.TaskList;
import duke.ui.Ui;

import java.io.*;
import java.util.ArrayList;

public class Duke {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        tasks = new TaskList(storage);
    }

    public void run() {
        Ui.printGreet();
        Parser.receiveCommand();
    }

    public static void main(String[] args) {
        new Duke("D:\\CS2113T\\ip\\data\\data.txt").run();
    }

}
