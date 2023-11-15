package christmas.controller;

import christmas.domain.MenuList;
import christmas.domain.VisitDay;
import christmas.service.ChristmasService;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.text.NumberFormat;

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
        startMenu();
        beforeSalePrice();
    }

    private void start() {
        outputView.start();
        visitDay = inputView.inputDay();
    }

    private void setMenu() {
        outputView.setMenu();
        menuList = inputView.inputMenu();
        outputView.eventCommentStart();
    }

    private void startMenu() {
        outputView.orderMenuCheck();
        christmasService.getMenuList(menuList, outputView);
    }

    private void beforeSalePrice() {
        outputView.beforeSaleComment();

        NumberFormat numberFormat = NumberFormat.getInstance();

        Integer totalPrice = christmasService.getPrice(menuList);
        outputView.beforeSalePrice(numberFormat.format(totalPrice));
    }
}
