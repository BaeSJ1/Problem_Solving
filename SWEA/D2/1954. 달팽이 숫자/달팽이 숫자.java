
import java.util.Scanner;

/**
 * 오른쪽, 아래, 왼, 위
 */

public class Solution {
    // 오, 아, 왼, 위
    static final int[] dx = {0, 1, 0, -1};
    static final int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int t = 0; t < tc; t++) {
            int n = sc.nextInt();
            int[][] map = new int[n][n];


            cal(map, n);

            System.out.println("#" + (t + 1));
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
        }

    }

    static void cal(int[][] map, int n) {
        int x = 0;
        int y = 0;
        int num = 1;
        int i = 0;

        while (num <= n * n) {

            map[x][y] = num++;

            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n || map[nx][ny] != 0) {
                i = (i + 1) % 4;
                nx = x + dx[i];
                ny = y + dy[i];
            }

            x = nx;
            y = ny;
        }
    }
}