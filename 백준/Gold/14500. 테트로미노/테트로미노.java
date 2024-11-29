import java.util.Scanner;

public class Main {
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
        int[][] a = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 테트로미노의 개수는 총 19개
                for (int k = 0; k < 19; k++) {
                    int sum = a[i][j];
                    boolean is_tetromino = true;
                    for (int l = 0; l < 3; l++) {
                        int x = i + block[k][l][0];
                        int y = j + block[k][l][1];
                        // 범위에 맞으면 값을 더해야한다.
                        if (0 <= x && x < n && 0 <= y && y < m) {
                            sum += a[x][y];
                        } else {
                            is_tetromino = false;
                            break;
                        }
                    }
                    if(is_tetromino && result < sum){
                        result = sum;
                    }
                }
            }
        }
        System.out.println(result);
    }
}
