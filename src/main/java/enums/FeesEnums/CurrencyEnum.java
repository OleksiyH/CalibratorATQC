package enums.FeesEnums;

/**
 * Created by Oleksiy on 23.04.2016.
 */
public enum CurrencyEnum {

    US_DOLLAR("USD"),
    UK_POUND("GBP"),
    EU_EURO("EUR"),
    JA_YEN("YEN"),
    HU_FLORIN("FLO"),
    SWEDISH_KRONA("SEK"),
    AUSTRALIAN_DOLLAR("AUD"),
    CA_DOLLAR("CAD"),
    INDIAN_RUPEE("INR"),
    SINGAPOREAN_DOLLAR("SGD"),
    NEW_ZEALAND_DOLLAR("NZD"),
    ARGENTINE_PESO("ARS");

    private final String value;

    CurrencyEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static CurrencyEnum get(String value) {
        CurrencyEnum anEnum = null;
        for (CurrencyEnum colour : CurrencyEnum.values()) {
            if (colour.getValue().equals(value))
                anEnum = colour;
        }
        return anEnum;
    }
}
