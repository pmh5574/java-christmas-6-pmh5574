package christmas.common.util;

public enum MenuListUtil {

    ZERO(0),
    FIRST(1),
    MENU_LIMIT(20);

    private final Integer number;

    MenuListUtil(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }
}
