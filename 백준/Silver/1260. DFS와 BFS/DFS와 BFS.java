import java.util.*;

public class Main {
    static List<Integer>[] adjList;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();

        adjList = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        // 인접리스트 초기화
        for (int i = 0; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            adjList[a].add(b);
            adjList[b].add(a);
        }

        // 정렬
        for (int i = 0; i <= n; i++){
            Collections.sort(adjList[i]);
        }

        dfs(v);
        System.out.println();
        Arrays.fill(visited, false);
        bfs(v);

    }

    static void dfs(int node) {
        visited[node] = true;
        System.out.print(node + " ");
        for(int next: adjList[node]){
            if(!visited[next]) dfs(next);
        }
    }

    static void bfs(int node){
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(node);
        visited[node] = true;
        while(!queue.isEmpty()){
            int now = queue.poll();
            System.out.print(now + " ");
            for(int next: adjList[now]){
                if(!visited[next]){
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }
}