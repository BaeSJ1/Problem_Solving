import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toCollection(HashSet::new));
        
        int n = nums.length;
        int k = n/2;
        return Math.min(k, set.size());
    }
}