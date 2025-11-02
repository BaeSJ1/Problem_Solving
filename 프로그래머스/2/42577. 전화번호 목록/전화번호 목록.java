// 13:19 - 13:24
import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>();
        
        for(String p: phone_book){
            set.add(p);
        }
        
        for(String str: set){
            for(int i = 0; i < str.length(); i++){
                if(set.contains(str.substring(0, i))){
                    return false;
                }
            }
        }
        return true;
    }
}