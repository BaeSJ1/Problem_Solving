import java.util.*;
class Solution {
    public int solution(String s) {
        HashMap<Character, Character> str = new HashMap<>();
        
        str.put(']', '[');
        str.put(')', '(');
        str.put('}', '{');
        
        int n = s.length();
        s += s;
        int count = 0;
        
        for(int i = 0; i < n; i++){
            ArrayDeque<Character> stack = new ArrayDeque<>(); // 다음꺼 검사할 때 스택 초기화 필요
            boolean bool = true;
            for(int j = i; j < n + i; j++){
                if(str.containsKey(s.charAt(j))){ // 닫힌 괄호일때
                    if(!stack.isEmpty() && str.get(s.charAt(j)).equals(stack.peek())){
                        stack.pop();
                        
                    } else{ // 잘못된 괄호일때
                        bool = false;
                        break;
                    }
                } else{ // 열린 괄호일때
                  stack.push(s.charAt(j));  
                }
            }
            if(bool && stack.isEmpty()){
                count++;
            }
        }
        return count;
    }
}