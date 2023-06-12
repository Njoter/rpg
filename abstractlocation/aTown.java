package abstractlocation;

import java.util.HashMap;

public abstract class aTown extends aLocation implements java.io.Serializable {


    public aTown(String name) {
        super(name);
    }

    public aTown(String name, boolean playerHere) {
        super(name, playerHere);
    }

    public void enterLocation() {
        addDistrictToMap();
        if (firstTimeEntered) {
            setDistrictDescriptions();
            firstTimeEntered = false;
        }
    }

    protected abstract void addDistrictToMap();
    protected abstract void setDistrictDescriptions();
}
