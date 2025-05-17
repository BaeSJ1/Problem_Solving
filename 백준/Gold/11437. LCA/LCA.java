

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static ArrayList<Integer>[] graph;
    private static int[] parent;
    private static int[] depth;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];

        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        parent = new int[n + 1];
        depth = new int[n + 1];
        visited = new boolean[n + 1];

        // 루트 노드 넣기
        dfs(1, 0);

        int m = Integer.parseInt(br.readLine());
        int[] result = new int[m];
        // 쌍들의 공통 조상 찾기
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            result[i] = lca(a, b);
        }

        for (int r : result) {
            System.out.println(r);
        }
    }

    // 트리 만들기
    private static void dfs(int node, int d) {
        visited[node] = true;
        depth[node] = d;

        for (int next : graph[node]) {
            if (!visited[next]) {
                parent[next] = node;
                dfs(next, d + 1);
            }
        }
    }

    private static int lca(int a, int b) {
        // 깊이가 다르면 맞춰주는 과정 필요 !!!!!!!!!!!!!!!
        while (depth[a] > depth[b]) a = parent[a];
        while (depth[b] > depth[a]) b = parent[b];

        // 조상찾기
        while (a != b) {
            a = parent[a];
            b = parent[b];
        }

        return a;
    }
}
