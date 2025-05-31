
import java.util.Scanner;

public class Main {
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    private static int r, c;
    private static char[][] arr;

    // 어차피 중복처리 알파벳으로 되니까 두개 필요없음
//    private static boolean[][] visited;
//    private static boolean[] alphaVisited = new boolean[26];

    private static boolean[] visited = new boolean[26];

    private static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        sc.nextLine();

        arr = new char[r][c];

        for(int i = 0; i < r; i++){
            String line = sc.nextLine();
            for(int j = 0; j < c; j++){
                arr[i][j] = line.charAt(j);
            }
        }

        dfs(0, 0, 1);

        System.out.println(result);
    }

    private static void dfs(int x, int y, int count){
        visited[arr[x][y] - 'A'] = true;

        // 우리가 구하는 건 최대 이동
        result = Math.max(result, count);

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= r || ny >= c) continue;

            // 이미 방문한 알파벳 아니면 dfs
            if(!visited[arr[nx][ny] - 'A']){
                dfs(nx, ny, count + 1);
            }
        }
        visited[arr[x][y] - 'A'] = false;
    }
}
