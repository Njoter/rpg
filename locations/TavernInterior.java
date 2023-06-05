package locations;

import building.aBuildingInterior;
import creatures.BarMaid;
import creatures.Npc;
import room.Room;
import util.PrintToConsole;
import util.PromptUserForInput;

import static util.MiscUtils.*;

public class TavernInterior extends aBuildingInterior {

    private Room[] room;
    private BarMaid barmaid;

    public TavernInterior(String name) {
        super(name);
        createRooms();
        createNpcs();
    }

    @Override
    public void enterBuilding() {
        setFirstTimeEntered(false);
        this.setExit(false);
        room[0].setPlayerIsHere(true);
        while (!this.isExit()) {
            if (room[0].getPlayerIsHere())
                goToMainHall();
            else if (room[1].getPlayerIsHere())
                goToLavatory();
            else if (room[2].getPlayerIsHere())
                goUpstairs();
        }
    }

    @Override
    protected void createRooms() {
        room = new Room[3];

        String mainHallDescription = "This is the main hall. There are only a few people in here, all drinking beer.\n" +
                "A woman is standing behind the bar, pouring drinks. A set of stairs are\n" +
                "leading up to a second floor, and a door leads to another room to the left\n" +
                "of the bar.";
        room[0] = new Room("Main hall", mainHallDescription);
        String lavatoryDescription = "This is the lavatory. It's just a hole in the floor.\n" +
                "The smell is terrible.";
        room[1] = new Room("Lavatory", lavatoryDescription);
        String upstairsDescription = "You are standing in a long, narrow hallway. Three doors are located on\n" +
                "either of the two long walls. All the doors are locked.";
        room[2] = new Room("Upstairs", upstairsDescription);

        this.setFirstTimeEntered(false);
    }

    @Override
    protected void createNpcs() {
        String barMaidDescription = "An elf lady with long, braided hair. She is pouring beer.";
        barmaid = new BarMaid("Barmaid", barMaidDescription, "Elf");
    }

    private void goToMainHall() {
        int choice;
        clearScreen();
        PrintToConsole.printDescription(room[0].getName(), room[0].getDescription());
        while (true) {
            String[] choiceMenu = {"Go through the door on the left.", "Go up the stairs.", "Approach the barmaid",
                                   "Exit the tavern."};
            PrintToConsole.printChoiceMenu(choiceMenu);
            choice = PromptUserForInput.promptUserForInt();
            if (choice == 1) {
                room[0].setPlayerIsHere(false);
                room[1].setPlayerIsHere(true);
                return;
            } else if (choice == 2) {
                room[0].setPlayerIsHere(false);
                room[2].setPlayerIsHere(true);
                return;
            } else if (choice == 3) {
                barmaid.startDialogue();
                return;
            } else if (choice == 0) {
                this.setExit(true);
                return;
            } else {
                clearScreen();
                System.out.println("That's not a valid choice.");
            }
        }
    }

    private void goToLavatory() {
        int choice;
        clearScreen();
        PrintToConsole.printDescription(room[1].getName(), room[1].getDescription());
        while (true) {
            String[] choiceMenu = {"Use the lavatory.", "Exit the lavatory."};
            PrintToConsole.printChoiceMenu(choiceMenu);
            choice = PromptUserForInput.promptUserForInt();
            if (choice == 1) {
                clearScreen();
                System.out.println("You don't really need to. Maybe after a beer.");
            } else if (choice == 0) {
                room[1].setPlayerIsHere(false);
                room[0].setPlayerIsHere(true);
                return;
            } else {
                clearScreen();
                System.out.println("That's not a valid choice.");
            }
        }
    }

    private void goUpstairs() {
        int choice;
        clearScreen();
        PrintToConsole.printDescription(room[2].getName(), room[2].getDescription());
        while (true) {
            String[] choiceMenu = {"Knock on all the doors.", "Go back down."};
            PrintToConsole.printChoiceMenu(choiceMenu);
            choice = PromptUserForInput.promptUserForInt();
            if (choice == 1) {
                clearScreen();
                System.out.println("No one is answering.");
            } else if (choice == 0) {
                room[2].setPlayerIsHere(false);
                room[0].setPlayerIsHere(true);
                return;
            } else {
                clearScreen();
                System.out.println("That's not a valid choice.");
            }
        }
    }
}
