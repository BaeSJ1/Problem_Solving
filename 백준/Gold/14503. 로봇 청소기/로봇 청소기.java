import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * bfs는 인접한 모든 노드를 탐색하는데, 여기선 가는 방향 조건이 다 정해져 있으므로 그냥 구현으로 푼다.
 */

public class Main {
    // 0: 북, 1; 동, 2: 남, 3: 서
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};

    static int[][] room;
    static int n, m;
    // 원래 코드 visited 작성했지만, 1로 표시 할 것이기 때문에 필요 없다.

    public static void main(String[] args) throws IOException {
        // 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        room = new int[n][m];

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = cleanRoom(r, c, d);
        System.out.println(result);
    }

    static int cleanRoom(int r, int c, int d) {
        int cnt = 0;

        while (true) {
            // 현재 위치 청소 안되어있으면 먼저 청소한다.
            if (room[r][c] == 0) {
                cnt++;
                room[r][c] = 2;
            }
        

            // 이동한 위치에서 주변 4칸 확인하여 이동할 수 있는지 없는지 알아야함
            boolean isCleaned = true;

            for (int i = 0; i < 4; i++) {
                d = (d + 3) % 4;
                // 반시계 방향으로
                int nx = r + dx[d];
                int ny = c + dy[d];

                // 범위 벗어나면 continue
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                // 이동한 위치에 0이 있으면 전진 해야함.
                if (room[nx][ny] == 0) {
                    // 이동된 위치 전달
                    r = nx;
                    c = ny;
                    isCleaned = false;
                    break;
                }
            }

            // 만약 청소가 다 되어있는게 아니면 마저 청소해야함.
            if (!isCleaned) continue;

            // 청소가 다 되어있을때
            // 1. 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 원래 조건들 수행
            // 한 칸 후진
            int back = (d + 2) % 4;
            int bx = r + dx[back];
            int by = c + dy[back];

            // 2. 바로 뒤쪽 칸 청소되어있으면 작동 멈추기
            if (room[bx][by] == 1) {
                return cnt;
            }

            // 후진 한칸 뒤로 이동
            r = bx;
            c = by;

        }
    }
}