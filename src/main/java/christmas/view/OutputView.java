package christmas.view;

import christmas.common.message.OutputMessage;

public class OutputView {

    public void start() {
        printlnOut(OutputMessage.START.getMessage());
    }

    private void printlnOut(String message) {
        System.out.println(message);
    }
}
