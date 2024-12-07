import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();  // 테스트케이스 개수
        int groupWord = 0;  // 그룹 단어가 몇개 있는지 총 개수 세기

        for (int tc = 0; tc < testCase; tc++) {
            String s = sc.next();
            boolean check = true;  // 하나의 문자열 검사할 때, 문자열의 각 문자 겹치는거 없으면 true 고, 겹치는게 있다면 false 로 바로 멈춘다.
            for (int i = 0; i < s.length(); i++) {
                // 문자 하나 일때와, 문자열이 동일한 하나의 문자로 이루어져 있을 경우 예외 처리 필요
                if(!check) break; // 그룹 단어 아니라고 판명나면 바로 멈춤
                if (i + 1 < s.length()) {
                    if (s.charAt(i) == s.charAt(i + 1)) {
                        continue;
                    } else {
                        for (int j = i + 1; j < s.length(); j++) {
                            if (s.charAt(i) == s.charAt(j)) {
                                check = false;
                                break;
                            } else {
                                check = true;
                            }
                        }
                    }
                }
            }
            if (check) {  // 그룹 단어 맞으면
                groupWord++;
            }
        }
        System.out.println(groupWord);
    }
}
