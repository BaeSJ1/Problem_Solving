import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    private static class Node {
        int dest;
        int cost;

        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();  // 노드 개수
        int e = sc.nextInt();  // 엣지 개수
        int start = sc.nextInt();  // 시작 노드

        int[][] graph = new int[e][3];

        // 인접리스트 초기화
        ArrayList<Node>[] adjList = new ArrayList[v + 1];

        // 최소비용을 저장하는 배열
        int[] dist = new int[v + 1]; // 범위 조심 (0은 계속 무한대, 출력되면 안됨)

        // 초기는 무한대
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        for (int i = 0; i < v + 1; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int v2 = sc.nextInt();
            int cost = sc.nextInt();
            adjList[u].add(new Node(v2, cost));
        }

        // 그래프를 인접리스트로 변환
        for (int[] edge : graph) {
            adjList[edge[0]].add(new Node(edge[1], edge[2]));
        }

        // 우선순위 큐
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        // 시작노는 최소 비용이 0
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            // 현재 거리보다 긴 경로는 무시
            if (dist[now.dest] < now.cost) continue;

            for (Node next : adjList[now.dest]) {
                // 현재 배열에 저장되어 있는 최소 비용이 새롭게 구해본 비용 보다 크면, 더 작은 값으로 갱신
                if (dist[next.dest] > now.cost + next.cost) {
                    dist[next.dest] = now.cost + next.cost;
                    pq.add(new Node(next.dest, dist[next.dest]));
                }
            }
        }

        for (int i = 1; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }
}