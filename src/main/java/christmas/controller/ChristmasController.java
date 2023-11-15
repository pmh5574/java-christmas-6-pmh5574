package christmas.controller;

import christmas.domain.MenuList;
import christmas.domain.VisitDay;
import christmas.service.ChristmasService;
import christmas.view.InputView;
import christmas.view.OutputView;

public class ChristmasController {

    private final InputView inputView;
    private final OutputView outputView;
    private final ChristmasService christmasService;
    private VisitDay visitDay;

    private MenuList menuList;

    public ChristmasController(InputView inputView, OutputView outputView, ChristmasService christmasService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.christmasService = christmasService;
    }

    public void run() {
        start();
        setMenu();
    }

    private void start() {
        outputView.start();
        visitDay = inputView.inputDay();
    }

    private void setMenu() {
        outputView.setMenu();
        menuList = inputView.inputMenu();
    }
}
