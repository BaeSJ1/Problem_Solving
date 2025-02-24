import java.util.HashMap;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        HashMap<String, Integer> map = new HashMap<>();
        int result = 0;
        
        for(int i = 0; i < want.length; i++){
            map.put(want[i], number[i]);
        }
        
        
        HashMap<String, Integer> newMap = new HashMap<>();
        for(int i = 0; i < discount.length - 9; i++){
            for(int j = i; j < i + 10; j++){
                newMap.put(discount[j], newMap.getOrDefault(discount[j], 0) + 1);
            }
            
            if(newMap.equals(map)){
                result++;
            } 
            
            newMap.clear();
        }
        
        return result;
    }
}