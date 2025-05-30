
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int n, m, x;
    private static int INF = Integer.MAX_VALUE;

    private static ArrayList<Node>[] graph;
    private static ArrayList<Node>[] reverseGraph;

    private static class Node {
        int edge;
        int cost;

        public Node(int edge, int cost){
            this.edge = edge;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        reverseGraph = new ArrayList[n + 1];

        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            graph[from].add(new Node(to, time));
            reverseGraph[to].add(new Node(from, time));
        }

        int[] distFromX = dijkstra(graph, x);
        int[] distToX = dijkstra(reverseGraph, x);

        int result = 0;
        for(int i = 1; i <= n; i++){
            int totalTime = distToX[i] + distFromX[i];
            result = Math.max(result, totalTime);
        }

        System.out.println(result);
    }

    private static int[] dijkstra(ArrayList<Node>[] graph, int start){
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.cost));
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node now = pq.poll();

            for(Node next: graph[now.edge]){
                if(dist[next.edge] > dist[now.edge] + next.cost){
                    dist[next.edge] = dist[now.edge] + next.cost;
                    pq.add(new Node(next.edge, dist[next.edge]));
                }
            }
        }
        return dist;
    }
}
