package creatures;

import dialogue.DialogueMenu;
import dialogue.NextDialogue;
import util.MiscUtils;
import util.PrintToConsole;

import java.util.ArrayList;

import static dialogue.NextDialogue.*;
import static java.lang.System.out;
import static util.MiscUtils.clearScreen;

public class BarMaid extends Npc implements INpc {

    public BarMaid(String name, String description, String race) {
        super(name, description, race);
    }

    public void startDialogue() {

        String npcString;
        if (getFirstDialogue()) {
            npcString = "The barmaid raises her head as you approach.\n" +
                        "'Ah! A traveler, I presume? You must be thirsty.'";
        } else {
            npcString = "Hi, there! What can I do for you?";
        }

        String menuString;
        ArrayList<DialogueMenu> dialogueMenu = new ArrayList<>();
        if (getFirstDialogue()) {
            menuString = ("'As a matter of fact, I AM a traveler. How did you know?'");
            dialogueMenu.add(new DialogueMenu(menuString, 1));
            menuString = "'Uhh... yeah. Do you have a beer?'";
            dialogueMenu.add(new DialogueMenu(menuString, 2));
        } else {
            menuString = "'I'll just have a beer.'";
            dialogueMenu.add(new DialogueMenu(menuString, 2));
        }
        menuString = "'Actually, I uhh... have to go.'";
        dialogueMenu.add(new DialogueMenu(menuString, 7));
        clearScreen();
        int nextDialog = getNextDialogue(this.getName(), npcString, dialogueMenu);

        while (true) {
            dialogueMenu.clear();
            clearScreen();
            switch (nextDialog) {
                case 1 -> {
                    npcString = "The barmaid eyes you up and down whith a serious frown.\n" +
                                "'Well, you are quite dirty.'";
                    menuString = "'I am most certainly not! How dare you make such a preposterous claim?";
                    dialogueMenu.add(new DialogueMenu(menuString, 3));
                    menuString = "You look down at you mud caked clothes.\n" +
                                 "   'Yes, I have been riding for days, and my attire has become somewhat... unkempt.\n" +
                                 "   Is there some place I could wash up?'";
                    dialogueMenu.add(new DialogueMenu(menuString, 4));
                    menuString = "'Just give me a beer.'";
                    dialogueMenu.add(new DialogueMenu(menuString, 2));
                    nextDialog = getNextDialogue(this.getName(), npcString, dialogueMenu);
                    setFirstDialogue(false);
                }
                case 2 -> {
                    npcString = "'Yes ofcourse.'\n" +
                                "The barmaid reaches for a glass and fills it with foamy goodness.\n" +
                                "'That'll be eight coppers.'";
                    menuString = "That's pretty expensive. I think I'll pass.";
                    dialogueMenu.add(new DialogueMenu(menuString, 6));
                    menuString = "'That's pretty expensive. Here you go.'\n" +
                                 "   Give her 8 coppers.";
                    dialogueMenu.add(new DialogueMenu(menuString, 6));
                    menuString = "'That's fine.'\n" +
                                 "   Give her 8 copper.";
                    dialogueMenu.add(new DialogueMenu(menuString, 6));
                    nextDialog = getNextDialogue(this.getName(), npcString, dialogueMenu);
                }
                case 3 -> {
                    npcString = "'I'm sorry. I'didn't mean to offend you. Here, have a beer on the house.'";
                    menuString = "'Don't mind if I do.";
                    dialogueMenu.add(new DialogueMenu(menuString, 6));
                    nextDialog = getNextDialogue(this.getName(), npcString, dialogueMenu);
                }
                case 4 -> {
                    npcString = "'You could go to the Bath house.'";
                    menuString = "'Where is that?'";
                    dialogueMenu.add(new DialogueMenu(menuString, 5));
                    menuString = "'Nah, that seems expensive.'";
                    dialogueMenu.add(new DialogueMenu(menuString, 6));
                    nextDialog = getNextDialogue(this.getName(), npcString, dialogueMenu);
                }
                case 5 -> {
                    npcString = "'It's all the way to the east. Over by the stables.'";
                    menuString = "Aight. Thanks!";
                    dialogueMenu.add(new DialogueMenu(menuString, 6));
                    nextDialog = getNextDialogue(this.getName(), npcString, dialogueMenu);
                }
                case 6 -> {
                    npcString = "'So, what else can I do for you?'";
                    menuString = "'Not much. Bye.";
                    dialogueMenu.add(new DialogueMenu(menuString, 7));
                    nextDialog = getNextDialogue(this.getName(), npcString, dialogueMenu);
                }
                case 7 -> {
                    clearScreen();
                    npcString = "'That's too bad.'";
                    PrintToConsole.printDescription(this.getName(), npcString);
                    MiscUtils.enterToContinue();
                    return;
                }
                default -> clearScreen();
            }
        }
    }
}
