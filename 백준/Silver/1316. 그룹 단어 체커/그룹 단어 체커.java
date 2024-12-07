import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (checkStr(br.readLine())) {  // 문자열이 그룹단어면,
                count++;  // 개수를 센다.
            }
        }
        br.close();
        System.out.println(count);
    }

    static boolean checkStr(String s) {
        boolean[] checkAlpha = new boolean[26];
        int prev = -1;  // 이전 문자의 인덱스 값을 저장

        for (int i = 0; i < s.length(); i++) {
            int now = s.charAt(i);  // 현재 문자의 아스키코드
            if (prev != now) {  // 이전 문자와 i번째 문자가 같지 않다면
                if (!checkAlpha[now - 'a']) {  // 앞에서 나온 문자인지 체크한다. 체크되지 않은 곳이면,
                    checkAlpha[now - 'a'] = true;  // 체크하고
                    prev = now;  // 이전 인덱스를 현재 인덱스로 변경한다.
                } else {
                    return false;
                }
            } else continue; // 이전 문자와 현재 문자가 같다면 계속 반복
        }
        return true;
    }
}
