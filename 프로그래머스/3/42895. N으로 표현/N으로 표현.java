import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int result = calculateDp(N, number);
        return result;
    }
    
    static int calculateDp(int N, int number){
        List<Set> dp = new ArrayList<>();
        
        // 초기화
        // 범위는 1-8까지이다. 
        for(int i = 0; i <= 8; i++){
            dp.add(new HashSet<>());
        }
        
        int repeated = 0;
        
        for(int i = 1; i <= 8; i++){
            repeated = repeated * 10 + N;
            
            dp.get(i).add(repeated);
            
            for(int j = 1; j < i; j++){
                // dp[2]는 dp[1]과 dp[1] 조합
                // dp[3]은 dp[1]과 dp[2] 조합, dp[2]와 dp[1]의 조합이다. 
                Set<Integer> set1 = dp.get(j);
                Set<Integer> set2 = dp.get(i - j); 
                
                for(int s1: set1){
                    for(int s2: set2){
                        dp.get(i).add(s1 + s2);
                        dp.get(i).add(s1 - s2);
                        dp.get(i).add(s1 * s2);
                        if(s2 != 0) dp.get(i).add(s1 / s2);
                    }
                }
            }
            // number랑 같은게 나오면 return한다.
            if(dp.get(i).contains(number)) return i;
        }
        return -1;
    }
}