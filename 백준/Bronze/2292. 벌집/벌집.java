import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;
        int number = 1;
        while (true){
            if(n == 1){
                System.out.println(1);
                break;
            }
            cnt ++;
            number = number + 6 * cnt;
            if(number - 6 * cnt + 1 <= n && n <= number){
                System.out.println(cnt + 1);
                break;
            }
        }
    }
}
