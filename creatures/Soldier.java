package creatures;

import objects.Shortsword;
import objects.aWeapon;

public class Soldier extends Actor {

    aWeapon shortsword = new Shortsword();
    public Soldier(String name, String description, String race) {
        super(name, description, race);

        this.setHealthPoints(50);
        this.setMana(50);
        this.setStrength(10);
        this.setDexterity(10);
        this.setConstitution(10);
        this.setIntelligence(10);
        this.setCharisma(10);

        equipWeapon(shortsword);
    }

    @Override
    public void startDialogue() {

    }
}
