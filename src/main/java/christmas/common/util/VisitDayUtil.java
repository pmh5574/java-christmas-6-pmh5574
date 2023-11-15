package christmas.common.util;

public enum VisitDayUtil {

    MONTH_FIRST(1),
    MONTH_LAST(31),
    CHRISTMAS(25),
    DAY_SALE_PRICE(100),
    THOUSAND(1000),
    ONE(1),
    ZERO(0);

    private final Integer number;

    VisitDayUtil(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }
}
