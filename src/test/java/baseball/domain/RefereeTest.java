package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RefereeTest {
    // 중복인 친구들 관리
    private Referee referee;
    private static final List<Integer> ANSWER = Arrays.asList(1, 2, 3);

    // 중복 관리 하지만 아래 4개 테스트에는 서로 다른 referee가 사용됨 와대박
    @BeforeEach
    void setUp() {
        referee = new Referee();
        ;
    }

    // 이 아래에 중복되는게 싫다! 하면 이 아래 어노테이션..?을 확인해보세요
    @ParameterizedTest
    @CsvSource({"1,2,3,0볼 3스트라이크", "7,8,9,낫싱", "2,3,1,3볼 0스트라이크", "1,3,2,2볼 1스트라이크"})
    public void compare(int number1, int number2, int number3, String expected) {
        String actual = referee.compare(ANSWER, Arrays.asList(number1, number2, number3));
        assertThat(actual).isEqualTo(expected);
    }


}