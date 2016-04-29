package enums.FeesEnums;

/**
 * Created by Oleksiy on 23.04.2016.
 */
public enum TaxTypeEnum {

    NO_TAXES("18002"),
    FOR_CUSTOMERS_IN_STATE("18020"),
    CUSTOMER_LOCATION("18000"),
    PRODUCT_LOCATION("18001");

    private final String value;

    TaxTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TaxTypeEnum get(String value) {
        TaxTypeEnum anEnum = null;
        for (TaxTypeEnum colour : TaxTypeEnum.values()) {
            if (colour.getValue().equals(value))
                anEnum = colour;
        }
        return anEnum;
    }
}
