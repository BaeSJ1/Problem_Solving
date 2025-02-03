import java.util.ArrayDeque;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
            
        int n = progresses.length;
        int[] days = new int[n];
        
        for(int i = 0; i < n; i++){
            days[i] = (int) Math.ceil((100.0 - progresses[i])/speeds[i]);
        }
        
        int count = 0;
        int maxDay = days[0];
        
        for(int i = 0; i < n; i++){
            if(days[i] <= maxDay){
                count++;
            } else{
                deque.add(count);
                count = 1;
                maxDay = days[i];
            }
        }
        
        deque.add(count);
        
        return deque.stream().mapToInt(Integer::intValue).toArray();
    }
}