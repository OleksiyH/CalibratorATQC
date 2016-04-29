package enums.productEnums;

/**
 * Created by Oleksiy on 23.04.2016.
 */
public enum PeriodTypeEnum {

    DAYS("1"),
    WEEK("2"),
    EVERY_10_DAYS("3"),
    EVERY_OTHER_WEEK("4"),
    EVERY_15_DAYS("5"),
    EVERY_20_DAYS("6"),
    MONTH_30DAYS("7"),
    MONTH_ACTUAL("8"),
    TWO_MONTHS_60DAYS("9"),
    TWO_MONTHS_ACTUAL("10"),
    THREE_MONTHS_90DAYS("11"),
    THREE_MONTHS_ACTUAL("12"),
    SIX_MONTHS_180DAYS("13"),
    SIX_MONTHS_ACTUAL("14"),
    YEAR("15");


    private final String value;

    PeriodTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static PeriodTypeEnum get(String value) {
        PeriodTypeEnum anEnum = null;
        for (PeriodTypeEnum colour : PeriodTypeEnum.values()) {
            if (colour.getValue().equals(value))
                anEnum = colour;
        }
        return anEnum;
    }
}
