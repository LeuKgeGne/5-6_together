package by.bsuir;

public class Constants {
    private static final Constants INSTANCE = new Constants();
    private Constants() {}

    public static Constants getInstance() {
        return INSTANCE;
    }

    public static final String REQUEST_INFO = "Request: ";
    public static final String RESPONSE_INFO = "Response: ";

    public static final String RESULT_INFO = "RESULT of the operation: ";

    public static final String KEY_SIDE_1 = "side1";
    public static final String KEY_SIDE_2 = "side2";
    public static final String KEY_SIDE_3 = "side3";

    public static final String IS_NOT_RIGHT = "The Triangle is NOT right";
    public static final String IS_RIGHT = "The Triangle is ABSOLUTELY right";

    public static final String IS_NOT_ISOSCELES = "The Triangle is NOT isosceles";
    public static final String IS_ISOSCELES = "The Triangle is ABSOLUTELY isosceles";

    public static final String IS_NOT_EQUILATERAL = "The Triangle is NOT equilateral";
    public static final String IS_EQUILATERAL = "The Triangle is ABSOLUTELY equilateral";
}
