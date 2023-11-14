package christmas.domain;

import static christmas.common.util.ErrorMessage.MENU_COUNT_ONLY_NUMBER;

import christmas.common.Validation;

public class Count {

    private final Integer count;

    public Count(String count) {
        validate(count);
        this.count = Integer.valueOf(count);
    }

    private void validate(String count) {
        Validation.onlyNumber(count, MENU_COUNT_ONLY_NUMBER.getMessage());
    }
}
