package christmas.common.util;

public enum VisitDayUtil {

    MONTH_FIRST(1),
    MONTH_LAST(31);

    private final Integer number;

    VisitDayUtil(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }
}
