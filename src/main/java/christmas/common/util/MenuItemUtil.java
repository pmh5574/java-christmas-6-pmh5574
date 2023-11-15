package christmas.common.util;

public enum MenuItemUtil {
    SOUP("양송이수프", 6000),
    TBAS("타파스", 5500),
    CESAR("시저샐러드", 8000),

    TBONE("티본스테이크",55000),
    BBQ("바비큐립",54000),
    H_PASTA("해산물파스타",35000),
    C_PASTA("크리스마스파스타",25000),

    CAKE("초코케이크",15000),
    ICE("아이스크림",5000),

    COKE("제로콜라",3000),
    WINE("레드와인",60000),
    Champ("샴페인",25000);


    private final String name;
    private final Integer price;

    MenuItemUtil(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }
    public Integer getPrice() {
        return price;
    }

    public static String fromName(String name) {
        for (MenuItemUtil item : MenuItemUtil.values()) {
            if (item.name.equals(name)) {
                return name;
            }
        }
        return "";
    }

    public static Integer fromPrice(String name) {
        for (MenuItemUtil item : MenuItemUtil.values()) {
            if (item.name.equals(name)) {
                return item.price;
            }
        }
        return 0;
    }
}
