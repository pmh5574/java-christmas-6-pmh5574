package christmas.common;

import static christmas.common.util.ErrorMessage.NOT_USE_MENU;
import static christmas.common.util.ErrorMessage.NOT_USE_VISIT_DAY;
import static christmas.common.util.VisitDayUtil.MONTH_FIRST;
import static christmas.common.util.VisitDayUtil.MONTH_LAST;

public class Validation {

    private static final String ONLY_NUMBER_CHECK = "\\\\d+";

    private static final Integer MENU_ITEM_SPLIT_LENGTH = 2;

    public static void VisitDayMonth(int inputData) {
        if (MONTH_FIRST.getNumber() > inputData || MONTH_LAST.getNumber() < inputData) {
            throw new IllegalArgumentException(NOT_USE_VISIT_DAY.getMessage());
        }
    }

    public static void onlyNumber(String inputData) {
        if (!(inputData != null && inputData.matches(ONLY_NUMBER_CHECK))) {
            throw new IllegalArgumentException(NOT_USE_MENU.getMessage());
        }
    }

    public static void blankCheck(String inputData) {
        if (inputData.isEmpty()) {
            throw new IllegalArgumentException(NOT_USE_MENU.getMessage());
        }
    }

}
