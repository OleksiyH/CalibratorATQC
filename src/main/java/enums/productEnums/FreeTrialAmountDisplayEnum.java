package enums.productEnums;

/**
 * Created by Oleksiy on 23.04.2016.
 */
public enum FreeTrialAmountDisplayEnum {
    FREE("0"),
    ZERO_POINT_ZERO("1");

    private final String value;

    FreeTrialAmountDisplayEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static FreeTrialAmountDisplayEnum get(String value) {
        FreeTrialAmountDisplayEnum anEnum = null;
        for (FreeTrialAmountDisplayEnum colour : FreeTrialAmountDisplayEnum.values()) {
            if (colour.getValue().equals(value))
                anEnum = colour;
        }
        return anEnum;
    }
}
