import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // 신고당한 사람 - 신고한 사람
        HashMap<String, HashSet<String>> reports = new HashMap<>();
        // 신고한 사람 - 처리 완료된 메일(k범위 만족 해야함)
        HashMap<String, Integer> count = new HashMap<>();
        
        // reports 구성하기
        for(String s: report){
            String[] str = s.split(" ");
            String userId = str[0];  // 신고한 유저
            String reportedId = str[1];  // 신고당한 유저
            if(!reports.containsKey(reportedId)){
                reports.put(reportedId, new HashSet<>());  // value가 HashSet이기 때문에 형태를 초기화 시키고 아래에서 value값을 add로 추가해야함.
            }
            reports.get(reportedId).add(userId);
        }
        
        // 위에서 신고당한 유저 - 신고한 유저의 형태로 값들이 다 저장되었다.
        // count를 처리해야한다.
        // reports의 value값(신고한 사람이 중복없이 들어가 있음)을 봤을 때, 처음 들어온 유저면 숫자 1이고, 아니면 기존 숫자에서 +1을 해줘야한다.
        // 주의: k조건 만족해야함.
        for(Map.Entry<String, HashSet<String>> entry: reports.entrySet()){
            if(entry.getValue().size() >= k){
                for(String uid: entry.getValue()){
                    count.put(uid, count.getOrDefault(uid, 0) + 1);
                }
            }
        }
        
        int[] result = new int[id_list.length];
        for(int i = 0; i < id_list.length; i++){
            result[i] = count.getOrDefault(id_list[i], 0);
        }
        
        return result;
        
    }
}