/*
    임의의 두 칸을 고르려면 한 칸을 고른다. 전체 N^2 중에 하나
    한 칸: (i, j)
    # 시작점부터 오른쪽, 아래만 검색하여도 전체를 탐색하게 된다.
    # 교환 후, 계산해보고 최댓값이면 result 에 추가 다시 원래 상태로 바꾼다.
 */

import java.util.*;

public class Main {
    static int check(char[][] arr) {
        //행일 때와 열일 때로 나눠서 계산
        int max_count = 1;
        for (int i = 0; i < arr.length; i++) {
            int cnt = 1;
            for (int j = 1; j < arr.length; j++) {
                if (arr[i][j] == arr[i][j - 1]) cnt++;
                else cnt = 1;
                if (cnt > max_count) max_count = cnt;
            }

            cnt = 1;
            for(int j = 1; j < arr.length; j++){
                if(arr[j][i] == arr[j-1][i]) cnt++;
                else cnt = 1;
                if(cnt > max_count) max_count = cnt;
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
        for (int i = 0; i < n; i++) {  // 행
            for (int j = 0; j < n; j++) {  // 열
                // 인접한 오른쪽(j+1) 자리 선택
                if (j + 1 < n) {  // 범위에 벗어나지 않도록
                    char t = arr[i][j];
                    arr[i][j] = arr[i][j + 1];
                    arr[i][j + 1] = t;

                    // arr[i][j]와 arr[i][j+1] 두개를 교환했을 때 1행 또는 열 중 가장 큰 값. 이 중에 또 가장 max 값 골라야함.
                    int count = check(arr);
                    if(count > max_count) max_count = count;

                    // 원상복귀
                    t = arr[i][j];
                    arr[i][j] = arr[i][j+1];
                    arr[i][j+1] = t;
                }

                // 인접한 아래쪽(i+1) 자리 선택
                if (i + 1 < n){
                    char t = arr[i][j];
                    arr[i][j] = arr[i+1][j];
                    arr[i+1][j] = t;

                    int count = check(arr);
                    if(count > max_count) max_count = count;

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
