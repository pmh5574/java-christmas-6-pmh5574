package christmas.domain;

import christmas.common.Validation;

public class VisitDay {
    public VisitDay(int day) {
        validate(day);
    }

    private void validate(int day) {
        Validation.VisitDayMonth(day);
        Validation.VisitDayOnlyNumber(String.valueOf(day));
    }
}
