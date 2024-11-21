
import java.util.Scanner;

public class Main {
    static boolean prime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int result = 0;
        while (n-- > 0) {
            int data = sc.nextInt();
            if (prime(data)) {
                result++;
            }
        }
        System.out.println(result);
    }
}
