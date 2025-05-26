import java.util.Scanner;

public class Main {
    private static int m, n;
    private static int[][] arr;
    private static boolean[][] visited;

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        while(tc-- >0){
            m = sc.nextInt();
            n = sc.nextInt();
            int total = sc.nextInt();

            arr = new int[m][n];
            visited = new boolean[m][n];

            for(int i = 0; i < total; i++){
                int x = sc.nextInt();
                int y = sc.nextInt();
                // 배추가 있는 자리 저장
                arr[x][y] = 1;
            }
            
            int bug = 0;
            
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    // 배추 탐색
                    if(arr[i][j] == 1 && !visited[i][j]){
                        // 주변에 무리 한번에 탐색
                        dfs(i, j);
                        bug++;
                    }
                }
            }

            System.out.println(bug);
        }
    }

    private static void dfs(int x, int y){
        visited[x][y] = true;
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= m || ny >= n) continue;

            if(arr[nx][ny] == 1 && !visited[nx][ny]){
                dfs(nx, ny);
            }
        }
    }
}
