import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        HashSet<String> set = new HashSet<>();
        int preWord = words[0].charAt(0);
        
        for(int i = 0; i < words.length; i++){
            if(set.contains(words[i]) || preWord != words[i].charAt(0)){
                return new int[]{(i%n) + 1, (i/n) + 1};
            }else{
                preWord = words[i].charAt(words[i].length() - 1);
                set.add(words[i]);
            }
        }

        return new int[]{0, 0};
    }
}