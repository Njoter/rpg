package util;

import abstractlocation.aLocation;

import java.util.*;

import static java.lang.System.in;

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

    public static int getHashKey(HashMap<Integer, aLocation> locationMap) {
        int playerInput = promptForInt();
        if (playerInput == 0) {
            return 0;
        }
        int i = 1;
        int hashKey = -1;
        for (Integer key : locationMap.keySet()) {
            if (i == playerInput) {
                hashKey = key;
                break;
            }
            i++;
        }
        return hashKey;
    }
}
