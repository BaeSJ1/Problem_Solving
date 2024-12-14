import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        int[] money = {25, 10, 5, 1};
        for (int t = 0; t < testcase; t++) {
            int c = sc.nextInt(); // 거스름돈
            for(int i = 0; i < 4; i++) {
                int cnt = c / money[i];
                if (cnt == 0){
                    System.out.print(0 + " ");
                } else{
                    System.out.print(cnt + " ");
                }
                c %= money[i];
            }
            System.out.println();
        }
    }
}
