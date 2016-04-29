package enums;

/**
 * Created by Oleksiy on 23.04.2016.
 */
public enum ShowItemsEnum {
    FIVE("5"),
    FIFTEEN("15"),
    TWENTY("20"),
    ALL("-1");

    private final String value;

    ShowItemsEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
