import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] arr = new int[N + 2];
        for(int stage: stages){
            arr[stage]++;
        }
        
        HashMap<Integer, Double> fail = new HashMap<>();
        
        double total = stages.length;
        for(int i = 1; i <= N; i++){
            if(arr[i] == 0){
                fail.put(i, 0.);
            }else{
                fail.put(i, arr[i] / total);
                total -= arr[i];
            }
        }
        
        return fail.entrySet().stream().sorted((o1,o2) -> Double.compare(o2.getValue(), o1.getValue())).mapToInt(HashMap.Entry::getKey).toArray();
    }
}