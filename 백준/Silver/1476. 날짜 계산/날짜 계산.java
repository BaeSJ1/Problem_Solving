import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int E = sc.nextInt() - 1;  // 1 ~ 15, years = 16이면, E = 1이어야함.
        int S = sc.nextInt() - 1;  // 1 ~ 28
        int M = sc.nextInt() - 1;  // 1 ~ 19

        int year = 0;
        while(true){
            if (year % 15 == E && year % 28 == S && year % 19 == M){
                System.out.println(year + 1);
                break;
            }
            year++;
        }


    }
}
