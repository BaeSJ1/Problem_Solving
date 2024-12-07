import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 행의 개수
        int m = sc.nextInt(); // 열의 개수

        int[][] arrA = new int[n][m]; // 첫 번째 행렬
        int[][] arrB = new int[n][m]; // 두 번째 행렬
        int[][] result = new int[n][m]; // 결과 행렬

        // 첫 번째 행렬 입력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arrA[i][j] = sc.nextInt();
            }
        }

        // 두 번째 행렬 입력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arrB[i][j] = sc.nextInt();
            }
        }

        // 두 행렬의 합 계산
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = arrA[i][j] + arrB[i][j];
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
