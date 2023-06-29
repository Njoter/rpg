package objects;

public class LeatherArmor extends aArmor {

    public LeatherArmor() {
        this("Leather armor", "A simple leather armor. It smells like leather.", 4.2);
    }

    public LeatherArmor(String name) {
        this(name, "A simple leather armor. It smells like leather.", 4.2);
    }

    public LeatherArmor(String name, String description) {
        this(name, description, 4.2);
    }

    public LeatherArmor(String name, String description, double weight) {
        super(name, description, weight);
        strRequirement = 12;
        damageReduction = 10;
    }
}
