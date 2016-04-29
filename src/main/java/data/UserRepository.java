package data;

/**
 * Created by Oleksiy on 23.04.2016.
 */
public class UserRepository {

    public static User getTestUser() {
        User user = new User();
        user.setPassword("abc123");
        user.setUsername("qa@psolution.com");
        return user;
    }

    public static User getSystemAdminUser() {
        User user = new User();
        user.setPassword("abc123");
        user.setUsername("sysadmin@psolution.com");
        return user;
    }

}
