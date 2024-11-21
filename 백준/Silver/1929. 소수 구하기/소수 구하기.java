import java.util.Scanner;

public class Main {
    static final int MAX = 1000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long[] prime = new long[MAX];
        boolean[] check = new boolean[MAX];

        int pn = 0;
        int m = sc.nextInt();
        int n = sc.nextInt();

        for (int i = 2; i <= n; i++) {
            if (!check[i]) {
                prime[pn++] = i;
                for (int j = i * 2; j <= n; j += i) {  //i의 배수를 지운다.
                    check[j] = true;
                }
            }
        }
        for (int i = 0; i < pn; i++) {
            if(prime[i] < m) continue;
            System.out.println(prime[i]);
        }
    }
}
