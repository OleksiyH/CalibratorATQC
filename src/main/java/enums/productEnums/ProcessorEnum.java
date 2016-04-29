package enums.productEnums;

/**
 * Created by Oleksiy on 23.04.2016.
 */
public enum ProcessorEnum {
    PAYMENT("1"),
    FREE("2"),
    EMPLOYEE_ACCOUNT("3");

    private final String value;

    ProcessorEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ProcessorEnum get(String value) {
        ProcessorEnum anEnum = null;
        for (ProcessorEnum colour : ProcessorEnum.values()) {
            if (colour.getValue().equals(value))
                anEnum = colour;
        }
        return anEnum;
    }
}
