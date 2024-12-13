import java.util.Scanner;

public class Main {
    // 테트로미노의 총 개수는 19개
    static int[][][] block = {
            {{0, 1}, {0, 2}, {0, 3}},
            {{1, 0}, {2, 0}, {3, 0}},
            {{1, 0}, {1, 1}, {1, 2}},
            {{0, 1}, {-1, 1}, {-2, 1}},
            {{0, 1}, {0, 2}, {1, 2}},
            {{-1, 0}, {-2, 0}, {-2, 1}},
            {{0, 1}, {0, 2}, {-1, 2}},
            {{1, 0}, {2, 0}, {2, 1}},
            {{-1, 0}, {-1, 1}, {-1, 2}},
            {{0, 1}, {1, 1}, {2, 1}},
            {{0, 1}, {1, 1}, {1, 0}},
            {{0, 1}, {-1, 1}, {0, 2}},
            {{1, 0}, {2, 0}, {1, 1}},
            {{0, 1}, {0, 2}, {1, 1}},
            {{0, 1}, {-1, 1}, {1, 1}},
            {{1, 0}, {1, 1}, {2, 1}},
            {{0, 1}, {-1, 1}, {-1, 2}},
            {{-1, 0}, {-1, 1}, {-2, 1}},
            {{0, 1}, {1, 1}, {1, 2}},
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int result = 0;
        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int block_cnt = 0; block_cnt < 19; block_cnt++) {
                    int sum = arr[i][j];
                    boolean check = true;
                    for (int a = 0; a < 3; a++) {
                        int x = i + block[block_cnt][a][0];
                        int y = j + block[block_cnt][a][1];
                        if (0 <= x && x < n && 0 <= y && y < m) {
                            sum += arr[x][y];
                        } else {
                            check = false;
                            break;
                        }
                    }
                    if (check && result < sum) {
                        result = sum;
                    }
                }
            }
        }
        System.out.println(result);
    }
}
