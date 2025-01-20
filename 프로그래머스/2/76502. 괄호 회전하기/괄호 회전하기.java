import java.util.*;

class Solution {
    public int solution(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        
        int n = s.length();
        int answer = 0;

        // n번 회전
        A: for (int i = 0; i < n; i++) {
            ArrayDeque<Character> stack = new ArrayDeque<>();

            // 회전된 문자열 처리
            for (int j = 0; j < n; j++) {
                char c = s.charAt((i + j) % n); // 회전을 구현하기 위해 인덱스 조정
                
                if (map.containsKey(c)) { // 열리는 괄호 처리
                    stack.push(c);
                } else { // 닫는 괄호 처리
                    if (stack.isEmpty() || map.get(stack.pop()) != c) {
                        continue A; // 잘못된 괄호 조합 -> 다음 회전으로 넘어감
                    }
                }
            }
            
            // 스택이 비어 있다면 올바른 괄호
            if (stack.isEmpty()) {
                answer++;
            }
        }

        return answer;
    }
}
