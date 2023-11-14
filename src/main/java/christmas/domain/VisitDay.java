package christmas.domain;

import static christmas.common.util.ErrorMessage.VISIT_ONLY_NUMBER;

import christmas.common.Validation;

public class VisitDay {

    private final Integer day;
    public VisitDay(int day) {
        validate(day);
        this.day = day;
    }

    private void validate(int day) {
        Validation.VisitDayMonth(day);
        Validation.onlyNumber(String.valueOf(day), VISIT_ONLY_NUMBER.getMessage());
    }
}
