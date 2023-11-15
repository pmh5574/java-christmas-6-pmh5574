package christmas.common.util;

public enum PriceUtil {
    ZERO(0),
    STAR(5000),
    TREE(10000),
    SANTA(20000);

    private final Integer number;

    PriceUtil(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }
}
