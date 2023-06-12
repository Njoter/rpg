package towntest;

import abstractlocation.aLocation;
import abstractlocation.aTown;
import util.PrintToConsole;
import util.PromptUserForInput;

public class TownTest extends aTown implements java.io.Serializable {

    private aLocation northDistrict = new NorthDistrict("North district", true);
    private aLocation eastDistrict = new EastDistrict("East district");
    private aLocation westDistrict = new WestDistrict("West district");
    private aLocation southDistrict = new SouthDistrict("South district");

    public TownTest(String name) {
        super(name);
    }

    public TownTest(String name, boolean playerHere) {
        super(name, playerHere);
    }

    @Override
    public void enterLocation() {
        super.enterLocation();
        while (true) {
            for (aLocation district : districtMap.values()) {
                if (district.isPlayerHere()) {
                    district.enterLocation();
                    break;
                }
            }
        }
    }

    @Override
    protected void addDistrictToMap() {
        districtMap.put(1, northDistrict);
        districtMap.put(2, eastDistrict);
        districtMap.put(3, westDistrict);
        districtMap.put(4, southDistrict);
    }

    @Override
    protected void setDistrictDescriptions() {
        String description = """
                You are in the north district, also known as the commercial district.
                There are lots of people working here, and the district is home to many shops and businesses.
                Among the buildings in the area, you can see a general store, a blacksmith, a carpenter, a tanner,
                and a cozy, little tavern.""";
        districtMap.get(1).setDescription(description);
        districtMap.get(2).setDescription("You are in the " + districtMap.get(2).getName());
        districtMap.get(3).setDescription("You are in the " + districtMap.get(3).getName());
        districtMap.get(4).setDescription("You are in the " + districtMap.get(4).getName());
    }
}
