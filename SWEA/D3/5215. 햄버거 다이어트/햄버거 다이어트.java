import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/***
 * 완전탐색 (dfs, 백트래킹)
 * 참고: 부분집합이나 조합은 대부분 visited 필요없고, idx로 구분하는 방법을 사용한다!
 * 재료를 선택하는 경우와 선택하지 않은 경우로 구분
 */

public class Solution{
    static class Food{
        int score;
        int cal;
        public Food(int score, int cal){
            this.score = score;
            this.cal = cal;
        }
    }

    static Food[] foods;
    static int n, l;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for(int t = 1; t <= tc; t++){
            result = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());

            foods = new Food[n];

            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                foods[i] = new Food(s, c);
            }

            dfs(0, 0, 0);
            System.out.println("#" + t + " " + result);
        }

    }

    /***
     *
     * @param idx : 인덱스
     * @param scoreSum: 점수 합
     * @param calSum: 칼로리 합
     */
    static void dfs(int idx, int scoreSum, int calSum){
        // 칼로리를 초과하면 안됨. -> 백트래킹
        if(calSum > l) return;

        // 마지막 재료(마지막 depth임)까지 탐색한 경우 -> 점수 갱신
        if(idx == n){
            result = Math.max(result, scoreSum);
            return;
        }

        // 재료를 선택하는 경우
        dfs(idx + 1, scoreSum + foods[idx].score, calSum + foods[idx].cal);


        // 재료를 선택하지 않는 경우
        dfs(idx + 1, scoreSum, calSum);
    }
}