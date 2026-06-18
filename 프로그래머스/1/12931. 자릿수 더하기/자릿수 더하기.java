import java.util.*;

public class Solution {
    public int solution(int n) {
        int total = 0;
        String s = String.valueOf(n);
        for(int i = 0; i < s.length(); i++){
            total += s.charAt(i) - '0';
        }

        return total;
    }
}