package christmas.domain;

import static christmas.common.util.VisitDayUtil.CHRISTMAS;
import static christmas.common.util.VisitDayUtil.DAY_SALE_PRICE;
import static christmas.common.util.VisitDayUtil.MONTH_FIRST;
import static christmas.common.util.VisitDayUtil.ONE;
import static christmas.common.util.VisitDayUtil.SALE_DAY_10;
import static christmas.common.util.VisitDayUtil.SALE_DAY_17;
import static christmas.common.util.VisitDayUtil.SALE_DAY_24;
import static christmas.common.util.VisitDayUtil.SALE_DAY_25;
import static christmas.common.util.VisitDayUtil.SALE_DAY_3;
import static christmas.common.util.VisitDayUtil.SALE_DAY_31;
import static christmas.common.util.VisitDayUtil.THOUSAND;
import static christmas.common.util.VisitDayUtil.ZERO;

import christmas.common.Validation;
import java.util.List;

public class VisitDay {

    private final Integer day;

    private List<Integer> saleDay = List.of(
            SALE_DAY_3.getNumber(),
            SALE_DAY_10.getNumber(),
            SALE_DAY_17.getNumber(),
            SALE_DAY_24.getNumber(),
            SALE_DAY_25.getNumber(),
            SALE_DAY_31.getNumber());
    public VisitDay(int day) {
        validate(day);
        this.day = day;
    }

    private void validate(int day) {
        Validation.visitDayMonth(day);
    }

    public Integer getDay() {
        return day;
    }

    public Integer getSalePrice() {
        Integer salePrice = 0;

        if (day > MONTH_FIRST.getNumber() || day <= CHRISTMAS.getNumber()) {
            salePrice = (day - ONE.getNumber()) * DAY_SALE_PRICE.getNumber();
        }

        if (day >= MONTH_FIRST.getNumber() || day <= CHRISTMAS.getNumber()) {
            return salePrice + THOUSAND.getNumber();
        }
        return salePrice;
    }

    public Integer specialDaySale() {
        if (saleDay.contains(day)) {
            return THOUSAND.getNumber();
        }
        return ZERO.getNumber();
    }
}
