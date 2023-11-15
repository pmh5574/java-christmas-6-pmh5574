package christmas.common.message;

public enum ErrorMessage {

    ERROR("[ERROR]"),
    NOT_USE_VISIT_DAY(ERROR.message + " 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    NOT_USE_MENU(ERROR.message + " 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    MENU_LIMIT(ERROR.message + " 한 번에 최대 20개까지만 주문할 수 있습니다."),
    NO_ONLY_DIRNK(ERROR.message + " 음료만 주문은 불가능합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
