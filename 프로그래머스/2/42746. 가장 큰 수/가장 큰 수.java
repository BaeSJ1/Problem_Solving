import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        
        List<String> s = new ArrayList<>();
        
        for(int i = 0; i < numbers.length; i++){
            s.add(String.valueOf(numbers[i]));
        }
        
        s.sort((a, b) -> (b + a).compareTo(a + b));
        if(s.get(0).equals("0")) return "0";
        
        StringBuilder sb = new StringBuilder();
        for(String str: s){
            sb.append(str);
        }
        
        return sb.toString();
    }
}