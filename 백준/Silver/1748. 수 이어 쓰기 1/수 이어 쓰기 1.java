import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int len = Integer.toString(n).length();  // n의 자릿수
        int result = 0;
        int a;
        int b = 0;

        for (int i = 1; i <= len; i++) {
            if (len == 1) break;
            a = (int) (9 * Math.pow(10, i - 1));
            if (i != len) {
                result += i * a;
                b += a;
            } else {
                result += i * (n - b);
            }
        }
        System.out.println(len == 1 ? n : result);
    }
}
