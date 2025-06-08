import java.util.*;

class Solution {
    private static int[][] dg;
    private static boolean[] visited;
    private static int result;
    
    public int solution(int k, int[][] dungeons) {
        dg = dungeons;
        visited = new boolean[dg.length];
        bt(k, 0); 
        return result;
    }
    
    private static void bt(int k, int count){
        for(int i = 0; i < dg.length; i++){
            if(!visited[i] && k >= dg[i][0]){
                visited[i] = true;
                bt(k - dg[i][1], count + 1);
                result = Math.max(result, count + 1);
                visited[i] = false;
            }
        }
    }
}