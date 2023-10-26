package baseball.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberGenerator {

    /*List
     * 자바에서 제공하는 컬렉션
     * int[] 대신*/
    public List<Integer> createRandomNumbers() {
        // 3개의 숫자가 담길 때까지
        // 만약 이미 존재하는 숫자라면 담지 않는다.
        // 만약 존재하지 않는 숫자라면 담는다.

        /* ArrayList
         * List의 실제 클래스*/
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < 3) {
            int number = new Random().nextInt(9) + 1;
            if (numbers.contains(number)) {
                continue;
            } else {
                numbers.add(number);
            }

        }

        return numbers;
    }
}
