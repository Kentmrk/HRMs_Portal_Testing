package utils;

public class Constants {
    public static final String CONFIG_FILE_PATH =
            System.getProperty("user.dir") + "/src/test/resources/config/config.properties";

    public static final String SCREENSHOT_PATH =
            System.getProperty("user.dir") + "/screenshots/";

    public static final int IMPLICIT_WAIT = 10;
    public static final int EXPLICIT_WAIT = 20;

    // Error Messages
    public static final String INVALID_CREDENTIALS_ERROR = "Invalid credentials";
    public static final String EMPTY_USERNAME_ERROR = "Username cannot be empty";
    public static final String EMPTY_PASSWORD_ERROR = "Password cannot be empty";
}