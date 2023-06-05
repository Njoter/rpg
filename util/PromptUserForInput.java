package util;

import java.util.Scanner;
import static java.lang.System.in;

public class PromptUserForInput {

    public static int promptUserForInt() {
        Scanner input = new Scanner(in);
        while (!input.hasNextInt())
            input.nextLine();
        return input.nextInt();
    }
}
