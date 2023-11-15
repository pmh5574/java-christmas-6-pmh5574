package christmas.service;

import christmas.domain.Count;
import christmas.domain.Menu;
import christmas.domain.MenuList;
import christmas.view.OutputView;
import java.util.Map;

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
}
