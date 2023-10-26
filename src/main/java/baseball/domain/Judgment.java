package baseball.domain;

import java.util.List;

public class Judgment {
    /*
    * 몇 개 맞았는지 확인하는 함수 */
    public int correctCount(List<Integer> computer, List<Integer> player) {
        int result = 0;
        for (int i = 0; i < computer.size(); i++) {
            int playerNumber = player.get(i);
            if (computer.contains(playerNumber)) {
                result++;
            }
        }
        return result;
    }

    /*
    * 리스트, 인덱스, 숫자가 입력으로 들어오고
    * 리스트의 인덱스가 입력의 숫자와 같은지 확인해주는 함수
    * placeIndex자리에 number가 있다면 true 리턴
    * */
    public boolean hasPlace(List<Integer> computer, int placeIndex, int number) {
        /* List의 .get 함수:
        index를 넣으면 그 값을 리턴함
        그래서 변수명을 placeNumber에서 place Intex로 변경함*/
        return computer.get(placeIndex) == number;
    }
}
