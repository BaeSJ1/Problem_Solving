// 13:28 - 13:38
import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        
        for(String[] c: clothes){
            map.put(c[1], map.getOrDefault(c[1], 0) + 1);
        }
        
        int result = 1;
        for(String count: map.keySet()){
            result *= (map.get(count) + 1);
        }
        
        return result - 1;
    }
}