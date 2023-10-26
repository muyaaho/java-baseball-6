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
 *
 * computer, player는 리스트로 관리됨
 * */
public class Application {
    public static void main(String[] args) {
        // generator가 computer 랜덤 수를 만들어 줌
        final NumberGenerator generator = new NumberGenerator();
        final List<Integer> computer = generator.createRandomNumbers();


        final Referee referee = new Referee();

        String result = "";
        // while 조건 들어갈 때부터 '0볼 3스트라이크'가 나오진 않으니까
        while (!result.equals("0볼 3스트라이크")){
            result = referee.compare(computer, askNumbers());

            // 0볼 3스트라이크? 가 돼야지 게임이 끝남?
            System.out.println(result);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

    }

    /*
    * 사용자에게 물어보고 그 값을 리스트로 받아서 리턴함
    *
    * static: 정적 메소드
    * main에서 askNumber를 객체를 만들지 않고 바로 쓰려면 static으로 만들어야 됨*/
    public static List<Integer> askNumbers(){
        System.out.print("숫자를 입력해 주세요: ");
        final Scanner scanner = new Scanner(System.in);
        final String player = scanner.next();

        // input 받은 String을 쪼개서 int로 바꿔서 다시 배열에 집어넣어 리턴함
        List<Integer> list_numbers = new ArrayList<>();
        // for-each문 - python range안쓰는 거랑 비슷함, player.split("") 한 값 하나하나가 String number
        //              로 for문 안에 들어감
        for (String number: player.split("")) {
            list_numbers.add(Integer.valueOf(number));
        }
        return list_numbers;
    }
}
