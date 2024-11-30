import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        int sum = 0;

        for(int i = 0; i<s.length();i++){
            sum += s.charAt(i) - '0';  // 아스키 코드를 숫자로 변환
        }

        System.out.println(sum);
    }
}
