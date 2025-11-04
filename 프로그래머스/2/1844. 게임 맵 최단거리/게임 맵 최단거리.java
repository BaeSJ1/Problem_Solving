// 최단 거리 -> bfs
// 15:38 - 

import java.util.*;

class Solution {
    // 위, 아래, 왼, 오
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};
    
    static class Node{
        final int x;
        final int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(int[][] maps) {
        
        return bfs(maps);
        
    }
    
    static int bfs(int[][] maps){
        int n = maps.length;
        int m = maps[0].length;
        
        // 최소 거리를 담는다.
        int[][] dist = new int[n][m];
        
        Deque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0, 0));
        
        while(!queue.isEmpty()){
            Node now = queue.poll();
            
            for(int i = 0; i < 4; i++){
                // 이동위치 계산
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                
                // 계산된 위치가 범위를 벗어나는지 체크
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                
                // 벽인 것도 패스
                if(maps[nx][ny] == 0) continue;
                
                // dist 값이 없는(0) 곳은 계산이 필요하다.
                if(dist[nx][ny] == 0){
                    queue.add(new Node(nx, ny));
                    dist[nx][ny] = dist[now.x][now.y] + 1;
                }
                
                if((nx == (n - 1) && ny == (m - 1)) && dist[nx][ny] != 0 ){
                    return dist[nx][ny] + 1;
                }
            }
        }
        return -1;
    }
}