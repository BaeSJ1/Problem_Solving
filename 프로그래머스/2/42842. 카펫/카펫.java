import java.util.*;

// 노란색 격자의 수가 1이상이니까 세로 길이가 최소 3은 되어야함
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] result = new int[2];
        int total = brown + yellow;
        for(int h = 3; h <= total; h++){
            int w = total/h;
            int y = (h - 2) * (w - 2);
            if(y == yellow){
                result = new int[]{h, w};
            }
        }
        return result;
    }
}