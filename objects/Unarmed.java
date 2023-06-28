package player;

import objects.aWeapon;

public class Unarmed extends aWeapon {

    public Unarmed() {
        this("Unarmed", "Your fist is a decent weapon.", 0);
    }

    public Unarmed(String name, String description, double weight) {
        super(name, description, weight);
        this.strScaling = 'E';
        this.dexScaling = 'E';
        this.damage = 5;
        createWeapon();
    }
}
