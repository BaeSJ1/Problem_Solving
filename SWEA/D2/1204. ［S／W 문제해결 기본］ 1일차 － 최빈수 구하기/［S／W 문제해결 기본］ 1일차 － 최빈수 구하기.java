import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            int testNum = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] count = new int[101];
            for (int i = 0; i < 1000; i++) {
                int score = Integer.parseInt(st.nextToken());
                count[score]++;
            }

            // 가장 많은 횟수 구하기
            int maxCnt = 0;
            int result = 0;

            for (int score = 0; score <= 100; score++) {
                if (count[score] > maxCnt || (count[score] == maxCnt && score > result)) {
                    maxCnt = count[score];
                    result = score;
                }
            }

            System.out.println("#" + testNum + " " + result);
        }

    }
}