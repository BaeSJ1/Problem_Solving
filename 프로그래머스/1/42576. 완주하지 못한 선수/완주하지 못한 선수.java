import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> completionMap = new HashMap<>();
        for(String c: completion){
            completionMap.put(c, completionMap.getOrDefault(c, 0) + 1);
        }
        
        for(String p: participant){
            if(!completionMap.containsKey(p) || completionMap.get(p) == 0){
                return p;
            } else{
                completionMap.put(p, completionMap.get(p) - 1);
            }
        }
        return null;
    }
}