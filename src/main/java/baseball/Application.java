package baseball;

import baseball.domain.Calculator;
import baseball.domain.Judgment;
import baseball.domain.NumberGenerator;
import baseball.domain.Referee;

import java.util.Arrays;
import java.util.List;


/* 객체지향 프로그래밍
 * 기능을 가지고 있는 클래스를 인스턴스화(=객체, object) 한다.
 * 필요한 기능을 (역할에 맞는) 인스턴스가 수행하게 한다.(의인화)
 * 각 결과를 종합한다.(프로그램을 동작시킨다)
 * */
public class Application {
    public static void main(String[] args) {
        final Referee referee = new Referee();
        final String result = referee.compare(Arrays.asList(7,8,9), Arrays.asList(1,2,3));
        System.out.println(result);
    }
}
