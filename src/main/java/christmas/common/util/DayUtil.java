package christmas.common.util;

public enum DayUtil {
    WEEK("주말"),
    NO_WEEK("평일");

    private final String message;

    DayUtil(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
