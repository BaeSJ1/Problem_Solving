import java.util.*;
class Solution {
    // 상, 좌, 하, 우
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};
    
    private static class Node{
        int x;
        int y;
        int direction;
        int cost;
        public Node(int x, int y, int direction, int cost){
            this.x = x;
            this.y = y;
            this.direction = direction;
            this.cost = cost;
        }
    }
    
    private static int calculateCost(int i, int preDirection, int cost){
        // 이전이 출발점이거나 상-하나 좌-우와 같이 같은 방향이면,
        if(preDirection == -1 || (i - preDirection) % 2 == 0)
            return cost + 100;
        else return cost + 600;
    }
    
    public int solution(int[][] board) {
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0,0,-1,0)); // 출발점
        int N = board.length;
        int[][][] visited = new int[N][N][4];
        
        int result = Integer.MAX_VALUE;
        
        while(!queue.isEmpty()){
            Node now = queue.poll();
            
            for(int i = 0; i < 4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                
                // 갱신된 x, y 좌표 체크(범위를 벗어나지 않고, 벽이 아니고, 출발점이 아니면 실행)
                if(nx < 0 || nx >= N || ny < 0 || ny >= N ) continue;
                if(board[nx][ny] == 1 || (nx == 0 && ny == 0)) continue;
                
                // 현재 갈 방향, 이전 방향, 비용으로 비용을 계산
                int ncost = calculateCost(i, now.direction, now.cost);
                
                // 주어진 좌표, 방향이 아직 방문하지 않았거나 새롭게 계산한 비용이 더 작으면 갱신한다
                if(visited[nx][ny][i] == 0 || visited[nx][ny][i] > ncost){
                    visited[nx][ny][i] = ncost;
                    queue.add(new Node(nx,ny,i,visited[nx][ny][i]));
                }
                
                // 도착지인 경우 최소 비용을 업데이트 한다.
                if(nx == N - 1 && ny == N - 1)
                    result = Math.min(result, ncost);
                
            }
        }
        return result;
    }
}