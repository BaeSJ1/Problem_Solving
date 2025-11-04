// 14:42 - 
// 스택 dfs

import java.util.*;
class Solution {
    static class State{
        int depth;
        int sum;
        State(int depth, int sum){
            this.depth = depth;
            this.sum = sum;
        }
    }
    
    static private int result = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, target);
        return result;
    }
    
    static void dfs(int[] numbers, int target){
        Deque<State> stack = new ArrayDeque<>();
        stack.add(new State(0, 0));
        
        while(!stack.isEmpty()){
            State now = stack.pop();
            
            // 제일 하위 트리까지 계산했으면, target과 같은 지 비교
            if(now.depth == numbers.length){
                if(target == now.sum){
                    result++;
                }
                continue;
            }
            
            
            // 다음 스택엔 현재까지 계산한 sum이랑 다음에 탐색할 depth 정보를 줘야함
            stack.push(new State(now.depth + 1, now.sum + numbers[now.depth]));
            stack.push(new State(now.depth + 1, now.sum - numbers[now.depth]));
        }
        
    }
}