package christmas.domain;

import static christmas.common.util.MenuListUtil.FIRST;
import static christmas.common.util.MenuListUtil.ZERO;

import christmas.common.Validation;
import christmas.common.util.MenuItemUtil;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MenuList {

    private final List<Map<Menu, Count>> menuList;


    public MenuList(String strMenuList) {

        List<String> menuItems = Arrays.asList(strMenuList.split(","));

        Validation.zeroCheck(menuItems.size());

        this.menuList = menuItems.stream()
                .map(this::parseMenuItem)
                .collect(Collectors.toList());
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
}
