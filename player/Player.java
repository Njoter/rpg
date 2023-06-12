package player;

import util.MiscUtils;
import util.PrintToConsole;

public class Player implements java.io.Serializable {
    private static String name;
    private static int healthPoints;
    private static int mana = 18;
    private static int coppers;
    private static int strength = 12;
    private static int endurance = 9;
    private static int dexterity = 11;
    private static int intelligence = 13;
    private static int charisma = 14;

    public Player(String name, int healthPoints, int coppers) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.coppers = coppers;
    }

    public String getName() {
        return name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getCoppers() {
        return this.coppers;
    }

    public void setCoppers(int coppers) {
        this.coppers += coppers;
    }

    public static void printCharacter() {
        MiscUtils.clearScreen();
        System.out.println("name = " + name + "\n" +
                "HP = " + healthPoints + "\n" +
                "Mana = " + mana + "\n" +
                "Coppers = " + coppers + "\n" +
                "Strength = " + strength + "\n" +
                "Endurance = " + endurance + "\n" +
                "Dexterity = " + dexterity + "\n" +
                "Intelligence = " + intelligence + "\n" +
                "Charisma = " + charisma);
        PrintToConsole.enterToContinue("ENTER to continue");
    }
}
