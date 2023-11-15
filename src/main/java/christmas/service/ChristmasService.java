package christmas.service;

import static christmas.common.util.MenuListUtil.GIFT_PRICE;
import static christmas.common.util.MenuListUtil.SALE_PRICE;
import static christmas.common.util.MenuListUtil.TEN;
import static christmas.common.util.MenuListUtil.ZERO;

import christmas.common.util.DayUtil;
import christmas.common.util.GiftUtil;
import christmas.common.util.MenuItemUtil;
import christmas.domain.Count;
import christmas.domain.Menu;
import christmas.domain.MenuList;
import christmas.domain.VisitDay;
import christmas.view.OutputView;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class ChristmasService {
    public void getMenuList(MenuList menuList, OutputView outputView) {
        menuList.getMenuList()
                .forEach(menuCountMap -> {
                    getMenu(menuCountMap, outputView);
                });
    }

    private static void getMenu(Map<Menu, Count> menuMap, OutputView outputView) {
        menuMap.forEach((outputView::printMenuList));
    }

    public Integer getPrice(MenuList menuList) {

        AtomicInteger totalPrice = new AtomicInteger(0);
        menuList.getMenuList()
                .forEach(menuMap -> {
                    getTotalPrice(totalPrice, menuMap);
                });
        return totalPrice.get();
    }

    private static void getTotalPrice(AtomicInteger totalPrice, Map<Menu, Count> menuMap) {
        menuMap.forEach((menu, count) -> {
            Integer price = MenuItemUtil.fromPrice(menu.toString());

            if (price != null) {
                totalPrice.addAndGet(price * count.getCount());
            }
        });
    }

    public GiftUtil getGiftMenu(Integer totalPrice) {
        if (totalPrice >= GIFT_PRICE.getNumber()) {
            return GiftUtil.MENU;
        }
        return GiftUtil.NO;
    }

    public Integer getMenuSalePrice(MenuList menuList, boolean isWeekday) {
        AtomicInteger salePrice = new AtomicInteger(0);

        menuList.getMenuList()
                .forEach(menuCountMap -> {
                    setMenuSalePrice(isWeekday, salePrice, menuCountMap);
                });
        return salePrice.get();
    }

    private void setMenuSalePrice(boolean isWeekday, AtomicInteger salePrice, Map<Menu, Count> menuCountMap) {
        menuCountMap.forEach((menu, count) -> {
            boolean saleMenu = menu.isSaleMenu(isWeekday);
            if (saleMenu) {
                salePrice.addAndGet(count.getCount() * SALE_PRICE.getNumber());
            }
        });
    }

    public boolean isWeekday(VisitDay visitDay) {
        String day = addDateZero(visitDay.getDay());
        LocalDate date = LocalDate.parse(DayUtil.NOW_YEAR_MONTH.getMessage(day), DateTimeFormatter.ISO_LOCAL_DATE);

        DayOfWeek dayOfWeek = date.getDayOfWeek();

        boolean isWeekday = weekDayCheck(dayOfWeek);
        return isWeekday;
    }

    private boolean weekDayCheck(DayOfWeek dayOfWeek) {
        return dayOfWeek != DayOfWeek.SATURDAY && dayOfWeek != DayOfWeek.FRIDAY;
    }

    private String addDateZero(int number) {
        if (number >= ZERO.getNumber() && number < TEN.getNumber()) {
            return ZERO.getNumber().toString() + number;
        }

        return String.valueOf(number);
    }
}
