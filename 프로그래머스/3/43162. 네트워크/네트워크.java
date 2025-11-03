import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        // 이미 확인한 네트워크인지 알아야함
        boolean[] visited = new boolean[n];
        int result = 0;
        
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(computers, visited, i);
                result++;
            }
        }
        return result;
    }
    
    static void dfs(int[][] computers, boolean[] visited, int index){
        visited[index] = true;
        for(int i = 0; i < computers[index].length; i++){
            if(computers[index][i] == 1 && !visited[i]){
                dfs(computers, visited, i);
            }
        }
    }
}