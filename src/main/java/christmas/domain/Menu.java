package christmas.domain;

import christmas.common.Validation;

public class Menu {

    private final String menu;

    public Menu(String menu) {
        validate(menu);
        this.menu = menu;
    }

    private void validate(String menu) {
        Validation.blankCheck(menu);
    }
}
