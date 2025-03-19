import java.util.*;
class Solution {
    private static int[] nx = {-1, 1, 0, 0};
    private static int[] ny = {0, 0, -1, 1};
    
    private static int n, m;
    
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
        // 문자 배열로 변경
        n = maps.length;
        m = maps[0].length();
        map = new char[n][m];
        Point start = null, end = null, lever = null;
        
        for(int i = 0; i < n; i++){
            map[i] = maps[i].toCharArray();
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == 'S'){
                    start = new Point(i, j);
                } else if(map[i][j] == 'L'){
                    lever = new Point(i, j);
                } else if(map[i][j] == 'E'){
                    end = new Point(i, j);
                }
            }
        }
        
        // 최단거리 구하기
        int startLever = bfs(start, lever);
        int leverEnd = bfs(lever, end);
        
        if(startLever == -1 || leverEnd == -1) return -1;
        else return startLever + leverEnd;
    }
    
    private static int bfs(Point start, Point end){
        ArrayDeque<Point> queue = new ArrayDeque<>();
        queue.add(start);
        // 현재 까지 저장된 최단거리 값
        int[][] dist = new int[n][m];
        dist[start.x][start.y] = 1;
        
        while(!queue.isEmpty()){
            Point now = queue.poll();
            for(int i = 0; i < 4; i++){
                int x = now.x + nx[i];
                int y = now.y + ny[i];
                
                // 범위를 벗어나거나
                if(x < 0 || x >= n || y < 0 || y >= m) continue;
                // 벽이거나
                else if(map[x][y] == 'X') continue;
                // 이미 방문했으면, 
                else if(dist[x][y] > 0) continue;
                else dist[x][y] = dist[now.x][now.y] + 1;
                
                queue.add(new Point(x, y));
                
                if(x == end.x && y == end.y){
                    return dist[end.x][end.y] - 1;
                }
            }
        }
        return -1;
    }
}