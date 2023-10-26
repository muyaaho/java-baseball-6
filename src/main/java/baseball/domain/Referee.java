package baseball.domain;

import java.util.List;

public class Referee {

    public String compare(List<Integer> computer, List<Integer> player) {
        // 몇 개의 숫자가 같은지 알아낸 뒤 -> judgment가 하는 일(correctCount)
        // 스트라이크의 개수를 구해 뺀다.
        // 남은 수는 볼의 개수이다.
        final Judgment judgment = new Judgment();
        int correctCount = judgment.correctCount(computer, player);

        int strike = 0;
        for (int placeIndex = 0; placeIndex<player.size(); placeIndex++){   // 3만큼 반복
            // placeIndex자리에 player[i]번째 숫자가 있으면 그 자리에 그 수가 있으므로 strike ++
            if (judgment.hasPlace(computer, placeIndex, player.get(placeIndex))){
                strike++;
            }
        }

        int ball = correctCount - strike;

        if (correctCount == 0){
            return "낫싱";
        }
        return ball+"볼 "+strike+"스트라이크";
    }
}
