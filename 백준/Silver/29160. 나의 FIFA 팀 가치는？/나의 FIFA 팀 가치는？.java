
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 인덱스가 포지션 번호, 안의 값이 같은 포지션 별 선수가치 -> 이중에서 가장 높은 걸 뽑음
        PriorityQueue<Integer>[] pq = new PriorityQueue[12];

        // 우선순위 큐 초기화
        for(int i = 1; i < 12; i++){
            pq[i] = new PriorityQueue<>(Collections.reverseOrder());
        }

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int position = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            pq[position].add(value);
        }

        // 선발 선수 가치 -1 하고, 다시 가치 비교해서 가장 높은 가치 뽑음.
        for(int i = 0; i < k; i++){
            for(int p= 1; p <= 11; p++){
                if(!pq[p].isEmpty()){ // 포지션 사람 없으면 그냥 공백 아니면 선발 선수 가치 -1
                    int select = pq[p].poll();
                    if(select < 1){
                        pq[p].add(select);
                    } else {
                        pq[p].add(select - 1);
                    }
                }
            }
        }
        int result = 0;
        for(int i = 1; i < 12; i++){
            if(!pq[i].isEmpty()){
                result += pq[i].peek();
            }
        }

        System.out.println(result);
    }
}
