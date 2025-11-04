// 18:41 - 
// 두 배열 중, 더 큰 값을 왼쪽에 더 작은 값을 오른쪽에 두고, 
// 왼쪽, 오른쪽 각각에서 가장 큰 수를 뽑아서 곱하면 된다.

import java.util.*;

class Solution {
    int w = 0;
    int h = 0;
    
    public int solution(int[][] sizes) {
        for(int[] size: sizes){
            if(size[0] > size[1]){
                int temp = size[0];
                size[0] = size[1];
                size[1] = temp;
            }
        }
        
        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        
        for(int[] size: sizes){
            x.add(size[0]);
            y.add(size[1]);
        }
        
        x.sort((a, b) -> b - a);
        y.sort((a, b) -> b - a);
        
        return x.get(0) * y.get(0);
    }
}