import java.util.*;

class Solution {
    static final int MOD = 1_000_000_007;
    
    // 상, 하, 좌, 우
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};
    
    public int solution(int m, int n, int[][] puddles) {
        int result = calculateDp(m, n, puddles);
        return result;
    }
    
    static int calculateDp(int m, int n, int[][] puddles){
        // dp에 이동 할 수 있는 가지수 누적함.
        int[][] dp = new int[n + 1][m + 1];
        
        dp[1][1] = 1;
        
        boolean[][] water = new boolean[n + 1][m + 1];
        for(int[] p: puddles){
            water[p[1]][p[0]] = true;
        }
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(i == 1 && j == 1) continue;
                if(water[i][j]) dp[i][j] = 0;
                else{
                    // 왼쪽과 위쪽에서 오는 경우의 수 더하기
                    // 여기에 MOD 나머지 연산안하면 효율성에서 0점 나옴
                    dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % MOD;
                }
            }
        }
        return dp[n][m];
    }
}