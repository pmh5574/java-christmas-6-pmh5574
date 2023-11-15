package christmas.common.util;

public enum VisitDayUtil {

    MONTH_FIRST(1),
    MONTH_LAST(31),
    CHRISTMAS(25),
    DAY_SALE_PRICE(100),
    THOUSAND(1000),
    ONE(1),
    ZERO(0),
    SALE_DAY_3(3),
    SALE_DAY_10(10),
    SALE_DAY_17(17),
    SALE_DAY_24(24),
    SALE_DAY_25(25),
    SALE_DAY_31(31);

    private final Integer number;

    VisitDayUtil(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }
}
