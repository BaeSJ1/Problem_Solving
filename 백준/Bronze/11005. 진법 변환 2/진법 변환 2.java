import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 10진수 숫자와 변환할 진법 입력
        int decimal = sc.nextInt();
        int base = sc.nextInt();

        // 결과 출력
        System.out.println(convertToBase(decimal, base));
    }

    // 10진수를 N진법으로 변환하는 함수
    public static String convertToBase(int decimal, int base) {
        StringBuilder result = new StringBuilder();

        // 0일 경우 바로 반환
        if (decimal == 0) {
            return "0";
        }

        // 10 이상의 숫자는 알파벳으로 표현
        char[] digits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

        // N진법으로 변환
        while (decimal > 0) {
            result.append(digits[decimal % base]); // 나머지를 결과에 추가
            decimal /= base;                       // 몫을 업데이트
        }

        // 거꾸로 계산했으므로 뒤집기
        return result.reverse().toString();
    }
}