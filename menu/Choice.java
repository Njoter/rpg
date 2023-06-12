package menu;

public class Choice implements java.io.Serializable {
    private String string;
    private boolean isDistrict;

    // Use this if choice is not district.
    public Choice(String string) {
        this.string = string;
        isDistrict = false;
    }

    // Use this if choice is location.
    public Choice(String string, boolean isDistrict) {
        this.string = string;
        this.isDistrict = isDistrict;
    }

    public String getString() {
        return this.string;
    }

    public boolean isDistrict() {
        return isDistrict;
    }
}
