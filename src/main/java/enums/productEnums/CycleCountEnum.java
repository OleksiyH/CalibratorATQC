package enums.productEnums;

/**
 * Created by Oleksiy on 23.04.2016.
 */
public enum CycleCountEnum {

    T1("1"),
    T2("2"),
    T3("3"),
    T4("4"),
    T5("5"),
    T6("6"),
    T7("7"),
    T8("8"),
    T9("9"),
    T10("10"),
    T12("11"),
    T13("12");


    private final String value;

    CycleCountEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static CycleCountEnum get(String value) {
        CycleCountEnum anEnum = null;
        for (CycleCountEnum colour : CycleCountEnum.values()) {
            if (colour.getValue().equals(value))
                anEnum = colour;
        }
        return anEnum;
    }
}
