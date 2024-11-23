import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static final int MAX = 1000000;

    public static void main(String[] args) {
        boolean[] check = new boolean[MAX + 1]; // 0 ~ MAX 까지
        ArrayList<Integer> primes = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);

        // 에라토스테네스의 체
        check[0] = check[1] = true;

        // primes 배열에 소수 값들 저장
        for (int i = 2; i * i <= MAX; i++) {
            if (!check[i]) {
                primes.add(i);
                for (int j = i * i; j <= MAX; j += i) {
                    check[j] = true;
                }
            }
        }

        while (true) {
            int n = sc.nextInt();
            if (n == 0) break;
            for (int i=1; i<primes.size(); i++){
                int a = primes.get(i);
                if(check[n - a] == false && a % 2 != 0){
                    System.out.println(n + " = " + a + " + " + (n - a));
                    break;
                }
            }

        }

    }
}
