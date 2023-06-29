package util;

import java.util.*;

import static java.lang.System.in;
import static util.PrintToConsole.printCharactersNumberOfTimes;

public class PromptUserForInput {

    static final Scanner input = new Scanner(in);

    public static int promptForInt() {
        while (!input.hasNextInt())
            input.nextLine();
        return input.nextInt();
    }

    public static String promptForString() {
        return input.next();
    }

    public static void enterToContinue() {
        Scanner input = new Scanner(in);
        String message = "ENTER to continue";
        printCharactersNumberOfTimes('_', message.length());
        System.out.println(message);
        input.nextLine();
    }
}
