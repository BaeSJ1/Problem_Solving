import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> result = new ArrayList<>();
        
        for(int[] roles: commands){
            List<Integer> nums = new ArrayList<>();
            
            for(int i = roles[0] - 1; i < roles[1]; i++){
                nums.add(array[i]);
            }
            
            nums.sort((a, b) -> a - b);
            result.add(nums.get(roles[2] - 1));
        }
        
        // list -> int[]
        return result.stream().mapToInt(i->i).toArray();
    }
}