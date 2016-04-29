package enums.productEnums;

/**
 * Created by Oleksiy on 23.04.2016.
 */
public enum PrintTypeEnum {
    DIGITAL("0");
    //TODO "A PSC Conversion Product is required if product is a print product." Dont know what is Conversion Product and how it appears in the list
    //PRINT_PRODUCT("1"),
   //TODO this option was deleted PRINT_BUNDLE("3"),
    //TODO "If Variable Print Type is selected, product type must be trial"
    //TODO this option was deleted TRIAL_PRINT_TYPE("4");


    private final String value;

    PrintTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static PrintTypeEnum get(String value) {
        PrintTypeEnum anEnum = null;
        for (PrintTypeEnum colour : PrintTypeEnum.values()) {
            if (colour.getValue().equals(value))
                anEnum = colour;
        }
        return anEnum;
    }
}
