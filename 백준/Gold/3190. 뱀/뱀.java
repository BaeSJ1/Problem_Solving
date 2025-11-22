import java.util.*;

// 19:14

/***
 * 뱀은 맨위 맨 좌측에 위치하고 뱀의 길이는 1
 * 뱀은 처음에 오른쪽을 향한다.
 * 몸길이를 늘려 머리를 다음칸에 위치시킨다.
 * 벽이나 자기자신의 몸과 부딪히면 게임이 끝난다.
 * 이동한 칸에 사과가 있다면, 그 칸에 있던 사과가 없어지고, 꼬리는 움직이지 않는다.
 * -> 사과가 없다면, 몸길이를 줄여서 꼬리가 위치한 칸을 비워준다.(몸길이는 변하지 않는다.)
 */

/// 뱀의 꼬리, 뱀의 머리 기억하기
public class Main {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // 오른쪽에서 시작 ->(오른쪽 회전)하 -> 좌 -> 상
    static final int[] dx = {0, 1, 0, -1};
    static final int[] dy = {1, 0, -1, 0};

    static int N, K, snakeLen;
    static int[][] board;
    static Map<Integer, String> map = new HashMap<>();
    static int time = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        snakeLen = 1;
        board = new int[N][N];

        for (int i = 0; i < K; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            board[x - 1][y - 1] = 1;
        }

        int L = sc.nextInt();
        for (int i = 0; i < L; i++) {
            int s = sc.nextInt();
            String c = sc.next();
            map.put(s, c);
        }

        calSnake(0, 0);

        System.out.println(time);

    }

    static void calSnake(int x, int y) {
        // 시작은 맨위 맨 왼쪽에서 시작
        // 오른쪽으로 출발
        int dir = 0;
        Deque<Point> queue = new ArrayDeque<>();
        queue.add(new Point(x, y));

        Point cur = new Point(x, y);
        boolean first = true;

        while (true) {
            if (!first) {
                time++;
                // 완전 종료는 벽에 부딪히거나, 뱀의 몸통에 부딪힐때, 이때도 time은 1 증가해줘야함.
                if (cur.x < 0 || cur.y < 0 || cur.x >= N || cur.y >= N) {
                    return;
                }

                if (queue.stream().anyMatch(point -> point.x == cur.x && point.y == cur.y)) return;

                // 사과가 있든 없든, 계산된 위치로 이동한다.
                queue.add(new Point(cur.x, cur.y));

                // 사과있으면 길이 늘림
                if (board[cur.x][cur.y] == 1) {
                    /// 사과 먹은거 처리해야함
                    board[cur.x][cur.y] = 0;
                }
                // 사과 없을 때
                else {
                    // 큐 안에 남아있는 위치들의 개수가 총 뱀 길이이다.
                    // 가장 예전에 담은 위치 하나 뺌
                    Point tail = queue.pop();
                }
            }

            int nextX;
            int nextY;
            first = false;

            // map에 회전정보 포함되면 회전해야함.
            // 저장되는건 다음에 이동되는 위치
            if (map.containsKey(time)) {
                dir = map.get(time).equals("D") ? dir + 1 : dir - 1;
                // 음수면 안된다.
                if (dir >= 4) {
                    dir -= 4;
                }
                if (dir < 0) dir += 4;
                // 다음 위치 체크
                nextX = cur.x + dx[dir];
                nextY = cur.y + dy[dir];

            } else {
                // 조건 없으면 그 방향 그대로 직진
                nextX = cur.x + dx[dir];
                nextY = cur.y + dy[dir];
            }
            cur.x = nextX;
            cur.y = nextY;

        }
    }
}