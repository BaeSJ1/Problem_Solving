import java.util.*;

// dp 사용해서 메모리에 단계별 연산 값을 저장한다.
// dp[1] = 5로 시작(=> 5 1번 사용)
// dp[2] = dp[1]과 dp[1] 조합에 대해 복사, 사칙연산 이렇게만 계산한다.
// dp[3] = 555, dp[1]과 dp[2]조합, dp[2]와 dp[1]의 조합
// dp[4] = 5555, dp[1]과 dp[3]조합 등 5(N)를 4번 쓸 수 있게 조합하면 된다. 

class Solution {
    public int solution(int N, int number) {
        int result = calculateDp(N, number);
        return result;
    }
    
    private int calculateDp(int N, int number){
        // 계산 값이 중복일 경우를 대비에 set쓰기
        List<Set> dp = new ArrayList<>();
        
        // dp[1] ~ dp[8]까지 채워진다.
        for(int i = 0; i <= 8; i++){
            dp.add(new HashSet<>());
        }
        
        int repeated = 0;
        for(int i = 1; i <= 8; i++){
            repeated = repeated * 10 + N;
            dp.get(i).add(repeated);
            
            // 조합들에 대해서 사칙연산 해야함
            // i가 2일때(dp[2]), dp[1]과 dp[1] 조합에 대해 1번만 계산함
            // i가 3일때(dp[3]), dp[1]과 dp[2] 조합, dp[2]과 dp[1] 2번만 계산함
            for(int j = 1; j < i; j++){
                Set<Integer> set1 = dp.get(j);
                Set<Integer> set2 = dp.get(i - j);
                for(int a:set1){
                    for(int b:set2){
                        dp.get(i).add(a + b);
                        dp.get(i).add(a - b);
                        dp.get(i).add(a * b);
                        if (b != 0) dp.get(i).add(a / b);
                    }
                }
            }
            if(dp.get(i).contains(number)){
                return i;
            }
        }
        return -1;
    }
}