package christmas.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class VisitDayTest {

    @Test
    @DisplayName("0이하면 오류")
    void test() {
        assertThatThrownBy(() -> new VisitDay(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }

    @Test
    @DisplayName("32이상이면 오류")
    void test2() {
        assertThatThrownBy(() -> new VisitDay(32))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }
}
