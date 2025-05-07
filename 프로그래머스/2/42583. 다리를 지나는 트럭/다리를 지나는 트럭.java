import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        
        int idx = 0;
        int time = 0;
        int sum = 0;
        
        for(int i = 0; i < bridge_length; i++){
            queue.add(0);
        }
        
        while(idx < truck_weights.length){
            time++;
            sum -= queue.poll();
            if(sum + truck_weights[idx] <= weight){
                queue.add(truck_weights[idx]);
                sum += truck_weights[idx];
                idx++;
            }else{
                queue.add(0);
            }
        }
        
        return time + bridge_length;
    }
}