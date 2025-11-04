// 16:32 - 
// 최소 변환 -> bfs
// 같은 단어 또 방문하지 않는다(중복 체크), 한 단어만 달라야한다

// 결과를 반환 할 때 depth(bfs 경로길이)를 알아야한다.

import java.util.*;

class Solution {
    static class Node{
        final String word;
        final int depth;
        Node(String word, int depth){
            this.word = word;
            this.depth = depth;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        return bfs(begin, target, words);
    }
    
    static int bfs(String begin, String target, String[] words){
        Set<String> set = new HashSet<>();
        Deque<Node> queue = new ArrayDeque<>();
        
        set.add(begin);
        queue.add(new Node(begin, 0));
        
        while(!queue.isEmpty()){
            Node now = queue.poll();
            
            if(now.word.equals(target)){
                return now.depth;
            }
            
            // 비교할 words 탐색
            for(String next: words){
                if(!set.contains(next) && canTransform(next, now.word)){
                    set.add(next);
                    queue.add(new Node(next, now.depth + 1));
                }
            }
        }
        return 0;
    }
    
    // 한단어만 달라야함.
    static boolean canTransform(String next, String now){
        int count = 0;
        for(int i = 0; i < next.length(); i++){
            if(next.charAt(i) != now.charAt(i)){
                count++;
            }
        }
        
        return count == 1;
    }
}