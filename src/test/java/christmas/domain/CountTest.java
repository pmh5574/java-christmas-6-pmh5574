package christmas.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CountTest {

    @ParameterizedTest
    @ValueSource(strings = {"0", ",", "", "-1"})
    @DisplayName("메뉴 0개 이하 일 때 오류")
    void test(String count) {
        assertThatThrownBy(() -> new Count(count))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }
}