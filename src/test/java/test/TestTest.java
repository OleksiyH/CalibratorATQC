package test;

import enums.OverlayColorEnum;

/**
 * Created by Oleksiy on 24.04.2016.
 */
public class TestTest {

    public static void main(String[] args) {
        OverlayColorEnum enum1 = OverlayColorEnum.DARKER;
        OverlayColorEnum enum2 = OverlayColorEnum.get("COLOR3");
        System.out.println(enum2.getValue());
        System.out.println(enum1.getValue().equals(enum2.getValue()));
        System.out.println(enum2.toString());

    }

}
