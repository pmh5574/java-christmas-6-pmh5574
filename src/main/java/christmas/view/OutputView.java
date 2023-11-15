package christmas.view;

import static christmas.common.message.OutputMessage.BEFORE_SALE;
import static christmas.common.message.OutputMessage.EVENT_COMMENT_START;
import static christmas.common.message.OutputMessage.GIFT_MENU;
import static christmas.common.message.OutputMessage.ORDER_MENU_CHECK;
import static christmas.common.message.OutputMessage.SET_MENU;
import static christmas.common.message.OutputMessage.START;
import static christmas.common.message.OutputMessage.WON;

import christmas.domain.Count;
import christmas.domain.Menu;

public class OutputView {

    public void start() {
        printlnOut(START.getMessage());
    }

    public void setMenu() {
        printlnOut(SET_MENU.getMessage());
    }

    public void eventCommentStart() {
        printlnOut(EVENT_COMMENT_START.getMessage());
        printlnOut("");
    }

    public void orderMenuCheck() {
        printlnOut(ORDER_MENU_CHECK.getMessage());
    }

    public void beforeSaleComment() {
        printlnOut("");
        printlnOut(BEFORE_SALE.getMessage());
    }

    public void beforeSalePrice(String totalPrice) {
        printlnOut(totalPrice + WON.getMessage());
    }

    public void printMenuList(Menu menu, Count count) {
        printlnOut(menu.toString() + " " + count.toString() + "개");
    }

    public void giftMenuComment() {
        printlnOut("");
        printlnOut(GIFT_MENU.getMessage());
    }

    public void giftMenu(String giftMenu) {
        printlnOut(giftMenu);
    }

    public void saleComment() {
        printlnOut("");
        printlnOut("<혜택 내역>");
    }
    public void dDaySale(String daySale) {
        printlnOut("크리스마스 디데이 할인: -" + daySale + WON.getMessage());
    }

    public void weekSale(String dayPrint, String specialSale) {
        printlnOut(dayPrint + " 할인: -" + specialSale + WON.getMessage());
    }

    public void specialSale(String menuSalePrice) {
        printlnOut("특별 할인: -" + menuSalePrice + WON.getMessage());
    }

    public void giftSale(String giftSale) {
        printlnOut("증정 이벤트: -" + giftSale + WON.getMessage());
    }

    private void printlnOut(String message) {
        System.out.println(message);
    }
}
