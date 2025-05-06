import java.util.*;

// 큐를 사용 

class Solution {
    public int solution(int[] priorities, int location) {
        int n = priorities.length;
        
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        
        for(int i = 0 ; i < n; i++){
            queue.add(new int[]{i, priorities[i]});
        }
        
        int result = 0;
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            boolean hasHigher = false;
            
            for(int[] next: queue){
                if(next[1] > cur[1]){
                    hasHigher = true;
                    break;
                }
            }
            
            if(hasHigher){
                queue.addLast(cur);
            } else{
                result++;
                if(cur[0] == location){
                    return result;
                }
            }
        }
        
        return -1;
    }
}