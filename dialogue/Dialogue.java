package dialogue;

import util.PromptUserForInput;

import java.util.ArrayList;

import static java.lang.System.*;
import static util.MiscUtils.clearScreen;

public class Dialogue {

    private final String npcString;
    private final ArrayList<String> playerString = new ArrayList<>();
    private final ArrayList<Integer> nextDialogue = new ArrayList<>();

    public Dialogue(String npcString) {
        this.npcString = npcString;
    }

    public void add(String pString, int next) {
        this.playerString.add(pString);
        this.nextDialogue.add(next);
    }

    public int printDialogueReturnNext(String npcName) {
        int choice;
        do {
            clearScreen();

            // Print the npc's name, and -'s under the whole name.
            out.println(npcName);
            for (int i = 0; i < npcName.length() + 1; i++) {
                out.print("-");
            }

            // Print the npc's line.
            out.println();
            out.println(npcString);

            // Print -'s over the Player's choices.
            for (int i = 0; i < playerString.get(0).length(); i++) {
                out.print("_");
                if (playerString.get(0).charAt(i) == '\n') {
                    break;
                }
            }
            out.print("___");

            // Print the player's choices.
            out.println();
            for (int i = 0; i < playerString.size(); i++) {
                String newString = playerString.get(i).replace("\n", "\n   ");
                out.println((i+1) + ": " + newString);
                if (i < playerString.size() - 1) {
                    out.println();
                }
            }

            // Prompt user for input, and loop if not valid choice.
            choice = PromptUserForInput.promptForInt();
        } while (choice < 1 || choice > playerString.size());

        // Return int that's used to get to the next dialog window.
        return nextDialogue.get(choice - 1);
    }
}