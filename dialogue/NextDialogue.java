package dialogue;

import util.PrintToConsole;
import util.PromptUserForInput;

import java.util.ArrayList;

import static java.lang.System.out;
import static util.MiscUtils.clearScreen;

public class NextDialogue {

    public static int getNextDialogue(String name, String npcString, ArrayList<DialogueMenu> dialogueMenu) {
        while (true) {
            PrintToConsole.printDescription(name, npcString);
            PrintToConsole.printDialogueMenu(dialogueMenu);
            int choice = PromptUserForInput.promptUserForInt();
            if (choice > 0 && choice <= dialogueMenu.size()) {
                return dialogueMenu.get(choice-1).getNextDialogue();
            }
        }
    }
}
