package christmas.view;

import christmas.common.message.OutputMessage;
import christmas.domain.Count;
import christmas.domain.Menu;
import java.text.NumberFormat;

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
        printlnOut("<혜택 내역>");
    }
    public void dDaySale(String daySale) {
        printlnOut("크리스마스 디데이 할인: -" + daySale + OutputMessage.WON.getMessage());
    }

    public void weekSale(String dayPrint, String specialSale) {
        printlnOut(dayPrint + " 할인: -" + specialSale + OutputMessage.WON.getMessage());
    }

    public void specialSale(String menuSalePrice) {
        printlnOut("특별 할인: -" + menuSalePrice + OutputMessage.WON.getMessage());
    }

    public void giftSale(String giftSale) {
        printlnOut("증정 이벤트: -" + giftSale + OutputMessage.WON.getMessage());
    }

    public void totalSale(String totalSalePrice) {
        printlnOut("");
        printlnOut("<총혜택 금액>");
        printlnOut("-" + totalSalePrice + OutputMessage.WON.getMessage());
    }

    public boolean saleCheckAndPrice(Integer daySale, Integer specialSale, String dayPrint, Integer menuSalePrice, Integer giftSale,
                                  NumberFormat numberFormat, Integer totalPrice) {
        if (totalPrice <= 10000) {
            totalPriceCheck(0);
            return false;
        }
        totalPriceCheck((daySale + menuSalePrice + specialSale + giftSale));
        if (daySale > 0) {
            dDaySale(numberFormat.format(daySale));
        }
        if (menuSalePrice > 0) {
            weekSale(dayPrint, numberFormat.format(menuSalePrice));
        }
        if (specialSale > 0) {
            specialSale(numberFormat.format(specialSale));
        }
        if (giftSale > 0) {
            giftSale(numberFormat.format(giftSale));
        }
        return true;
    }

    public void totalPriceCheck(Integer price) {
        if (price == 0) {
            printlnOut("없음");
        }
    }

    public void resultPrice(String resultPrice) {
        printlnOut("");
        printlnOut("<할인 후 예상 결제 금액>");
        printlnOut(resultPrice + OutputMessage.WON.getMessage());
    }

    public void grade(String grade) {
        printlnOut("");
        printlnOut("<12월 이벤트 배지>");
        printlnOut(grade);
    }

    private void printlnOut(String message) {
        System.out.println(message);
    }
}
