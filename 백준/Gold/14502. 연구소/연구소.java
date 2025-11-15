import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/***
 * 벽을 세우는 경우의 수는 완전탐색을 이용해야한다 (dfs + 백트래킹)
 * 바이러스 확산 -> dfs나 bfs
 */

public class Main {
    static class State {
        int x;
        int y;

        public State(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // 상, 하, 좌, 우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int n, m;

    static int maxSafe = 0;

    public static void main(String[] args) throws IOException {
        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];

        // map 배열 할당
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 벽 개수별로 dfs 쭉 계산해야함
        dfs(0, map);
        System.out.println(maxSafe);
    }

    static void dfs(int wallCount, int[][] map) {
        // 벽이 3개 세우면 바이러스 퍼트리고, 계산하면 됨
        if (wallCount == 3) {
            // 배열은 참조 타입이라서 함수로 넘겨도 원본이 변한다.
            // 벽 세우는 건 원본이 변해도 백트래킹으로 되돌릴 수 있지만
            // 바이러스를 퍼트리는 건 완전탐색 방식이 아니기 때문에 원본이 변하면 안된다.
            // 얘는 원본 map을 여러번 재사용 해야하므로 map을 복사하는 것이 필수이다.
            ///  바이러스 퍼지기
            int[][] newMap = copyMap(map);

            Queue<State> stack = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (newMap[i][j] == 2) {
                        // 바이러스 있는 위치 기록하기
                        stack.add(new State(i, j));
                    }
                }
            }

            while (!stack.isEmpty()) {
                State cur = stack.poll();
                int x = cur.x;
                int y = cur.y;

                // 한 칸씩 퍼트리기
                for(int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];

                    if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
                        // 이동할 위치의 값이 0일 때,
                        if(newMap[nx][ny] == 0) {
                            newMap[nx][ny] = 2;
                            stack.add(new State(nx, ny));
                        }
                    }
                }
            }

            // 바이러스 퍼트린 후, 최종 안전 영역 카운트
            int safe = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (newMap[i][j] == 0) safe++;
                }
            }

            maxSafe = Math.max(maxSafe, safe);
            return;
        }

        // 벽 설치 (완전탐색)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(wallCount + 1, map);
                    // 백트래킹으로 원상복구
                    map[i][j] = 0;
                }
            }
        }
    }

    static int[][] copyMap(int[][] map) {
        int[][] newMap = new int[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) {
            newMap[i] = map[i].clone();
        }
        return newMap;
    }
}