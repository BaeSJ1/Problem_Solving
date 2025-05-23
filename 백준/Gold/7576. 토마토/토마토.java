import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    private static ArrayDeque<int[]> queue = new ArrayDeque<>();
    private static int n, m;

    private static int[][] box;
    private static int[][] results;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        box = new int[n][m];

        results = new int[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                box[i][j] = Integer.parseInt(st.nextToken());
                if(box[i][j] == 1){
                    queue.add(new int[]{i, j});
                }
            }
        }

        bfs();
        
        int result = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(box[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
                result = Math.max(result, results[i][j]);
            }
        }

        System.out.println(result);
    }

    private static void bfs(){
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                if(box[nx][ny] == 0){
                    box[nx][ny] = 1;
                    // 상, 하, 좌, 우 토마토 익히기(익은 날)
                    results[nx][ny] = results[x][y] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }
}
