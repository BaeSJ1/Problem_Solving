import java.util.*;
class Solution {
    // 방향 (위, 아래, 오른쪽, 왼쪽)
    private static final int[] nx = {-1, 1, 0, 0};  // 행으로 생각
    private static final int[] ny = {0, 0, 1, -1};  // 열로 생각
    private static class Node{
        int row;
        int col;
        
        public Node(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        // 최소 거리를 저장하는 dist배열
        int[][] dist = new int[n][m];
        
        // bfs를 위한 큐 생성
        ArrayDeque<Node> queue = new ArrayDeque<>();
        
        queue.add(new Node(0, 0));
        dist[0][0] = 1;
        
        while(!queue.isEmpty()){
            Node now = queue.poll();
            
            // 현재 위치에서 이동할 수 있는 모든 방향
            for(int i = 0; i < 4; i++){
                int x = now.row + nx[i];
                int y = now.col + ny[i];
                
                /// 범위 내에 있고 , 이미 방문한 노드가 아니고, maps의 값이 0이 아니면 된다.
                // 범위 검사
                if(x < 0 || y <0 || x >= n|| y >= m) continue;
                
                // 벽으로 가는 경우 예외 처리
                if(maps[x][y] == 0) continue;
                
                
                // 처음 방문한 경우, queue에 추가하고 거리를 갱신
                if(dist[x][y] == 0){
                    queue.add(new Node(x, y));
                    dist[x][y] = dist[now.row][now.col] + 1;
                }
            }
        }
        return dist[n - 1][m - 1] == 0 ? -1 : dist[n-1][m-1];
    }
}