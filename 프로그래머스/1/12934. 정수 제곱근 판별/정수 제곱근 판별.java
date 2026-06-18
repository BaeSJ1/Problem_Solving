import java.util.*;

class Solution {
    public long solution(long n) {
        long l = (long)Math.sqrt(n);
        if(Math.pow(l, 2) == n){
            return (long)Math.pow(l+1, 2);
        }
        return -1;
    }
}