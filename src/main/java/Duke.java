import java.util.Scanner;
import java.util.Arrays;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        greet();
        receiveCommand();
    }

    public static void greet(){
        System.out.println("    ____________________________________________________________");
        System.out.println("    Hello! I'm Duke");
        System.out.println("    What can I do for you?");
        System.out.println("    ____________________________________________________________");
    }

    public static void bye(){
        System.out.println("    ____________________________________________________________");
        System.out.println("    Bye. Hope to see you again soon!");
        System.out.println("    ____________________________________________________________");
    }

    public static void receiveCommand(){
        String line;
        Scanner in = new Scanner(System.in);
        String[] commandStorage = new String[100];
        int commandStorageIndex = 0;

        line = in.nextLine();

        while (line.equals("bye") == false) {
            if (line.equals("list")){
                listCommandHistory(commandStorage, commandStorageIndex);
            }else {
                commandStorage[commandStorageIndex] = line;
                commandStorageIndex++;
                repeatCommand(line);
            }
            line = in.nextLine();
        }

        bye();
    }

    public static void repeatCommand(String line){
        System.out.println("    ____________________________________________________________");
        System.out.println("    " + "added: " + line);
        System.out.println("    ____________________________________________________________");
    }

    public static void listCommandHistory(String[] commandStorage, int commandStorageIndex){
        System.out.println("    ____________________________________________________________");
        for (int i=0; i< commandStorageIndex;i++){
            System.out.format("    %d. %s\n", i+1, commandStorage[i]);
        }
        System.out.println("    ____________________________________________________________");
    }

}
