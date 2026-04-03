import java.util.*;

/***
 * DFS로 접근(촌수면 DFS로 접근해야한다고 생각했지만 DFS XX) => BFS
 * 최단거리 이므로 BFS로 접근해야한다. (몇 촌이냐 = 몇 번 만에 연결되냐)
 * 방향 설정도 틀렸었음. 양방향이다.
 */

public class Main {
    static List<Integer>[] adjList;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int e = sc.nextInt();

        adjList = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for(int i = 0; i < n + 1; i++){
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            // 방향이 정해져있음. XXX -> 단방향 아니고 양방향임. 어디서 시작할지 모름. 자식부터 시작할 수도 있음.
            adjList[a].add(b);
            adjList[b].add(a);
        }

        System.out.println(bfs(x, y));
    }

    static int bfs(int start, int target){
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{start, 0});
        visited[start] = true;

        while(!queue.isEmpty()){
            int[] now = queue.poll();
            if(now[0] == target) return now[1];
            for(int next: adjList[now[0]]){
                if(!visited[next]){
                    visited[next] = true;
                    queue.add(new int[]{next, now[1] + 1});
                }
            }
        }
        return -1;
    }
}