package christmas.domain;

import christmas.common.Validation;
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
}
