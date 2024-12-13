import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 받기
        String N = sc.next();  // N진법 수
        int B = sc.nextInt();  // 진법

        // 10진수 값 계산
        int decimalValue = 0;
        int power = 1;  // B^0부터 시작

        // 뒤에서부터 순회하며 계산
        for (int i = N.length() - 1; i >= 0; i--) {
            char digit = N.charAt(i);
            int value;

            if ('0' <= digit && digit <= '9') {  // 숫자인 경우
                value = digit - '0';
            } else {  // 알파벳인 경우
                value = digit - 'A' + 10;
            }

            // 현재 자리값을 결과에 더하기
            decimalValue += value * power;
            power *= B;  // 진법의 거듭제곱 증가
        }

        // 결과 출력
        System.out.println(decimalValue);
    }
}
