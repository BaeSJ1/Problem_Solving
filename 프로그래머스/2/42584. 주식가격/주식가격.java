import java.util.ArrayDeque;
class Solution {
    public int[] solution(int[] prices) {
        
        int[] result = new int[prices.length];  // 가격이 떨어지지 않는 '기간'결과를 저장할 배열
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        stack.push(0); // 비교를 위해 삽입
        
        // 가격이 떨어지는 값이 있는 경우
        for(int i = 0; i< prices.length;i++){
            // 가격이 떨어졌을 경우
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]){
                int j = stack.pop();
                result[j] = i - j;
            }
            // 가격이 떨어지지 않았을 경우 인덱스의 값을 집어넣는다.
            // 인덱스 2자리에서 가격이 떨어지는 경우라고 가정한다면, 인덱스 1번 자리에서는 떨어지지 않는 기간이 1이고, 인덱스 0번 자리에는 2일 것이다. 
            // 그렇다면 떨어지는 값을 만났을때, 현재 스택은 0, 1, 2 일 것이고, 현재 i = 3 값이지만 위의 조건에 적합하여 int j = 2가 될 것이고, result[2] = 1 / result[1] = 2가 될 것이다. 
            stack.push(i);
        }
        
        // 가격이 떨어지지 않았을 경우, 스택에 남아있는거 빼야함.
        while(!stack.isEmpty()){
            int j = stack.pop();
            result[j] = prices.length - 1 - j;
        }
        return result;

    }
}