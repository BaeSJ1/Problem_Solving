import java.util.*;

class Solution {
    static Map<String, PriorityQueue<String>> map = new HashMap<>();
    static List<String> result = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        
        for(String[] t: tickets){
            map.computeIfAbsent(t[0], k -> new PriorityQueue<>()).add(t[1]);
        }
        
        dfs("ICN");
        
        Collections.reverse(result);
        
        return result.toArray(new String[0]);
    }
    
    static void dfs(String airport){
        PriorityQueue<String> queue = map.get(airport);
        
        // 각 공항별 갈 수 있는 곳들 먼저 체크
        while(queue != null && !queue.isEmpty()){
            String next = queue.poll();
            dfs(next);
        }
        result.add(airport);
    }
}