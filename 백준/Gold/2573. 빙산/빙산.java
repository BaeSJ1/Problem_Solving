import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * 두 덩어리로 갈라졌는지 확인하는 방법이 관건인듯
 * => dfs로 덩어리 몇개인지 세어봐야함.
 * 바로 녹이면 XXX(이유: 이미 녹은 칸이 영향을 줘서) 따로 저장했다가 한번에 녹여야함.
 */

public class Main {
    static int[][] map;
    static int n, m;
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    static class Point {
        int x, y, year;

        Point(int x, int y, int year) {
            this.x = x;
            this.y = y;
            this.year = year;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year = 0;
        while (true) {
            // 분리되었는지 확인이 필요하다.
            // 분리O-> 최소 몇년인지 출력
            if (isSeperated()) {
                System.out.println(year);
                return;
            }
            // 전부 다 녹을 때까지 두 덩어리 이상으로 분리 안되면 0출력
            if (isAllMelted()) {
                System.out.println(0);
                return;
            }
            melt();
            year++;
        }
    }

    static boolean isSeperated() {
        boolean[][] visited = new boolean[n][m];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] > 0 && !visited[i][j]) {
                    dfs(i, j, visited);
                    count++;
                    if (count >= 2) return true;
                }
            }
        }
        return false;
    }

    static void dfs(int x, int y, boolean[][] visited) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            if (map[nx][ny] == 0 || visited[nx][ny]) continue;
            dfs(nx, ny, visited);
        }
    }

    static boolean isAllMelted() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] > 0) return false;
            }
        }
        return true;
    }

    static void melt() {
        //녹은 거에 대한 정보를 저장할 2차원 배열 필요
        int[][] meltCount = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) continue;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                    if (map[nx][ny] == 0) meltCount[i][j]++;
                }
            }
        }

        // 한번에 녹아야함.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 음수 불가
                map[i][j] = Math.max(0, map[i][j] - meltCount[i][j]);
            }
        }
    }
}