package abstractlocation;

import menu.ChoiceInterface;

import java.util.HashMap;

public abstract class aDistrict extends aLocation implements ChoiceInterface, java.io.Serializable {


    public aDistrict(String name) {
        super(name);
    }

    public aDistrict(String name, boolean playerHere) {
        super(name, playerHere);
    }

    @Override
    public void enterLocation() {
        removeDistrictPlayerIsIn();
        super.enterLocation();
    }

    private void removeDistrictPlayerIsIn() {
        int i = 0;
        int hashKey = 0;
        for (Integer key : districtMap.keySet()) {
            if (districtMap.get(key).isPlayerHere()) {
                hashKey = key;
            }
        }
        districtMap.remove(hashKey);
    }

    protected abstract void gamePlay(int key);
    protected abstract void addBuildingsToMap();
}
