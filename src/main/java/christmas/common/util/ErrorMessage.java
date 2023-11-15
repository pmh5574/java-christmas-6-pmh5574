package christmas.common.util;

public enum ErrorMessage {

    ERROR("[ERROR]"),
    NOT_USE_VISIT_DAY(ERROR.message + " 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    NOT_USE_MENU(ERROR.message + " 유효하지 않은 주문입니다. 다시 입력해 주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
