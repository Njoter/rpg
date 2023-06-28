package objects;

public class ShortSword extends aWeapon {

    public ShortSword() {
        this.name = "Shortsword";
        this.setDescription("Just a regular shortsword. Nothing special, really.");
        this.setWeight(0.9);
        this.strScaling = 'C';
        this.dexScaling = 'C';
        this.damage = 32;
        this.createWeapon();
    }

    @Override
    public void equipWeapon() {
        super.equipWeapon();
    }
}
