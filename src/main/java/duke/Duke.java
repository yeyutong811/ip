package duke;

import duke.parser.Parser;
import duke.storage.Storage;
import duke.tasklist.TaskList;
import duke.ui.Ui;

/**
 * Represents Duke program.
 */
public class Duke {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    /**
     * Instantiates an instance of Duke.
     *
     * @param filePath file path of stored data.
     */
    public Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        tasks = new TaskList(storage);
    }

    /**
     * Runs the program.
     */
    public void run() {
        Ui.printGreet();
        Parser.receiveCommand();
    }

    /**
     * Runs Duke.
     */
    public static void main(String[] args) {
        new Duke("D:\\CS2113T\\ip\\data\\data.txt").run();
    }

}
