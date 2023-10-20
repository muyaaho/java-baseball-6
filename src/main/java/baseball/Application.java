/*
* 잘못된 값이 입력되었을 때
*
* 0을 입력해도 종료하나? 일단 예외로 하고 종료시킴. 테스트 해볼 때 0을 어떻게 처리할지 체크하기
* */

package baseball;

import java.util.Random;
import java.util.Scanner;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import static java.lang.Integer.parseInt;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 초기화

        Random rand = new Random();
        int end = 1;


        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean isFinish = false;
        // 게임 진행
        while (end == 1) {
            // 한 게임당 초기화
            String com = "";
            isFinish = false;

            while (com.length() < 3) {
                int r = Randoms.pickNumberInRange(1,9);
                String sr = Integer.toString(r);
                if (!com.contains(sr)) {     //리스트에 포함되지 않는다면 추가하고 실행
                    com = com + sr;
                }
            }
            //@@@@ 삭제해야 하는 코드
            System.out.println("answer: "+com);
            // 게임 시작

            // while (게임 진행되는 동안)
            while (!isFinish) {
                int strike = 0;
                int ball = 0;
                int canInt = 0;
                // 입력
                System.out.print("숫자를 입력해주세요 : ");
                Scanner sc = new Scanner(System.in);
                String num = sc.nextLine();
                // TODO: 이상한 입력 체크
                try {
                    //0이 들어올 경우
                    if (num.contains("0")) {
                        throw new Exception();
                    }
                    // 3자리 수가 아닌 경우
                    if (num.length() != 3) {
                        throw new Exception();
                    }

                    // 숫자가 아닌 경우
                    canInt = parseInt(num);
                }
                catch(Exception e){
                    throw new IllegalArgumentException("잘못된 값을 입력했습니다.");

                }


                // 잘못된 입력 3: 숫자가 아닌 경우
                // 비교
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (num.charAt(i) == com.charAt(j)) {
                            if (i == j) {
                                strike += 1;
                            } else {
                                ball += 1;
                            }
                        }
                    }
                }

                // 결과
                // 정답: 일단 나가기
                if (strike == 3) {
                    System.out.println("3스트라이크");
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    end = sc.nextInt();
                    // TODO: 잘못된 값 입력됬는지 확인!
                    try {
                        if (!(end == 1 || end == 2)) {
                            throw new Exception();
                        }

                    }catch (Exception e){
                        throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
                    }

                    isFinish = true;

                }
                else if (strike == 0 && ball == 0) {
                    System.out.println("낫싱");
                }
                else {
                    System.out.println(ball+"볼 "+strike+"스트라이크");
                }
                // 계속

            }

        }

    }
}
