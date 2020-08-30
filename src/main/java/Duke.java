import java.util.Scanner;
import java.util.Arrays;

public class Duke {
    public static void main(String[] args) {
        printWelcomeMessage();
        printGreet();
        receiveCommand();
    }

    private static void printWelcomeMessage() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
    }

    public static void printGreet(){
        System.out.println("    ____________________________________________________________");
        System.out.println("    Hello! I'm Duke");
        System.out.println("    What can I do for you?");
        System.out.println("    ____________________________________________________________");
    }

    public static void printBye(){
        System.out.println("    ____________________________________________________________");
        System.out.println("    Bye. Hope to see you again soon!");
        System.out.println("    ____________________________________________________________");
    }

    public static void receiveCommand(){
        String line;
        Scanner in = new Scanner(System.in);
        Task[] commandStorage = new Task[100];

        do {
            line = in.nextLine();
            if (line.equalsIgnoreCase("bye")){
                printBye();
                break;
            }else if (line.equalsIgnoreCase("list")){
                printList(commandStorage);
            }else if (line.contains("done")){
                updateTaskStatus(commandStorage, line);
            }else{
                commandStorage[Task.numOfTasks] = addTaskToList(line);
            }
        } while (line.equalsIgnoreCase("bye") == false);
    }

    public static Task addTaskToList(String line) {
        Task t = new Task(line);
        System.out.println("    ____________________________________________________________");
        System.out.println("    " + "added: " + line);
        System.out.println("    ____________________________________________________________");
        Task.numOfTasks++;
        return t;
    }

    public static void printList(Task[] commandStorage){
        System.out.println("    ____________________________________________________________");
        if (Task.numOfTasks==0){
            System.out.println("    The list is empty!");
        }else {
            System.out.println("Here is the list of your tasks: ");
            for (int i = 0; i < Task.numOfTasks; i++) {
                int index = i+1;
                System.out.println("    " + index + ". " + "[" + commandStorage[i].getStatusIcon() + "] " + commandStorage[i].description);
            }
        }
        System.out.println("    ____________________________________________________________");
    }

    public static void updateTaskStatus(Task[] commandStorage, String line){
        line = line.trim();
        int startOfTaskIndex = line.indexOf(' ') + 1;
        int commandLength = line.length();
        int taskIndex = Integer.parseInt(line.substring(startOfTaskIndex, commandLength)) - 1;
        commandStorage[taskIndex].markTaskAsDone();

        System.out.println("    ____________________________________________________________");
        System.out.println("Nice! I've marked this task as done: ");
        System.out.println("    [" + commandStorage[taskIndex].getStatusIcon() + "] " + commandStorage[taskIndex].description);
        System.out.println("    ____________________________________________________________");

    }

}
