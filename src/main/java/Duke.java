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
        repeatCommand();
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

    public static void repeatCommand(){
        String line;
        Scanner in = new Scanner(System.in);
        line = in.nextLine();

        while (line.equals("bye") == false) {
            System.out.println("    ____________________________________________________________");
            System.out.println("    " + line);
            System.out.println("    ____________________________________________________________");
            line = in.nextLine();
        }

        bye();
    }
}
