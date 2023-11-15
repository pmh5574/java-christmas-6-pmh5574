package christmas.view;

import static christmas.common.message.OutputMessage.EVENT_COMMENT_START;
import static christmas.common.message.OutputMessage.ORDER_MENU_CHECK;
import static christmas.common.message.OutputMessage.SET_MENU;
import static christmas.common.message.OutputMessage.START;

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

    public void printMenuList(Menu menu, Count count) {
        printlnOut(menu.toString() + " " + count.toString() + "개");
    }

    private void printlnOut(String message) {
        System.out.println(message);
    }


}
