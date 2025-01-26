import java.util.HashMap;
import java.util.ArrayDeque;

class Solution {
    public int solution(String s) {
        // 닫힌 괄호가 있을 때, stack을 pop하면서 맞는 열린 괄호가 있는지 체크해야한다.
        HashMap<Character, Character> map = new HashMap<>();
        map.put(']','[');
        map.put('}','{');
        map.put(')','(');
        
        int n = s.length();
        s += s;
        int result = 0;
        
        ArrayDeque<Character> stack = new ArrayDeque<>();
        
        A: for(int i = 0; i < n; i++){  // 괄호의 개수만큼 loop 돌린다. 0~5 체크, 1~6 체크 ...
            for(int j = i; j < i + n; j++){
                char c = s.charAt(j);
                if(!map.containsKey(c)){ // 열린 괄호면,
                    stack.push(c);
                } else{  // 닫힌 괄호면,
                    if(stack.isEmpty() || !stack.pop().equals(map.get(c))){
                        continue A;
                    }
                }
            }
            if(stack.isEmpty()){
                result++;
            }
        }
        return result;
    }
}