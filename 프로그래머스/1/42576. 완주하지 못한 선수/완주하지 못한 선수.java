import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String c: completion){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for(String p: participant){
            if(map.getOrDefault(p, 0) == 0){ // 완주자 목록 값이 0인거랑, 완주자 목록 key값에 없는 참가자면
                return p;             
            }else{
                map.put(p, map.get(p) - 1);
            }
        }
        return null;
    }
}