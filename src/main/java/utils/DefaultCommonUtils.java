package utils;


import org.apache.commons.lang3.RandomStringUtils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;

public class DefaultCommonUtils {

    private static Random random;

    static {
        random = new Random();
    }

    public static String generateAlphaNumericString(int number) {
        return RandomStringUtils.randomAlphanumeric(number);
    }

    public static String generateAlphabeticalString(int number) {
        return RandomStringUtils.randomAlphabetic(number);
    }

    public static String genNumericString(int number) {
        return RandomStringUtils.randomNumeric(number);
    }

    public static String genUrlLikeString(){
        return "https://"+DefaultCommonUtils.generateAlphabeticalString(8)+".com";
    }

    public static String genNINumber(){
        StringBuilder string = new StringBuilder();
        string.append(generateAlphabeticalString(2).toUpperCase());
        string.append(genNumericString(6));
        string.append(generateAlphabeticalString(1).toUpperCase());
        return string.toString();
    }

    public static String genValidPassword() {
        String password = generateAlphabeticalString(1).toUpperCase() + generateAlphabeticalString(3).toLowerCase() + genNumericString(4) + "!";

        return password;
    }

    public static Boolean randomBoolean() {
        Random random = new Random();
        return random.nextBoolean();
    }

    public static String getProperty(String propertyName) {
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream("./src/test/resources/tests.properties");
            prop.load(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(propertyName);
    }

    public static <T extends Enum<?>> T randomEnum(Class<T> clazz) {
        int x = random.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }
}


