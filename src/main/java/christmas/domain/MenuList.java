package christmas.domain;

import static christmas.common.message.ErrorMessage.NOT_USE_MENU;
import static christmas.common.util.MenuListUtil.FIRST;
import static christmas.common.util.MenuListUtil.ZERO;

import christmas.common.Validation;
import christmas.common.message.ErrorMessage;
import christmas.common.util.MenuItemUtil;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MenuList {

    private final List<Map<Menu, Count>> menuList;
    private Integer totalCount = 0;
    private int menuChecks = 0;

    public MenuList(String strMenuList) {
        List<String> menuItems = Arrays.asList(strMenuList.split(","));

        Validation.zeroCheck(menuItems.size(), NOT_USE_MENU.getMessage());

        Set<Menu> uniqueMenus = new HashSet<>();

        this.menuList = menuItems.stream()
                .map(this::parseMenuItem)
                .filter(parsedItem -> duplicate(parsedItem, uniqueMenus))
                .toList();
        Validation.zeroCheck(menuChecks, ErrorMessage.NO_ONLY_DIRNK.getMessage());
    }

    private static boolean duplicate(Map<Menu, Count> parsedItem, Set<Menu> uniqueMenus) {
        Menu menu = parsedItem.keySet()
                .iterator()
                .next();

        Validation.duplicateMenu(uniqueMenus.add(menu));

        return true;
    }

    private Map<Menu, Count> parseMenuItem(String menuItem) {
        String[] parts = menuItem.split("-");
        Validation.notMatchMenu(parts);

        onlyDrinkCheck(parts);

        String menuName = parts[ZERO.getNumber()];
        Count count = new Count(parts[FIRST.getNumber()]);
        totalCount += count.getCount();

        Validation.limitCount(totalCount);
        Validation.isValidMenu(menuName);

        Menu menu = new Menu(MenuItemUtil.fromName(menuName));
        return Map.of(menu, count);
    }

    private void onlyDrinkCheck(String[] parts) {
        Set<String> allowedMenus = Set.of("양송이수프", "타파스", "시저샐러드", "티본스테이크", "바비큐립", "해산물파스타", "크리스마스파스타", "초코케이크", "아이스크림");

        for(String allowedMenu: allowedMenus) {
            if (allowedMenu.equals(parts[ZERO.getNumber()])) {
                menuChecks += 1;
            }
        }
    }

    public int getMenuListSize() {
        return menuList.size();
    }

    public List<Map<Menu, Count>> getMenuList() {
        return menuList;
    }
}
