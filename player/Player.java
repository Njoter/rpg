package player;

public class Player {
    private static String name;
    private static int healthPoints = 100;

    public static void setName(String playerSetName) {
        name = playerSetName;
    }

    public static String getName() {
        return name;
    }

    public static int getHealthPoints() {
        return healthPoints;
    }
}
