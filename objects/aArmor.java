package objects;

public class aArmor extends Item {

    protected int strRequirement;
    protected int damageReduction;

    public aArmor() {
    }

    public aArmor(String name) {
        super(name);
    }

    public aArmor(String name, String description) {
        super(name, description);
    }

    public aArmor(String name, String description, double weight) {
        super(name, description, weight);
    }
}
