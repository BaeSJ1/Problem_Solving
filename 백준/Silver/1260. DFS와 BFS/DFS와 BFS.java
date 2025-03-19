import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main{
    private static ArrayList<Integer>[] adjList;
    private static boolean[] visited;
    private static ArrayList dfsResult = new ArrayList<>();
    private static ArrayList bfsResult = new ArrayList<>();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();

        adjList = new ArrayList[n + 1];

        // 인접리스트 초기화
        for(int i = 0; i < n + 1; i++){
            adjList[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            adjList[a].add(b);
            //양방향
            adjList[b].add(a);
        }

        for(int i = 1; i <= n; i++){
            Collections.sort(adjList[i]);
        }

        visited = new boolean[n + 1];
        dfs(v);

        visited = new boolean[n + 1];
        bfs(v);

        dfsResult.forEach(num -> System.out.print(num + " "));
        System.out.println();

        bfsResult.forEach(num -> System.out.print(num + " "));
        System.out.println();
    }

    private static void dfs(int start){
        visited[start] = true;
        dfsResult.add(start);
        for(int next: adjList[start]){
            if(!visited[next]){
                dfs(next);
            }
        }
    }

    private static void bfs(int start){
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start] = true;
        while(!queue.isEmpty()){
            int now = queue.poll();
            bfsResult.add(now);
            for(int next: adjList[now]){
                if(!visited[next]){
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }

}