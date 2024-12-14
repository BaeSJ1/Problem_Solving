import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();

        StringBuilder result = new StringBuilder();

        while (n > 0) {
            int value = n % b;
            if (value < 10) {
                result.append((char) (value + '0'));
            } else {
                result.append((char) (value - 10 + 'A'));
            }
            n /= b;
        }
        System.out.println(result.reverse().toString());
    }
}
