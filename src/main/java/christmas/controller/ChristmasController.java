package christmas.controller;

import christmas.common.util.DayUtil;
import christmas.common.util.GiftUtil;
import christmas.common.util.MenuItemUtil;
import christmas.common.util.PriceUtil;
import christmas.domain.MenuList;
import christmas.domain.VisitDay;
import christmas.service.ChristmasService;
import christmas.service.MemberGradeService;
import christmas.service.SalePriceService;
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
    private MemberGradeService memberGradeService;

    public ChristmasController(InputView inputView, OutputView outputView, ChristmasService christmasService, MemberGradeService memberGradeService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.christmasService = christmasService;
        this.memberGradeService = memberGradeService;
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
        String dayPrint = DayUtil.WEEK.getMessage();
        if (isWeekday) {
            dayPrint = DayUtil.NO_WEEK.getMessage();
        }
        totalSalePrice = daySale + specialSale + specialSale + giftSale;
        outputView.saleComment();

        SalePriceService salePriceService = new SalePriceService();
        salePriceService.saleCheckAndPrice(daySale, specialSale, dayPrint, menuSalePrice, giftSale, numberFormat, totalPrice, outputView);
    }

    private Integer getGiftSalePrice() {
        Integer giftSale = PriceUtil.ZERO.getNumber();
        if (giftMenu.equals(GiftUtil.MENU)) {
            giftSale = MenuItemUtil.CHAMP.getPrice();
        }
        return giftSale;
    }
}
