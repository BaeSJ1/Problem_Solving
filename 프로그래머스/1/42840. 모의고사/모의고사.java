import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[][] numbers = {
            {1,2,3,4,5},
            {2,1,2,3,2,4,2,5},
            {3,3,1,1,2,2,4,4,5,5}
        };
        
        int[] scores = new int[3];
        
        for(int i = 0; i < numbers.length; i++){
            for(int j = 0; j < answers.length;j++){
                if(answers[j] == numbers[i][j % numbers[i].length]){
                    scores[i]++;
                }
            }
        }
        // scores 배열 중 가장 max인 값을 가져오기. for문 대신 stream을 사용.
        int maxScore = Arrays.stream(scores).max().getAsInt();
        
        // 개수 제한이 없다.
        ArrayList<Integer> answer = new ArrayList<>();
        
        // 최고점이 같은 사람이 있다면 그 사람도 출력 되어야한다. 
        // 즉, 몇명인지 정확하게 알 수 없으므로 ArrayList를 사용.
        for(int i = 0; i < scores.length; i++){
            if(scores[i] == maxScore){
                answer.add(i+1);
            }
        }
        
        // 배열에 있는 값들을 정수로 반환하였다. 
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}