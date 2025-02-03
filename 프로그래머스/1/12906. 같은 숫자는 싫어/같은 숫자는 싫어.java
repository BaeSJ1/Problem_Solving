// 바로 전에 숫자를 검사하는 것이기 때문에 stack을 사용해야된다.
import java.util.ArrayDeque;

public class Solution {
    public int[] solution(int []arr) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        stack.push(arr[0]);
        
        for(int i = 1; i < arr.length; i++){
            if(arr[i] == stack.peek()){
                continue;
            } else {
                stack.push(arr[i]);
            }
        }
        
        int[] result = new int[stack.size()];
        for(int i = stack.size() - 1; i >= 0; i--){
            result[i] = stack.pop();
        }
        
        return result;
    }
}