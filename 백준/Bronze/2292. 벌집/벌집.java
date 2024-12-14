import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;
        int number = 1;
        if (n == 1) {
            System.out.println(1);
        } else {
            while (number < n) {
                cnt++;
                number += 6 * cnt;
            }
            System.out.println(cnt + 1);
        }
    }
}
