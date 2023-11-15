package christmas.common.util;

public enum PriceStringUtil {
    NO("없음");

    private final String message;

    PriceStringUtil(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
