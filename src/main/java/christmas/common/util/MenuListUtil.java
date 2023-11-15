package christmas.common.util;

public enum MenuListUtil {

    ZERO(0),
    FIRST(1),
    TEN(10),
    MENU_LIMIT(20),
    GIFT_PRICE(120000),
    SALE_PRICE(2023);

    private final Integer number;

    MenuListUtil(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }
}
