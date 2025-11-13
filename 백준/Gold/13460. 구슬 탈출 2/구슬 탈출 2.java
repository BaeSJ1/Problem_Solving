import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// 최소 횟수를 구해야함 -> bfs

public class Main {
    static class Ball {
        int x, y, dist; // dist = 굴러간 칸 수
        boolean inHole;

        public Ball(int x, int y, int dist, boolean inHole) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.inHole = inHole;
        }
    }

    static class State {
        int rx, ry, bx, by, depth;

        public State(int rx, int ry, int bx, int by, int depth) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.depth = depth;
        }
    }

    // 상, 하, 좌, 우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int n, m;
    static char[][] map;

    static boolean[][][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];

        int rx = 0, ry = 0, bx = 0, by = 0;

        // map에서 R과 B의 위치를 알아야한다.
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'R') {
                    rx = i;
                    ry = j;
                } else if (map[i][j] == 'B') {
                    bx = i;
                    by = j;
                }
            }
        }

        visited = new boolean[n][m][n][m];

        int result = bfs(rx, ry, bx, by);
        System.out.println(result);
    }

    static int bfs(int rx, int ry, int bx, int by) {
        Deque<State> queue = new ArrayDeque<>();
        queue.add(new State(rx, ry, bx, by, 0));
        visited[rx][ry][bx][by] = true;

        while (!queue.isEmpty()) {
            State cur = queue.poll();
            if (cur.depth >= 10) return -1;

            for (int i = 0; i < 4; i++) {
                Ball red = roll(cur.rx, cur.ry, i);
                Ball blue = roll(cur.bx, cur.by, i);

                if(blue.inHole) continue;
                if(red.inHole) return cur.depth + 1;

                if(red.x == blue.x && red.y == blue.y) {
                    if(red.dist > blue.dist) {
                        red.x -= dx[i];
                        red.y -= dy[i];
                    } else{
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

    static Ball roll(int rx, int ry, int i) {
        int x = rx;
        int y = ry;
        int dir = 0;
        while (true) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (map[nx][ny] == '#') break;

            x = nx;
            y = ny;
            dir++;

            if(map[x][y] == 'O'){
                return new Ball(x, y, dir, true);
            }
        }
        return new Ball(x, y, dir, false);
    }
}