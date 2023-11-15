package christmas.controller;

import christmas.common.util.GiftUtil;
import christmas.common.util.MenuItemUtil;
import christmas.domain.MenuList;
import christmas.domain.VisitDay;
import christmas.service.ChristmasService;
import christmas.service.MemberGradeService;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.text.NumberFormat;

public class ChristmasController {

    private final InputView inputView;
    private final OutputView outputView;
    private final ChristmasService christmasService;
    private VisitDay visitDay;
    private Integer totalPrice;

    private Integer totalSalePrice;
    private MenuList menuList;
    private GiftUtil giftMenu;
    private NumberFormat numberFormat = NumberFormat.getInstance();

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
        giftMenu();
        saleList();
        totalSale();
        resultPrice();
        memberGrade();
    }

    private void memberGrade() {
        MemberGradeService memberGradeService = new MemberGradeService();
        String grade = memberGradeService.getGrade(totalSalePrice);
        outputView.grade(grade);
    }

    private void resultPrice() {
        outputView.resultPrice(numberFormat.format((totalPrice-totalSalePrice)));
    }

    private void totalSale() {
        outputView.totalSale(numberFormat.format(totalSalePrice));
    }

    private void start() {
        outputView.start();
        visitDay = inputView.inputDay();
    }

    private void setMenu() {
        outputView.setMenu();
        menuList = inputView.inputMenu();
        outputView.eventCommentStart(visitDay.getDay());
    }

    private void startMenu() {
        outputView.orderMenuCheck();
        christmasService.getMenuList(menuList, outputView);
    }

    private void beforeSalePrice() {
        outputView.beforeSaleComment();

        totalPrice = christmasService.getPrice(menuList);
        outputView.beforeSalePrice(numberFormat.format(totalPrice));
    }

    private void giftMenu() {
        outputView.giftMenuComment();
        giftMenu = christmasService.getGiftMenu(totalPrice);
        outputView.giftMenu(giftMenu.getGift());
    }

    private void saleList() {
        Integer daySale = visitDay.getSalePrice();
        Integer specialSale = visitDay.specialDaySale();

        boolean isWeekday = christmasService.isWeekday(visitDay);
        Integer menuSalePrice = christmasService.getMenuSalePrice(menuList, isWeekday);
        Integer giftSale = getGiftSalePrice();
        String dayPrint = "주말";
        if (isWeekday) {
            dayPrint = "평일";
        }
        totalSalePrice = daySale + specialSale + specialSale + giftSale;
        outputView.saleCheckAndPrice(daySale, specialSale, dayPrint, menuSalePrice, giftSale, numberFormat);
    }

    private Integer getGiftSalePrice() {
        Integer giftSale = 0;
        if (giftMenu.equals(GiftUtil.MENU)) {
            giftSale = MenuItemUtil.CHAMP.getPrice();
        }
        return giftSale;
    }
}
