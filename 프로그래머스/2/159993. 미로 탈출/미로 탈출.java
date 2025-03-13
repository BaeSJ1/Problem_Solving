import java.util.*;
class Solution {
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};
        
    private static class Point{
        int nx, ny;
        
        public Point(int nx, int ny){
                this.nx = nx;
                this.ny = ny;
        }
    }
    
    private static char[][] map;
    private static int n, m;
    
    
    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        
        map = new char[n][m];
        for(int i = 0; i < n; i++){
            map[i] = maps[i].toCharArray();
        }
        
        Point start = null, end = null, lever = null;
        
        // 시작 지점, 출구, 그리고 레버의 위치를 찾음
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == 'S') start = new Point(i, j);
                else if(map[i][j] == 'E') end = new Point(i, j);
                else if(map[i][j] == 'L') lever = new Point(i, j);
            }
        }
        
        // 시작 -> 레버 최단거리, 레버 -> 출구까지의 최단 거리 각각 구함
        int startLever = bfs(start, lever);
        int leverEnd = bfs(lever, end);
        
        // 도착 불가능한 경우는 -1, 도착 가능한 경우는 최단 거리를 반환
        if(startLever == -1 || leverEnd == -1)
            return -1;
        else
            return startLever + leverEnd;
    }
    
    private static int bfs(Point start, Point end){
        int[][] dist = new int[n][m];
        
        ArrayDeque<Point> queue = new ArrayDeque<>();
        dist[start.nx][start.ny] = 1;
        queue.add(start);
        
        while(!queue.isEmpty()){
            Point now = queue.poll();
            
            for(int i = 0; i < 4; i++){
                int nextX = now.nx + dx[i];
                int nextY = now.ny + dy[i];
                
                if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) continue;
                
                if(dist[nextX][nextY] > 0) continue;
                
                if(map[nextX][nextY] == 'X') continue;
                
                dist[nextX][nextY] = dist[now.nx][now.ny] + 1;
                
                queue.add(new Point(nextX, nextY));
                
                if(nextX == end.nx && nextY == end.ny)
                    return dist[end.nx][end.ny] - 1;
            }
        }
        
        return -1;
    }
}