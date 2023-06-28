package objects;

import player.Player;

public class Weapon extends Item {

    private String stat;
    private Character scalingTier;
    private double scalingMultiplier;
    private int scalingValue;
    private int damage;



    public void equipWeapon() {
        switch (stat) {
            case "str" -> {
                scalingMultiplier = (Player.getStrength() / 100) * scalingMultiplier;
                Player.setStrength(scalingMultiplier);
            }
        }
    }

    private void createWeapon() {
        switch (scalingTier) {
            case 'S' -> scalingMultiplier = 1.15;
            case 'A' -> scalingMultiplier = 1.08;
            case 'B' -> scalingMultiplier = 1.06;
            case 'C' -> scalingMultiplier = 1.05;
            case 'D' -> scalingMultiplier = 1.025;
            case 'E' -> scalingMultiplier = 1.01;
        }
    }
}
