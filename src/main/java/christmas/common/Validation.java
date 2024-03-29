package christmas.common;

import static christmas.common.message.ErrorMessage.NOT_USE_MENU;
import static christmas.common.message.ErrorMessage.NOT_USE_VISIT_DAY;
import static christmas.common.util.MenuListUtil.MENU_LIMIT;
import static christmas.common.util.MenuListUtil.ZERO;
import static christmas.common.util.VisitDayUtil.MONTH_FIRST;
import static christmas.common.util.VisitDayUtil.MONTH_LAST;

import christmas.common.message.ErrorMessage;
import christmas.common.util.MenuItemUtil;
import java.util.Objects;

public class Validation {

    private static final String ONLY_NUMBER_CHECK = "\\d+";

    private static final Integer MENU_ITEM_SPLIT_LENGTH = 2;

    public static void visitDayMonth(int inputData) {
        if (MONTH_FIRST.getNumber() > inputData || MONTH_LAST.getNumber() < inputData) {
            throw new IllegalArgumentException(NOT_USE_VISIT_DAY.getMessage());
        }
    }

    public static void onlyNumber(String inputData, String message) {
        if (!(inputData != null && inputData.matches(ONLY_NUMBER_CHECK))) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void blankCheck(String inputData) {
        if (inputData.isEmpty()) {
            throw new IllegalArgumentException(NOT_USE_MENU.getMessage());
        }
    }

    public static void notMatchMenu(String[] parts) {
        if (parts.length != MENU_ITEM_SPLIT_LENGTH) {
            throw new IllegalArgumentException(NOT_USE_MENU.getMessage());
        }
    }

    public static void isValidMenu(String menuName) {

        if (MenuItemUtil.fromName(menuName).isEmpty()) {
            throw new IllegalArgumentException(NOT_USE_MENU.getMessage());
        }
    }

    public static void zeroCheck(Integer number, String message) {
        if (Objects.equals(number, ZERO.getNumber())) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void duplicateMenu(boolean check) {
        if (!check) {
            throw new IllegalArgumentException(NOT_USE_MENU.getMessage());
        }
    }

    public static void limitCount(Integer totalCount) {
        if (totalCount > MENU_LIMIT.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage.MENU_LIMIT
                    .getMessage());
        }
    }
}
