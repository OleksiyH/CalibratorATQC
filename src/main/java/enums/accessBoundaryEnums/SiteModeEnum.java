package enums.accessBoundaryEnums;

/**
 * Created by Oleksiy on 23.04.2016.
 */
public enum SiteModeEnum {

    WEBSITE("1"),
    DIGITAL_EXPRESS("2"),
    TABLET("3"),
    IOS_DEVICE("4"),
    ANDROID_DEVICE("5"),
    OTHER("6");

    private final String value;

    SiteModeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static SiteModeEnum get(String value) {
        SiteModeEnum anEnum = null;
        for (SiteModeEnum colour : SiteModeEnum.values()) {
            if (colour.getValue().equals(value))
                anEnum = colour;
        }
        return anEnum;
    }
}
