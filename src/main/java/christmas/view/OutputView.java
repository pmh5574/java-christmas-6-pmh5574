package christmas.view;

import christmas.common.message.OutputMessage;
import christmas.common.util.PriceStringUtil;
import christmas.common.util.PriceUtil;
import christmas.domain.Count;
import christmas.domain.Menu;

public class OutputView {

    public void start() {
        printlnOut(OutputMessage.START.getMessage());
    }

    public void setMenu() {
        printlnOut(OutputMessage.SET_MENU.getMessage());
    }

    public void eventCommentStart(Integer day) {
        printlnOut(OutputMessage.EVENT_COMMENT_START.getMessage(day));
        printlnOut("");
    }

    public void orderMenuCheck() {
        printlnOut(OutputMessage.ORDER_MENU_CHECK.getMessage());
    }

    public void beforeSaleComment() {
        printlnOut("");
        printlnOut(OutputMessage.BEFORE_SALE.getMessage());
    }

    public void beforeSalePrice(String totalPrice) {
        printlnOut(totalPrice + OutputMessage.WON.getMessage());
    }

    public void printMenuList(Menu menu, Count count) {
        printlnOut(menu.toString() + " " + count.toString() + "개");
    }

    public void giftMenuComment() {
        printlnOut("");
        printlnOut(OutputMessage.GIFT_MENU.getMessage());
    }

    public void giftMenu(String giftMenu) {
        printlnOut(giftMenu);
    }

    public void saleComment() {
        printlnOut("");
        printlnOut(OutputMessage.SALE_COMMENT.getMessage());
    }
    public void dDaySale(String daySale) {
        printlnOut(OutputMessage.D_DAY_SALE.getMessage() + daySale + OutputMessage.WON.getMessage());
    }

    public void weekSale(String dayPrint, String specialSale) {
        printlnOut(dayPrint + OutputMessage.SALE.getMessage() + specialSale + OutputMessage.WON.getMessage());
    }

    public void specialSale(String menuSalePrice) {
        printlnOut(OutputMessage.SPECIAL_SALE.getMessage() + menuSalePrice + OutputMessage.WON.getMessage());
    }

    public void giftSale(String giftSale) {
        printlnOut(OutputMessage.GIFT_SALE_COMMENT.getMessage() + giftSale + OutputMessage.WON.getMessage());
    }

    public void totalSale(String totalSalePrice) {
        printlnOut("");
        printlnOut(OutputMessage.TOTAL_SALE.getMessage());
        printlnOut("-" + totalSalePrice + OutputMessage.WON.getMessage());
    }

    public void totalPriceCheck(Integer price) {
        if (price == PriceUtil.ZERO.getNumber()) {
            printlnOut(PriceStringUtil.NO.getMessage());
        }
    }

    public void resultPrice(String resultPrice) {
        printlnOut("");
        printlnOut(OutputMessage.RESULT_PRICE.getMessage());
        printlnOut(resultPrice + OutputMessage.WON.getMessage());
    }

    public void grade(String grade) {
        printlnOut("");
        printlnOut(OutputMessage.GRADE.getMessage());
        printlnOut(grade);
    }

    private void printlnOut(String message) {
        System.out.println(message);
    }
}
