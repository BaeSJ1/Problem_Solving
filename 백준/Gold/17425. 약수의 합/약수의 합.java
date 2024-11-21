
import java.io.*;

public class Main {
    static final int MAX = 1000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long[] f = new long[MAX + 1];
        long[] g = new long[MAX + 1];
        for(int i = 1; i <= MAX; i++) {
            f[i] = 1;
        }
        for(int i = 2; i <= MAX; i++) {
            for (int j = 1; i * j <= MAX; j++) {
                f[i*j] += i;
            }
        }
        for(int i = 1; i <= MAX; i++){
            g[i] = g[i-1] + f[i];
        }
        int test_case = Integer.parseInt(br.readLine());
        while (test_case-- >  0){
            int tc = Integer.parseInt(br.readLine());
            bw.write(g[tc] + "\n");
        }

        bw.flush();
    }
}