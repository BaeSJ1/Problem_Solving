import java.util.*;
class Solution {
    private static int result;
    public int solution(int[] numbers, int target) {
        result = 0;
        
        dfs(numbers, 0, 0, target);
        return result;
    }
    
    private static void dfs(int[] numbers, int index, int sum, int target){
        if(numbers.length == index){
            if(target == sum){
                result++;
            }
            return;
        }
        
        dfs(numbers, index + 1, sum + numbers[index], target);
        dfs(numbers, index + 1, sum - numbers[index], target);
    }
}