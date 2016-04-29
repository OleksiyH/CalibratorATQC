package enums.productEnums;

/**
 * Created by Oleksiy on 23.04.2016.
 */
public enum ProductTypeEnum {
    AUTO_RENEW("0"),
    NON_RENEWED("1"),
    //TODO "For trial product, Conversion product is required" - figure out what is conversion product or leave TRIAL commented
    //TODO Update: Trial type can be selected, if Trial Print Type is selected.... no need for Conversion product then
    TRIAL("3"),
    GIFT("4"),
    GIFT_BUNDLE("5");

    private final String value;

    ProductTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ProductTypeEnum get(String value) {
        ProductTypeEnum anEnum = null;
        for (ProductTypeEnum colour : ProductTypeEnum.values()) {
            if (colour.getValue().equals(value))
                anEnum = colour;
        }
        return anEnum;
    }
}
