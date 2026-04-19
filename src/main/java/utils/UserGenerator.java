package utils;

import model.User;
import org.apache.commons.lang3.RandomStringUtils;

public class UserGenerator {

    public static String randomString(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

    public static User randomUser() {
        return new User(randomName(), randomEmail(), randomPassword());

    }

    public static String randomEmail() {
        return "test_" + System.currentTimeMillis() + "@mail.com";

    }

    public static String randomPassword() {
        return "Pass_" + RandomStringUtils.randomAlphanumeric(8);
    }

    public static String randomName() {
        return "User" + RandomStringUtils.randomAlphabetic(10);
    }
}
