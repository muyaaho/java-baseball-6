package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RefereeTest {
    // 중복인 친구들 관리
    private Referee referee;
    private static final List<Integer> ANSWER = Arrays.asList(1,2,3);

    // 중복 관리 하지만 아래 4개 테스트에는 서로 다른 referee가 사용됨 와대박
    @BeforeEach
    void setUp() {
        referee = new Referee();
;    }

    @Test
    void 스트라이크3() {
        String result = referee.compare(ANSWER, Arrays.asList(1,2,3));
//        System.out.println(result);
        /*컴퓨터에게 맞김 너가 맞는지 아닌지 봐줘
        * assertThat
        * isEqualTo*/
        assertThat(result).isEqualTo("0볼 3스트라이크");

    }

    @Test
    void 낫싱() {
        String result = referee.compare(ANSWER, Arrays.asList(7,8,9));
        assertThat(result).isEqualTo("낫싱");
    }

    @Test
    void 볼() {
        String result = referee.compare(ANSWER, Arrays.asList(2,3,1));
        assertThat(result).isEqualTo("3볼 0스트라이크");

    }

    /* 대박신기하다 */
    @Test
    void 볼2_스트라이크1() {
        Referee referee = new Referee();
        String result = referee.compare(ANSWER, Arrays.asList(1,3,2));
        assertThat(result).isEqualTo("2볼 1스트라이크");

    }


}