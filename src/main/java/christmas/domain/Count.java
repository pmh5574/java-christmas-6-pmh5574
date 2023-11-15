package christmas.domain;

import static christmas.common.message.ErrorMessage.NOT_USE_MENU;

import christmas.common.Validation;

public class Count {

    private final Integer count;

    public Count(String count) {
        validate(count);
        this.count = Integer.valueOf(count);
    }

    private void validate(String count) {
        Validation.onlyNumber(count, NOT_USE_MENU.getMessage());
        Validation.zeroCheck(Integer.parseInt(count));
    }

    public Integer getCount() {
        return count;
    }

    @Override
    public String toString() {
        return String.valueOf(count);
    }
}
