package creatures;

import dialogue.Dialogue;
import objects.aWeapon;

public class Npc implements java.io.Serializable {
    private String name;
    private String description;
    private String race;
    private int healthPoints;
    private int mana;
    private int damage;
    private int coppers;
    private int strength;
    private int constitution;
    private int dexterity;
    private int intelligence;
    private int charisma;
    private Boolean firstDialogue = true;
    private Dialogue dialogue;

    public Npc(String name, String description, String race) {
        this.name = name;
        this.description = description;
        this.race = race;
    }

    public void equipWeapon(aWeapon weapon) {
        damage = weapon.getDamage() + weapon.getDamageBonus();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getCoppers() {
        return coppers;
    }

    public void setCoppers(int coppers) {
        this.coppers = coppers;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public Boolean getFirstDialogue() {
        return firstDialogue;
    }

    public void setFirstDialogue(Boolean firstDialogue) {
        this.firstDialogue = firstDialogue;
    }

    public Dialogue getDialogue() {
        return dialogue;
    }

    public void setDialogue(Dialogue dialogue) {
        this.dialogue = dialogue;
    }
}
