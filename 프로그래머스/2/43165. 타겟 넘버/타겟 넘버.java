import java.util.*;

// DFS 사용

class Solution {
    private static int count = 0;
    public int solution(int[] numbers, int target) {
        // target과 같아야한다.
        
        // 입력배열, 인덱스, 현재까지 합, 목표 값
        dfs(numbers, 0, 0, target);
        return count;
    }
    
    private static void dfs(int[] numbers, int idx, int sum, int target){
        if(idx == numbers.length){
            if(sum == target){
                count++;
            }
            return;
        }
        
        dfs(numbers, idx + 1, sum + numbers[idx], target);
        dfs(numbers, idx + 1, sum - numbers[idx], target);
    }
}