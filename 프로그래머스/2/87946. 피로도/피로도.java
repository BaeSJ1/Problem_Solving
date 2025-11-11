import java.util.*;
// 탐색은 dfs로 해야할듯

class Solution {
    static boolean[] visited;
    static int result = 0;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(k, dungeons, 0);
        return result;
    }
    
    private void dfs(int cur, int[][] dungeons, int depth){
        result = Math.max(result, depth);
        int i = 0;
        for(int[] dungeon: dungeons){
            int request = dungeon[0];
            int minus = dungeon[1];
            
            if(!visited[i] && cur >= request){
                visited[i] = true;
                dfs(cur - minus, dungeons, depth + 1);
                
                // 백트래킹
                visited[i] = false;
            }
            i++;
        }
    }
}