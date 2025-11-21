import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 1; t <= 10; t++) {
            int dump = Integer.parseInt(br.readLine());
            List<Integer> list = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());

            while(st.hasMoreTokens()){
                list.add(Integer.parseInt(st.nextToken()));
            }

            // 케이스별로 제일 큰 수, 작은 수 찾기
            for(int i = 0; i < dump; i++){
                // 오름차순
                list.sort((a, b) -> b - a);
                list.set(0, list.get(0) - 1);
                list.set(list.size() - 1, list.get(list.size() - 1) + 1);
            }

            list.sort((o1, o2) -> o2 - o1);
            int result = list.get(0) - list.get(list.size() - 1);
            System.out.println("#" + t + " " + result);
        }
    }
}