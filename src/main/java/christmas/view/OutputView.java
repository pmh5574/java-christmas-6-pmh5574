package christmas.view;

import christmas.common.message.OutputMessage;

public class OutputView {

    public void start() {
        printlnOut(OutputMessage.START.getMessage());
    }

    public void setMenu() {
        printlnOut(OutputMessage.SET_MENU.getMessage());
    }

    private void printlnOut(String message) {
        System.out.println(message);
    }
}
