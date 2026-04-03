import java.io.*;
import java.util.*;

/***
 * 조건1. 위, 아래, 왼, 오, 앞, 뒤로 퍼져나감. => -1이면 토마토 없음
 * 조건2. 모두 익을 때까지 최소 며칠이 걸리는지를 계산한다. => BFS
 * 조건3. 토마토가 이미 다 익어있는 상태면 0을 출력, 토마토가 모두 익지 못하는 상황이면 -1을 출력.
 *
 * 보통 BFS는 시작점 1개에서 시작하는데, 얘는 익은 토마토 여러 개 -> 동시에 퍼져나가는 멀티 소스 BFS 형태
 * => 처음에 1인거 다 넣어줘야함.
 */

public class Main {
    static int[][][] boxes;
    static final int[] dn = {-1, 1, 0, 0, 0, 0};
    static final int[] dm = {0, 0, -1, 1, 0, 0};
    static final int[] dh = {0, 0, 0, 0, -1, 1};

    static class Point {
        int x, y, z, day;

        Point(int x, int y, int z, int day) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.day = day;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken()); // 열
        int n = Integer.parseInt(st.nextToken()); // 행
        int h = Integer.parseInt(st.nextToken()); // 층

        boxes = new int[n][m][h];

        Deque<Point> queue = new ArrayDeque<>();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    boxes[j][k][i] = Integer.parseInt(st.nextToken());

                    if (boxes[j][k][i] == 1) {
                        queue.add(new Point(j, k, i, 0));
                    }
                }
            }
        }

        System.out.println(bfs(queue, n, m, h));
    }

    static int bfs(Deque<Point> queue, int n, int m, int h) {
        int max = 0;
        while (!queue.isEmpty()) {
            Point now = queue.poll();
            for (int i = 0; i < 6; i++) {
                int nx = now.x + dn[i];
                int ny = now.y + dm[i];
                int nz = now.z + dh[i];

                if (nx < 0 || ny < 0 || nz < 0 || nx >= n || ny >= m || nz >= h) continue;
                if (boxes[nx][ny][nz] != 0) continue;

                boxes[nx][ny][nz] = 1;
                max = Math.max(max, now.day + 1);
                queue.add(new Point(nx, ny, nz, now.day + 1));

            }
        }

        // 전부 다 해보고 결국 0인게 있으면 최종적으로 -1 출력
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                for(int k = 0; k < h; k++){
                    if(boxes[i][j][k] == 0) return -1;
                }
            }
        }
        return max;
    }
}