
/*
    아홉 난쟁이들 키의 합에서 가짜 난쟁이 두 명의 키를 빼면 100이다.
    가짜 난쟁이 두명 arr[i] + arr[j] for 문 두 개 필요
    # 자바 배열 삭제 방법
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[9];
        int total = 0;

        for (int i = 0; i < 9; i++) {
            arr[i] = sc.nextInt();
            total += arr[i];
        }

        int fake1 = 0;
        int fake2 = 0;
        for(int i = 0; i < 9; i++){
            for(int j = i + 1; j < 9; j++){
                if(total - arr[i] - arr[j] == 100){
                    fake1 = i;
                    fake2 = j;
                    break;
                }
            }
        }

        // 결과 배열 생성 및 출력
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i < 9; i++){
            if(i != fake1 && i != fake2){
                result.add(arr[i]);
            }
        }

        // 오름차순 정렬
        Collections.sort(result);
        for (int height : result){
            System.out.println(height);
        }




    }
}
