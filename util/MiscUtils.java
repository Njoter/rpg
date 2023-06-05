package util;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.Thread.*;

public class MiscUtils {

    public static void wait(int ms) {
        try {
            sleep(ms);
        } catch(InterruptedException ie) {
            currentThread().interrupt();
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void enterToContinue() {
        Scanner input = new Scanner(in);
        System.out.println("------------------");
        System.out.println("ENTER to continue.");
        input.nextLine();
    }
}
