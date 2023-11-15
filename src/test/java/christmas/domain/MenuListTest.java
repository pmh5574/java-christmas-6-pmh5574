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
}