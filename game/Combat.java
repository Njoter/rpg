package game;

import creatures.Actor;
import util.MiscUtils;
import util.PromptUserForInput;

public class Combat {

    public static void enterCombat(Actor enemy) {
        int choice;

        while (Game.player.getHealthPoints() > 0 && enemy.getHealthPoints() > 0) {
            choice = 0;
            do {
                MiscUtils.clearScreen();
                System.out.println("""
                You are fighting a soldier. He's a real piece of shit, really.""");
                System.out.println("1: Attack with " + Game.player.getMainWeapon());
                choice = PromptUserForInput.promptForInt();
                if (choice == 1) {
                    playerAttackEnemy(enemy);
                }
            } while(choice != 1);
            enemyAttackPlayer(enemy);
        }
    }

    private static void playerAttackEnemy(Actor enemy) {
        MiscUtils.clearScreen();
        System.out.println("You attack " + enemy.getName() + " for " + Game.player.getDamage() + " damage.");
        int enemyHealth = enemy.getHealthPoints();
        enemy.setHealthPoints(enemyHealth - Game.player.getDamage());
        System.out.println(enemy.getName() + "'s current health points are " + enemy.getHealthPoints() + ".");
        PromptUserForInput.enterToContinue();
    }

    private static void enemyAttackPlayer(Actor enemy) {
        System.out.println(enemy.getName() + " attacks you for " + enemy.getDamage() + " damage.");
        int playerHealth = Game.player.getHealthPoints();
        Game.player.setHealthPoints(playerHealth - enemy.getDamage());
        System.out.println(Game.player.getName() + "'s current health points are " + Game.player.getHealthPoints() + ".");
        PromptUserForInput.enterToContinue();
    }
}
