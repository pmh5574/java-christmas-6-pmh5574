package christmas.common;

import static christmas.common.util.ErrorMessage.NOT_VISIT_DAY;
import static christmas.common.util.VisitDayUtil.MONTH_FIRST;
import static christmas.common.util.VisitDayUtil.MONTH_LAST;

public class Validation {

    private static final String ONLY_NUMBER_CHECK = "[-+]?\\d*\\.?\\d+";

    public static void VisitDayMonth(int inputData) {
        if (MONTH_FIRST.getNumber() > inputData || MONTH_LAST.getNumber() < inputData) {
            throw new IllegalArgumentException(NOT_VISIT_DAY.getMessage());
        }
    }

}
