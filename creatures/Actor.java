package creatures;

import dialogue.Dialogue;
import game.Stats;
import objects.Unarmed;
import objects.aWeapon;
import util.MiscUtils;
import util.PromptUserForInput;

public abstract class Actor implements java.io.Serializable {
    private String name;
    private String description;
    private String race;
    private int healthPoints;
    private int mana;
    private int damage = 0;
    private int damageBonus;
    private int coppers;
    private int strength;
    private int constitution;
    private int dexterity;
    private int intelligence;
    private int charisma;
    private Boolean firstDialogue = true;
    private Dialogue dialogue;

    private aWeapon mainWeapon;
    private aWeapon unarmed = new Unarmed();

    public Actor(String name, String description, String race) {
        this.name = name;
        this.description = description;
        this.race = race;
        equipWeapon(unarmed);
    }

    public void equipWeapon(aWeapon weapon) {
        double strMultiplier = 0;
        double dexMultiplier = 0;
        double intMultiplier = 0;
        for (int i = 0; i < Stats.getWeaponStatScaling().length; i++) {
            if (weapon.getStrScaling() == null) {
                strMultiplier = 0;
            } else if (weapon.getStrScaling().equals(Stats.getWeaponStatScaling()[i])) {
                strMultiplier = (strength / 100.0) + Stats.getWeaponScalingMultiplier()[i];
            }
        }
        for (int i = 0; i < Stats.getWeaponStatScaling().length; i++) {
            if (weapon.getDexScaling() == null) {
                dexMultiplier = 0;
            } else if (weapon.getDexScaling().equals(Stats.getWeaponStatScaling()[i])) {
                dexMultiplier = (dexterity / 100.0) + Stats.getWeaponScalingMultiplier()[i];
            }
        }
        for (int i = 0; i < Stats.getWeaponStatScaling().length; i++) {
            if (weapon.getIntScaling() == null) {
                intMultiplier = 0;
            } else if (weapon.getIntScaling().equals(Stats.getWeaponStatScaling()[i])) {
                intMultiplier = (intelligence / 100.0) + Stats.getWeaponScalingMultiplier()[i];
            }
        }

        weapon.setStrDamageBonus((int)(strMultiplier * weapon.getDamage()) - damage);
        weapon.setDexDamageBonus((int)(dexMultiplier * weapon.getDamage()) - damage);
        weapon.setIntDamageBonus((int)(intMultiplier * weapon.getDamage()) - damage);
        damageBonus = weapon.getStrDamageBonus() + weapon.getDexDamageBonus() + weapon.getIntDamageBonus();
        damage = weapon.getDamage() + damageBonus;

        weapon.setEquipped(true);
        mainWeapon = weapon;
    }

    public void unequipWeapon() {
        mainWeapon.setEquipped(false);
        equipWeapon(unarmed);
        unarmed.setEquipped(true);
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

    public aWeapon getMainWeapon() {
        return mainWeapon;
    }
}
