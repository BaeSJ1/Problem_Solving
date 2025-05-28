import java.util.*;

// 20:46

class Solution {
    private static Map<String, PriorityQueue<String>> map = new HashMap<>();
    private static List<String> result = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        
        for(String[] ticket: tickets){
            String start = ticket[0];
            String end = ticket[1];
            
            if(!map.containsKey(start)){
                map.put(start, new PriorityQueue<>());
            }
            
            map.get(start).add(end);
        }
        
        dfs("ICN");
        
        Collections.reverse(result);
        
        return result.toArray(new String[0]);
    }
    
    private static void dfs(String path){
        PriorityQueue<String> pq = map.get(path);
        
        while(pq != null && !pq.isEmpty() ){
            String next = pq.poll();
            dfs(next);
        }
        
        result.add(path);
    }
}