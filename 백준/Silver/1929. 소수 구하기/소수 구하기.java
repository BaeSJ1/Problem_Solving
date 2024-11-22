import java.util.Scanner;

public class Main {
    static final int MAX = 1000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long[] primes = new long[MAX + 1]; // 0 ~ MAX 까지
        boolean[] check = new boolean[MAX + 1];

        int m = sc.nextInt();
        int n = sc.nextInt();

        // 배열 초기화
        for (int i = 2; i < MAX; i++) {
            check[i] = false; // 아직 방문 안함
        }

        check[0] = check[1] = true;

        int pn = 0;
        for (int i = 2; i * i <= MAX; i++) {
            if (!check[i]) {
                primes[pn++] = i;
                for (int j = i * i; j <= MAX; j += i) {
                    check[j] = true;
                }
            }
        }

        // m 이상 n 이하의 소수 출력
        for (int i = m; i <= n; i++) {
            if (!check[i] && i >= 2) {  // 소수이면서 2 이상일 때 출력
                System.out.println(i);
            }
        }
    }
}
