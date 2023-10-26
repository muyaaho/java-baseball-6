package baseball.domain;

public class Calculator {
    // 클래스에서 안에서 존재하는 변수: 인스턴스 변수
    // public: 외부에서 접근할 수 있는 변수
    // add 안에 선언하면 add 안에만 살아있음
    public int result;  // 인스턴스 변수

    /* static
     * 객체를 생성했을 때 공유하게 됨, a객체, b객체 따로 만들어도 이 shareResult는 a,b 둘 다 공유됨!
     * 굳이 인스턴스명 사용하지 않고 [클래스.shareResult](클래스 이름으로 접근) 가능*/
    public static int shareResult = 0;      // 클래스 변수 - 소문자시작하고 대문자 붙이기

    /* final
     * 쉐어는 하고싶은데 변경은 싫어(불변으로 만들고 싶어)*/
    public static final int SHARE_BIRTHDAY = 1234;  // 클래스 변수 + final = 상수 - 전부다 대문자로 작성(띄어쓰기 _), 클래스 변수인데 변하지 않는 값

    public Calculator() {
    }

    public int add(int n1, int n2) {
        result = n1 + n2;
        return result;
    }
}
