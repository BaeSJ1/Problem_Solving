import java.util.ArrayDeque;

class Solution {
    public int[] solution(int[] prices) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        int[] result = new int[prices.length];
        
        stack.push(0);
        for(int current = 1; current < prices.length; current++){
            while(!stack.isEmpty() && prices[stack.peek()] > prices[current]){
                int index_value = stack.pop();
                result[index_value] = current - index_value;
            }
            stack.push(current);
        }
        
        // 배열 다 돌았는데 스택에 값이 남아있으면 빼야한다.
        while(!stack.isEmpty()){
            int index_value = stack.pop();
            result[index_value] = prices.length - index_value - 1;
        }
        
        return result;
    }
}