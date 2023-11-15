package christmas.common.util;

public enum DayUtil {
    WEEK("주말"),
    NO_WEEK("평일"),
    NOW_YEAR_MONTH("2023-12-%s");

    private final String message;

    DayUtil(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getMessage(String day) {
        return String.format(this.message, day);
    }
}
