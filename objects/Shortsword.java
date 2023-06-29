package objects;

public class Shortsword extends aWeapon {

    public Shortsword() {
        this("Shortsword", "Just a regular shortsword. Nothing special, really.", 0.9);
    }

    public Shortsword(String name) {
        this(name, "Just a regular shortsword. Nothing special, really.", 0.9);
    }

    public Shortsword(String name, String description) {
        this(name, description, 0.9);
    }

    public Shortsword(String name, String description, double weight) {
        super(name, description, weight);
        this.strScaling = 'C';
        this.dexScaling = 'C';
        this.damage = 22;
    }
}
