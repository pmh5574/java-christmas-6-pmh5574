package christmas.domain;

import static christmas.common.util.MenuListUtil.FIRST;
import static christmas.common.util.MenuListUtil.ZERO;

import christmas.common.Validation;
import christmas.common.util.MenuItemUtil;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MenuList {

    private final List<Map<Menu, Count>> menuList;


    public MenuList(String strMenuList) {
        List<String> menuItems = Arrays.asList(strMenuList.split(","));

        Validation.zeroCheck(menuItems.size());

        Set<Menu> uniqueMenus = new HashSet<>();

        this.menuList = menuItems.stream()
                .map(this::parseMenuItem)
                .filter(parsedItem -> duplicate(parsedItem, uniqueMenus))
                .toList();
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

        String menuName = parts[ZERO.getNumber()];
        Count count = new Count(parts[FIRST.getNumber()]);

        Validation.isValidMenu(menuName);

        Menu menu = new Menu(MenuItemUtil.fromName(menuName));
        return Map.of(menu, count);
    }

    public int getMenuListSize() {
        return menuList.size();
    }

    public List<Map<Menu, Count>> getMenuList() {
        return menuList;
    }
}
