import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().trim();
        int cnt = 0;
        // 공백만 있거나 빈 문자열일 경우
        if (s.isEmpty()) {
            System.out.println(0);
        } else {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ' ') {
                    cnt++;
                }
            }
            System.out.println(cnt + 1); // 단어 개수 출력
        }
    }
}
