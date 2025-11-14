import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/***
 * 빨간공의 위치, 파란공의 위치, depth 상태를 기억해야한다.
 */

public class Main {
    static class State {
        int rx;
        int ry;
        int bx;
        int by;
        int depth;

        public State(int rx, int ry, int bx, int by, int depth) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.depth = depth;
        }
    }

    static class Ball {
        int x;
        int y;
        // 몇 칸 이동했는지 빨간 공, 파란공의 위치가 같을 때를 대비해서 기록해야함
        int dist;
        boolean inHole;

        public Ball(int x, int y, int dist, boolean inHole) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.inHole = inHole;
        }
    }

    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    static char[][] map;
    static boolean[][][][] visited;

    public static void main(String[] args) throws IOException {
        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visited = new boolean[n][m][n][m];

        int rx = 0, ry = 0, bx = 0, by = 0;

        // map 만들기
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j);

                // 빨간공 위치 넘기기
                if (map[i][j] == 'R') {
                    rx = i;
                    ry = j;
                } else if (map[i][j] == 'B') {
                    bx = i;
                    by = j;
                }
            }
        }

        int result = 0;
        result = bfs(rx, ry, bx, by);
        System.out.println(result);
    }

    static int bfs(int rx, int ry, int bx, int by) {
        Deque<State> queue = new ArrayDeque<>();
        queue.add(new State(rx, ry, bx, by, 0));
        while (!queue.isEmpty()) {
            State cur = queue.poll();
            // cur.depth == 10일때 더 기울이면 안된다.
            if(cur.depth >= 10) return -1;
            for (int i = 0; i < 4; i++) {
                // 한번만 이동하는게 아니라 기울이는 거라서
                // 벽을 만날때까지 쭉 움직여야한다.
                Ball red = roll(cur.rx, cur.ry, i);
                Ball blue = roll(cur.bx, cur.by, i);

                if(blue.inHole) continue;
                if(red.inHole)  return cur.depth + 1;

                // 위치 같으면 더 많이 이동한 공 한칸 뒤로
                if (red.x == blue.x && red.y == blue.y) {
                    if (red.dist > blue.dist) {
                        red.x -= dx[i];
                        red.y -= dy[i];
                    } else {
                        blue.x -= dx[i];
                        blue.y -= dy[i];
                    }
                }

                if(!visited[red.x][red.y][blue.x][blue.y]) {
                    visited[red.x][red.y][blue.x][blue.y] = true;
                    queue.add(new State(red.x, red.y, blue.x, blue.y, cur.depth + 1));
                }
            }
        }
        return -1;
    }

    static Ball roll(int x, int y, int i) {
        // 이동한 칸 수
        int dist = 0;

        while (true) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            dist++;

            // 벽이면 break;
            if (map[nx][ny] == '#') {
                break;
            }

            // 구멍이면 inHole를 true로 return
            if (map[nx][ny] == 'O') {
                return new Ball(nx, ny, dist, true);
            }
            
            x = nx;
            y = ny;

        }
        return new Ball(x, y, dist, false);
    }
}