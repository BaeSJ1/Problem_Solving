import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[] numbers;
    private static int[] op;
    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        numbers = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        op = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        calculate(numbers[0], 1, n);

        System.out.println(max);
        System.out.println(min);
    }

    private static void calculate(int num, int index, int n) {
        if (index == n) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (op[i] > 0) {
                op[i]--;

                int next = num;
                switch (i){
                    case 0: next += numbers[index]; break;
                    case 1: next -= numbers[index]; break;
                    case 2: next *= numbers[index]; break;
                    case 3:
                        if (next < 0) {
                            next = -(-next / numbers[index]);
                        } else {
                            next /= numbers[index];
                        }
                        break;
                }
                
                calculate(next,index + 1, n);
                
                op[i]++; // 백트래킹
            }
        }
    }
}
