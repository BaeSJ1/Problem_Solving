// 21:45-22:09
import java.util.*;

class Solution {
    static int[] p1 = {1, 2, 3, 4, 5};
    static int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
    static int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    public int[] solution(int[] answers) {
        int[] count = new int[3];
        for(int i = 0; i < answers.length; i++){
            if(answers[i] == p1[i % p1.length]){
                count[0]++;
            }
            if(answers[i] == p2[i % p2.length]){
                count[1]++;
            }
            if(answers[i] == p3[i % p3.length]){
                count[2]++;
            }
        }
        
        int[] copy = new int[3];
        
        copy = count.clone();
        Arrays.sort(copy);
        
        int max = copy[copy.length - 1];
        
        List<Integer> result = new ArrayList<>();
        
        for(int i = 0; i < 3; i++){
            if(count[i] == max){
                result.add(i + 1);
            }
        }
        
        return result.stream().mapToInt(i->i).toArray();
    }
}