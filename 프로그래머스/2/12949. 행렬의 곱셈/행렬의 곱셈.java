import java.util.*;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        
        int arr1R = arr1.length;
        int arr1C = arr1[0].length;
        int arr2R = arr2.length;
        int arr2C = arr2[0].length;
        
        int[][] answer = new int[arr1R][arr2C];
        
        for(int i = 0; i < arr1R; i++){
            for(int j = 0; j < arr2C; j++){
                for(int k = 0; k < arr1C; k++){
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        
        return answer;
    }
}