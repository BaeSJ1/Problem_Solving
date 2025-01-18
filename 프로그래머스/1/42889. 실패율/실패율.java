import java.util.HashMap;

class Solution {
    public int[] solution(int N, int[] stages) {
        
        // 스테이지별 도전자 수를 구함.
        int[] challenger = new int[N+2];
        for(int i = 0; i<stages.length; i++){
         challenger[stages[i]] += 1;   
        }
        
        // 스테이지별 실패한 사용자 수를 구함.
        HashMap<Integer, Double> fails = new HashMap<>();
        double total = stages.length;
        
        // 실패율 계산
        for(int i = 1; i <= N; i++){
            if(challenger[i] == 0){
                fails.put(i, 0.0);
            } else{
                fails.put(i, challenger[i] / total);
                total -= challenger[i];
            }
        }
        
        // 내림차순 정렬
        return fails.entrySet().stream().sorted((o1, o2) -> Double.compare(o2.getValue(), o1.getValue())).mapToInt(HashMap.Entry::getKey).toArray();
        
    }
}