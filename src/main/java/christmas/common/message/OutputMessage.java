package christmas.common.message;

public enum OutputMessage {

    START("""
            안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.
            12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"""),
    SET_MENU("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),
    EVENT_COMMENT_START("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    ORDER_MENU_CHECK("<주문 메뉴>"),
    BEFORE_SALE("<할인 전 총주문 금액>"),
    WON("원"),
    GIFT_MENU("<증정 메뉴>"),
    RESULT_PRICE("<할인 후 예상 결제 금액>"),
    GRADE("<12월 이벤트 배지>"),
    TOTAL_SALE("<총혜택 금액>"),
    GIFT_SALE_COMMENT("증정 이벤트: -"),
    SPECIAL_SALE("특별 할인: -"),
    SALE(" 할인: -"),
    D_DAY_SALE("크리스마스 디데이 할인: -"),
    SALE_COMMENT("<혜택 내역>");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getMessage(int day) {
        return String.format(this.message, day);
    }
}
