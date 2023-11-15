package christmas.common.util;

public enum PriceUtil {
    ZERO(0);

    private final Integer number;

    PriceUtil(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }
}
