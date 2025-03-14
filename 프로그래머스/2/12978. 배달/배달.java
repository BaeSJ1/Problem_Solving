import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Arrays;
class Solution {
    
    private static class Node{
        int dest;
        int cost;
        public Node(int dest, int cost){
            this.dest = dest;
            this.cost = cost;
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        ArrayList<Node>[] adjList = new ArrayList[N + 1];
        // 인접리스트 초기화
        for(int i = 0; i < N + 1; i++){
            adjList[i] = new ArrayList<>();
        }
        
        // 양방향 그래프
        for(int[] edge: road){
            adjList[edge[0]].add(new Node(edge[1], edge[2]));
            adjList[edge[1]].add(new Node(edge[0], edge[2]));
        }
        
        // 가중치 저장 -> 어떻게 변화하는지 생각해보기
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        // 시작노드 1, cost는 왜 0이지?
        pq.add(new Node(1, 0));
        
        // 왜 dist[1] = 0인가?
        dist[1] = 0;
        
        while(!pq.isEmpty()){
            Node now = pq.poll();
            
            // 지금 최소비용보다 더 큰 비용은 무시한다.
            if(dist[now.dest] < now.cost) continue;
            
            for(Node next: adjList[now.dest]){
                if(dist[next.dest] > now.cost + next.cost){
                    dist[next.dest] = now.cost + next.cost;
                    pq.add(new Node(next.dest, dist[next.dest]));
                }
            }
        }
        
        int result = 0;
        // dist 배열에서 경로가 K이하인 노드의 개수를 구하여 반환
        for(int i = 1; i <= N; i++){
            if(dist[i] <= K) result++;
        }
        
        return result;
    }
}