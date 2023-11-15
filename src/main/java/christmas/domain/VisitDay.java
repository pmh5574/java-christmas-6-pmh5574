package christmas.domain;

import christmas.common.Validation;

public class VisitDay {

    private final Integer day;
    public VisitDay(int day) {
        validate(day);
        this.day = day;
    }

    private void validate(int day) {
        Validation.VisitDayMonth(day);
    }
}
