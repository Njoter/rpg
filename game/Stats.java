package game;

import objects.aWeapon;

public class Stats {

    private static Character[] weaponStatScaling = {'S', 'A', 'B', 'C', 'D', 'E'};
    private static double[] weaponScalingMultiplier = {1.15, 1.08, 1.06, 1.05, 1.025, 1.01};

    public static Character[] getWeaponStatScaling() {
        return weaponStatScaling;
    }

    public static double[] getWeaponScalingMultiplier() {
        return weaponScalingMultiplier;
    }
}
