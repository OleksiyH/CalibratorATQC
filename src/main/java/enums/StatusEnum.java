package enums;

import enums.FeesEnums.CurrencyEnum;

/**
 * Created by Oleksiy on 23.04.2016.
 */
public enum StatusEnum {
    RELEASED("1"),
    UNRELEASED("0"),
    DELETED("-1");


    private final String value;

    StatusEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static StatusEnum get(String value) {
        StatusEnum anEnum = null;
        for (StatusEnum status : StatusEnum.values()) {
            if (status.getValue().equals(value))
                anEnum = status;
        }
        return anEnum;
    }

}
