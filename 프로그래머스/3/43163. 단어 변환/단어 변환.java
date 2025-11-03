import java.util.*;

class Solution {
    static int result = 0;
    
    // 다음 인덱스(depth)를 줘야해서 클래스 선언 형식이 나음
    static class Node{
        final String word;
        final int depth;
        Node(String word, int depth){
            this.word = word;
            this.depth = depth;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        // words안에 target이 없으면 return 0
        if(Arrays.stream(words).noneMatch(target::equals)) return 0;
        bfs(begin, target, words);
        return result;
    }
    
    static void bfs(String begin, String target, String[] words){
        Deque<Node> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        
        queue.add(new Node(begin, 0));
        visited.add(begin);
        
        while(!queue.isEmpty()){
            Node now = queue.pop();
            
            // target을 찾으면 멈춘다.
            if(now.word.equals(target)){
                result = now.depth;
                return;
            }
            
            for(String word: words){
                // 방문하지 않은 단어이고, 한 단어만 달라야한다.
                if(!visited.contains(word) && canTransform(word, now.word)){
                    queue.add(new Node(word, now.depth + 1));
                    visited.add(word);
                }
            }
        }
    }
    
    static boolean canTransform(String word, String now){
        int count = 0;
        for(int i = 0; i < word.length(); i++){
            // 한 단어만 달라야지 true임
            if(word.charAt(i) != now.charAt(i)){
                count++;
            }
        }
        return count == 1 ? true : false;
    }
}