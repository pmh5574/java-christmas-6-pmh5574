package christmas.service;

import static christmas.common.util.MenuListUtil.GIFT_PRICE;

import christmas.common.util.GiftUtil;
import christmas.common.util.MenuItemUtil;
import christmas.domain.Count;
import christmas.domain.Menu;
import christmas.domain.MenuList;
import christmas.view.OutputView;
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

    public String getGiftMenu(Integer totalPrice) {
        if (totalPrice >= GIFT_PRICE.getNumber()) {
            return GiftUtil.MENU
                    .getGift();
        }
        return GiftUtil.NO
                .getGift();
    }
}
