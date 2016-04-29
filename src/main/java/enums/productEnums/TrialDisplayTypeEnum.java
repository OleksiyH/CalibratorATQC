package enums.productEnums;

/**
 * Created by Oleksiy on 23.04.2016.
 */
public enum TrialDisplayTypeEnum {
    ORIGINAL_TRIAL("0"),
    RED_LINE("1"),
    HEADER("2"),
    DESCRIPTION("3");

    private final String value;

    TrialDisplayTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TrialDisplayTypeEnum get(String value) {
        TrialDisplayTypeEnum anEnum = null;
        for (TrialDisplayTypeEnum colour : TrialDisplayTypeEnum.values()) {
            if (colour.getValue().equals(value))
                anEnum = colour;
        }
        return anEnum;
    }
}
