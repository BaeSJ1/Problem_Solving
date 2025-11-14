import java.util.*;

// dp의 bottom-up 방식 사용
// [i][0] 이나 [i][m - 1] 부분은 비교 없어도 됨

class Solution {
    public int solution(int[][] triangle) {
        int result = calculateDp(triangle);
        return result;
    }
    
    static int calculateDp(int[][] tri){
        int n = tri.length;
        int m = tri[n - 1].length;
        
        int[][] dp = new int[n][m];
        dp[0][0] = tri[0][0];
        
        for(int i = 1; i < n; i++){
            for(int j = 0; j <= i; j++){
                if(j == 0){
                    dp[i][0] = dp[i - 1][0] + tri[i][0];
                } else if(j == i){
                    dp[i][j] = dp[i - 1][j - 1] + tri[i][j];
                } else{
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + tri[i][j], dp[i - 1][j] + tri[i][j]);
                }
            }
        }
        
        int max = 0;
        
        // 마지막 depth에서 가장 큰 값 계산해야함
        for(int j = 0; j < m; j++){
            max = Math.max(max, dp[n - 1][j]);
        }
        
        return max;
    }
}