//12:43 -  
import java.util.*;

class Solution {
    static int[] p1 = {1, 2, 3, 4, 5};
    static int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
    static int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    
    public int[] solution(int[] answers) {
        int[] result = new int[3];
        List<Integer> answer = new ArrayList<>();
        
        for(int i = 0; i < answers.length; i++){
            if(answers[i] == p1[i % p1.length]){
                result[0]++;
            }
            
            if(answers[i] == p2[i%p2.length]){
                result[1]++;
            }
            
            if(answers[i] == p3[i%p3.length]){
                result[2]++;
            }
        }
        
        int[] arr = result.clone();
        
        Arrays.sort(arr);
        int max = arr[2];
        
        for(int i = 0; i < 3; i++){
            if(max == result[i]){
                answer.add(i+1);
            }
        }
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}