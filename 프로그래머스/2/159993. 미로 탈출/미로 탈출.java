import java.util.*;
class Solution {
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};
    
    private static int n;
    private static int m;
    private static char[][] map;
    
    private static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        map = new char[n][m];
        
        for(int i = 0; i < n; i++){
            map[i] = maps[i].toCharArray();
        }
        
        Point start = null, lever = null, end = null;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == 'S') start = new Point(i, j);
                else if(map[i][j] == 'L') lever = new Point(i, j);
                else if(map[i][j] == 'E') end = new Point(i, j);
            }
        }
        
        int startLever = bfs(start, lever);
        int leverEnd = bfs(lever, end);
        
        if(startLever == -1 || leverEnd == -1) return -1;
        else return startLever + leverEnd;
    }
    
    private static int bfs(Point start, Point end){
        // 최단 거리 값 저장
        int[][] dist = new int[n][m];
        ArrayDeque<Point> queue = new ArrayDeque<>();
        dist[start.x][start.y] = 1;
        queue.add(start);
        
        while(!queue.isEmpty()){
            Point now = queue.poll();
            
            for(int i = 0; i < 4; i++){
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];
                
                // 범위를 벗어나면 패스
                if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) continue;
                
                // 벽인 경우 패스
                if(map[nextX][nextY] == 'X') continue;
                
                // 이미 방문한 경우 탐색하지 않음
                if(dist[nextX][nextY] > 0) continue;
                
                // 거리 1증가
                dist[nextX][nextY] = dist[now.x][now.y] + 1;
                
                queue.add(new Point(nextX, nextY));
                
                if(nextX == end.x && nextY == end.y)
                    return dist[end.x][end.y] - 1;
                
            }
        }
        return -1;
    }
}