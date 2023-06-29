package objects;

import game.Game;
import player.Player;

public abstract class aWeapon extends Item {

    protected Character strScaling = null;
    protected Character dexScaling = null;
    protected Character intScaling = null;
    protected int strDamageBonus = 0;
    protected int dexDamageBonus = 0;
    protected int intDamageBonus = 0;
    protected int damage;
    protected boolean equipped = false;

    public aWeapon(String name, String description, double weight) {
        super(name, description, weight);
    }

    public int getDamage() {
        return damage;
    }

    public Character getStrScaling() {
        return strScaling;
    }

    public Character getDexScaling() {
        return dexScaling;
    }

    public Character getIntScaling() {
        return intScaling;
    }

    public void setStrDamageBonus(int strDamageBonus) {
        this.strDamageBonus = strDamageBonus;
    }

    public void setDexDamageBonus(int dexDamageBonus) {
        this.dexDamageBonus = dexDamageBonus;
    }

    public void setIntDamageBonus(int intDamageBonus) {
        this.intDamageBonus = intDamageBonus;
    }

    public int getStrDamageBonus() {
        return strDamageBonus;
    }

    public int getDexDamageBonus() {
        return dexDamageBonus;
    }

    public int getIntDamageBonus() {
        return intDamageBonus;
    }

    public void setEquipped(boolean equipped) {
        this.equipped = equipped;
    }
}
