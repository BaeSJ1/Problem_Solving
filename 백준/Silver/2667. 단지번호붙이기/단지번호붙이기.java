import java.util.*;

/***
 * 주변 다 탐색 -> dfs
 */

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int n;
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};
    static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        // 결과를 담을 배열 필요
        List<Integer> results = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    count = 0;
                    dfs(i, j);
                    results.add(count);
                }
            }
        }

        Collections.sort(results);
        StringBuilder sb = new StringBuilder();
        sb.append(results.size()).append("\n");
        for(int result: results){
            sb.append(result).append("\n");
        }
        System.out.print(sb);

    }

    // map[x][y]가 1이고 방문하지 않았으면 먼저 dfs로 보내줘야함. 여기서 헤맸음.
    // 위에서 보내기
    static void dfs(int x, int y) {
        visited[x][y] = true;
        count++;

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
            if(visited[nx][ny] || map[nx][ny] == 0) continue;

            dfs(nx, ny);
        }
    }
}