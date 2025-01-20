import java.util.ArrayDeque;

class Solution {
    boolean solution(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        
        char[] a = s.toCharArray();
        for(char c:a){
            if(c == '('){
                stack.push(c);
            } else {
                if(stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}