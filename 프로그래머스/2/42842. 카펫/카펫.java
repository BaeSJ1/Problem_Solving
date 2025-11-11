import java.util.*;

class Solution {
    static int total;
    public int[] solution(int brown, int yellow) {
        total = brown + yellow;
        int height = 3;
        for(int i = 1; i <= total / 2; i++){
            // 12면, 1*12,2*6,3*4 
            if(check(i, brown, yellow)){
                height = i;
                break;
            }
        }
        
        int[] result = new int[2];
        result[0] = height;
        result[1] = total / height;
        
        return result;
    }
    
    private boolean check(int h, int brown, int yellow){
        int w = total/h;
        int b = 0;
        int y = 0;
        int[][] arr = new int[w][h];
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                if(i == 0 || j == 0 || i == arr.length - 1 || j == arr.length - 1){
                    b++;
                }else y++;
            }
        }
        
        if(b == brown && y == yellow){
            return true;
        } else return false;
    }
}