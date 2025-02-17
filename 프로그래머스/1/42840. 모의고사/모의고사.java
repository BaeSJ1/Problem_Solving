import java.util.ArrayList;
import java.util.Arrays;
class Solution {
    public int[] solution(int[] answers) {
        int[][] pattern = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        int[] score = new int[3];
        for(int i = 0; i < pattern.length; i++){
            for(int j = 0; j < answers.length; j++){
                if(answers[j] == pattern[i][j % pattern[i].length]){
                    score[i] += 1;
                }
            }
        }
        int maxScore = Arrays.stream(score).max().getAsInt();
        ArrayList<Integer> result = new ArrayList<>();
        for(int s = 0; s < score.length; s++){
            if(score[s] == maxScore){
                result.add(s + 1);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
        
        
    }
}