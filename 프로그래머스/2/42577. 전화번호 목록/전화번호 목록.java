import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        Set<String> set = new HashSet<>();
        
        for(int i = 0; i < phone_book.length; i++){
            set.add(phone_book[i]);
        }
        
        for(String s: set){
            for(int i = 0; i < s.length(); i++){
                if(set.contains(s.substring(0, i))) return false;
            }
        }
        
        return true;
    }
}