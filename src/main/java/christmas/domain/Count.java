package christmas.domain;

import christmas.common.Validation;

public class Count {

    private final Integer count;

    public Count(String count) {
        validate(count);
        this.count = Integer.valueOf(count);
    }

    private void validate(String count) {
        Validation.onlyNumber(count);
        Validation.zeroCheck(Integer.parseInt(count));
    }
}
