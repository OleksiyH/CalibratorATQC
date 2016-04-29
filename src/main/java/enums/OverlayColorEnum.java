package enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Oleksiy on 23.04.2016.
 */
public enum OverlayColorEnum {
    DEFAULT("COLOR1"),
    DARK("COLOR2"),
    DARKER("COLOR3"),
    DARKEST("COLOR4"),
    NULL("COLOR5");

    private final String value;

    OverlayColorEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static OverlayColorEnum get(String value) {
        OverlayColorEnum anEnum = null;
        for (OverlayColorEnum colour : OverlayColorEnum.values()) {
            if (colour.getValue().equals(value))
                anEnum = colour;
        }
        return anEnum;
    }
}
