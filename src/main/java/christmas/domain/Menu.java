package christmas.domain;

import static christmas.common.util.MenuItemUtil.BBQ;
import static christmas.common.util.MenuItemUtil.CAKE;
import static christmas.common.util.MenuItemUtil.C_PASTA;
import static christmas.common.util.MenuItemUtil.H_PASTA;
import static christmas.common.util.MenuItemUtil.TBONE;

import christmas.common.Validation;
import christmas.common.util.MenuItemUtil;
import java.util.Objects;

public class Menu {

    private final String menu;

    public Menu(String menu) {
        validate(menu);
        this.menu = menu;
    }

    private void validate(String menu) {
        Validation.blankCheck(menu);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Menu menu1)) {
            return false;
        }
        return Objects.equals(menu, menu1.menu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menu);
    }

    @Override
    public String toString() {
        return menu;
    }

    public boolean isSaleMenu(boolean isWeekday) {
        if (isWeekday) {
            return menu.equals(CAKE.getName()) || menu.equals(MenuItemUtil.ICE.getName());
        }
        return menu.equals(TBONE.getName())
                || menu.equals(BBQ.getName())
                || menu.equals(H_PASTA.getName())
                || menu.equals(C_PASTA.getName());
    }
}
