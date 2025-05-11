import java.util.*;

/*
초 누적 -> stack
stack에 인덱스의 값을 넣고 인덱스 - 인덱스와 같은 형태로 초를 계산
만약 가격이 떨어지는 부분이 나오면, 인덱스 - 인덱스를 계산해서 반환
*/

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] result = new int[n];
        
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        for(int i = 0; i < n; i++){
            // 값이 떨어지면
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]){
                result[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()){
            result[stack.peek()] = n - 1 - stack.peek();
            stack.pop();
        }
        
        return result;
    }
}