import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int result = calculateDp(triangle);
        return result;
    }
    
    private int calculateDp(int[][] triangle){
        int n = triangle.length;
        int[][] dp = new int[n][n];
        
        // 시작점
        dp[0][0] = triangle[0][0];
        
        // dp[0] 지정했으니까 i = 1부터 시작해야함
        // 삼각형의 특성상 행번호 + 1 = 열임
        // 1번째 행 -> 2개 들어감
        for(int i = 1; i < n; i++){
            for(int j = 0; j <= i; j++){
                // 한 행의 맨 앞이나 맨 뒤는 그냥 계산해서 바로 넣으면 됨
                if(j == 0){
                    dp[i][j] = dp[i - 1][0] + triangle[i][0];
                } else if(j == i){
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                } else{
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
                }
            }
        }
        
        int max = 0;
        
        // 마지막 줄에서 가장 큰 값이 정답
        for(int j = 0; j < n; j++){
            max = Math.max(max, dp[n - 1][j]);
        }
        
        return max;
    }
}