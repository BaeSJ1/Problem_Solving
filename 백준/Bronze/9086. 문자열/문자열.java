import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // 버퍼에 남은 줄바꿈 문자 제거
        for (int i = 0; i < t; i++) {
            String s = sc.nextLine();
            char[] arr = s.toCharArray();
            System.out.println(arr[0]+""+arr[arr.length - 1]);
        }
    }
}
