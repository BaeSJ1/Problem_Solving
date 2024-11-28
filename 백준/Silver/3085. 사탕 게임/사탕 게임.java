import java.util.*;

public class Main {
    static int check(char[][] arr) {
        //행과 열로 구분하여 연속되는 최대 개수 검사
        //1행의 최대 개수 검사
        int max_count = 1;
        for (int i = 0; i < arr.length; i++) {
            int row_count = 1;
            int column_count = 1;
            for (int j = 1; j < arr.length; j++) {
                /// 0행일 때, j=0,1,2 에 전의 수랑 같으면 개수 추가
                if (arr[i][j] == arr[i][j - 1]) row_count += 1;
                else row_count = 1;
                if (row_count > max_count) max_count = row_count;

                if (arr[j][i] == arr[j-1][i]) column_count += 1;
                else column_count = 1;
                if (column_count > max_count) max_count = column_count;
            }
        }
        return max_count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        char[][] arr = new char[n][n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.next().toCharArray();
        }

        int max_count = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                // 인접한 오른쪽 사탕과 교환하며, 연속되는 최대 개수 검사한다.
                if (j + 1 < n) {
                    // 교환
                    char t = arr[i][j];
                    arr[i][j] = arr[i][j + 1];
                    arr[i][j + 1] = t;

                    int count = check(arr);
                    if (count > max_count) max_count = count;

                    // 원상복귀
                    t = arr[i][j];
                    arr[i][j] = arr[i][j+1];
                    arr[i][j+1] = t;
                }

                // 인접한 아래쪽 사탕에 대하여 똑같은 방식 진행
                if (i + 1 < n){
                    // 교환
                    char t = arr[i][j];
                    arr[i][j] = arr[i+1][j];
                    arr[i+1][j] = t;

                    int count = check(arr);
                    if (count > max_count) max_count = count;

                    // 원상복귀
                    t = arr[i][j];
                    arr[i][j] = arr[i+1][j];
                    arr[i+1][j] = t;
                }
            }
        }
        System.out.println(max_count);
    }
}
