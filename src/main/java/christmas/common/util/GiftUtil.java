package christmas.common.util;

public enum GiftUtil {

    MENU("샴페인 1개"),
    NO("없음");

    private final String gift;


    GiftUtil(String gift) {
        this.gift = gift;
    }

    public String getGift() {
        return gift;
    }
}
