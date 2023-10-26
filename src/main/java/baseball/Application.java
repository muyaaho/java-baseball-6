package baseball;

import baseball.domain.NumberGenerator;
import baseball.domain.Referee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/* 객체지향 프로그래밍
 * 기능을 가지고 있는 클래스를 인스턴스화(=객체, object) 한다.
 * 필요한 기능을 (역할에 맞는) 인스턴스가 수행하게 한다.(의인화)
 * 각 결과를 종합한다.(프로그램을 동작시킨다)
 * */
public class Application {
    public static void main(String[] args) {
        final NumberGenerator generator = new NumberGenerator();
        final List<Integer> computer = generator.createRandomNumbers();


        final Referee referee = new Referee();

        String result = "";
        while (!result.equals("0볼 3스트라이크")){
            result = referee.compare(computer, askNumbers());

            // 0볼 0스트라이크? 가 되야지 게임이 끝남?
            System.out.println(result);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

    }

    public static List<Integer> askNumbers(){
        System.out.print("숫자를 입력해 주세요: ");
        final Scanner scanner = new Scanner(System.in);
        final String player = scanner.next();

        List<Integer> numbers = new ArrayList<>();
        for (String number: player.split("")) {
            numbers.add(Integer.valueOf(number));
        }
        return numbers;
    }
}
