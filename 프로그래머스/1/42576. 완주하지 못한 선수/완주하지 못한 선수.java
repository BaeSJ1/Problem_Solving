import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        
        for(String c: completion){
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }
        
        for(String p: participant){
            // hashMap(완주자)에 참여자 키(이름)이 없다면
            if(hashMap.getOrDefault(p, 0) == 0){
                return p;
            } else{
                hashMap.put(p, hashMap.get(p) - 1);
            }
        }
        return null;
    }
}