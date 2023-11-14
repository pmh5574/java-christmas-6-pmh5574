package christmas.common;

import static christmas.common.util.ErrorMessage.BLANK;
import static christmas.common.util.ErrorMessage.NOT_VISIT_DAY;
import static christmas.common.util.VisitDayUtil.MONTH_FIRST;
import static christmas.common.util.VisitDayUtil.MONTH_LAST;

public class Validation {

    private static final String ONLY_NUMBER_CHECK = "\\\\d+";

    public static void VisitDayMonth(int inputData) {
        if (MONTH_FIRST.getNumber() > inputData || MONTH_LAST.getNumber() < inputData) {
            throw new IllegalArgumentException(NOT_VISIT_DAY.getMessage());
        }
    }

    public static void onlyNumber(String inputData, String errorMessage) {
        if (!(inputData != null && inputData.matches(ONLY_NUMBER_CHECK))) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static void blankCheck(String inputData) {
        if (inputData.isEmpty()) {
            throw new IllegalArgumentException(BLANK.getMessage());
        }
    }
}
