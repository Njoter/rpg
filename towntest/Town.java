package test;

import static test.TownObjects.northDistrict;
import static test.TownObjects.tavern;

public class Town extends aLocation2 implements TownInterface {

    public Town(String name, String description) {
        super(name, description);
    }
    public Town(String name, String description, boolean playerHere) {
        super(name, description, playerHere);
    }

    @Override
    public void enterLocation() {

    }

    @Override
    public void setDistrictVariables() {
        northDistrict.setDescription("This is the northern district.");
    }

    @Override
    public void setBuildingVariables() {
    }


    @Override
    public void populateDistrictMap() {
        locationMap.put(1, northDistrict);
    }

    @Override
    public void populateBuildingMap() {
        northDistrict.locationMap.put(1, tavern);
    }
}
