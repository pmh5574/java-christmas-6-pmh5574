package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MenuListTest {

    @ParameterizedTest
    @ValueSource(strings = {"", ",", "양송이", "양송이-1"})
    @DisplayName("없는 메뉴, 빈값, 잘못된 형식일때 오류")
    void test(String param) {
        assertThatThrownBy(() -> new MenuList(param))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @Test
    @DisplayName("메뉴 두개 생성")
    void test2() {
        MenuList menuList = new MenuList("양송이수프-1,티본스테이크-2");

        assertThat(menuList.getMenuListSize()).isEqualTo(2);
    }

    @Test
    @DisplayName("메뉴 중복시 오류")
    void test3() {
        assertThatThrownBy(() -> new MenuList("양송이수프-1,티본스테이크-2,양송이수프-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @Test
    @DisplayName("메뉴 개수 최대 20개 넘으면 오류")
    void test4() {
        assertThatThrownBy(() -> new MenuList("양송이수프-20,티본스테이크-2,양송이수프-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 한 번에 최대 20개까지만 주문할 수 있습니다.");
    }

    @Test
    @DisplayName("음료만 주문시 오류")
    void test5() {
        assertThatThrownBy(() -> new MenuList("제로콜라-1,레드와인-1,샴페인-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 음료만 주문은 불가능합니다.");
    }
}