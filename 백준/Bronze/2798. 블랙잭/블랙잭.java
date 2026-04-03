import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] cards = new int[n];

        for (int i = 0; i < n; i++) {
            cards[i] = sc.nextInt();
        }

        int max = 0;
        for (int i = 0; i < n - 2; i++) {
            int a = cards[i];
            for (int j = 1; j < n - 1; j++) {
                int b = cards[j];
                for (int k = 2; k < n; k++) {
                    int c = cards[k];
                    if (i == j || j == k || i == k) continue;
                    int result = a + b + c;
                    if(result <= m){
                        max = Math.max(max, result);
                    }
                }
            }
        }
        System.out.println(max);

    }
}