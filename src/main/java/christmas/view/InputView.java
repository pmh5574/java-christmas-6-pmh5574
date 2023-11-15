package christmas.view;

import static christmas.common.message.ErrorMessage.NOT_USE_VISIT_DAY;

import camp.nextstep.edu.missionutils.Console;
import christmas.common.Validation;
import christmas.domain.MenuList;
import christmas.domain.VisitDay;

public class InputView {

    private String input;
    private VisitDay visitDay;
    private MenuList menuList;

    public VisitDay inputDay() {

        while (true) {
            try {
                input = Console.readLine().trim();
                Validation.onlyNumber(input, NOT_USE_VISIT_DAY.getMessage());
                visitDay = new VisitDay(Integer.parseInt(input));
                break;
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return visitDay;
    }

    public MenuList inputMenu() {

        while (true) {
            try {
                input = Console.readLine().trim();
                menuList = new MenuList(input);
                break;
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return menuList;
    }
}
