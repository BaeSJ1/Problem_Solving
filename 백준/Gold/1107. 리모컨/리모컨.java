import java.util.Scanner;

public class Main {
    static boolean[] broken = new boolean[10];

    static int possible(int channel) {
        int len = 0;
        if (channel == 0) {
            if (broken[0]) return 0;
            else return 1;
        }
        while (channel > 0) {
            if (broken[channel % 10]) {
                return 0;
            }
            len++;
            channel /= 10;
        }
        return len;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();  // 이동할 채널
        int m = sc.nextInt();  // 고장난 버튼 개수
        int result = 0;  // 버튼 누른 최소 횟수
        //  고장난 숫자 버튼 번호
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            broken[x] = true;
        }

        // + or - 버튼으로만 이동하는 횟수(현재 위치 100)
        result = n - 100;
        if (result < 0) result = -result;

        // 숫자버튼 누르고 + or - 버튼 누르는 최소 횟수 구하기
        for (int i = 0; i <= 1000000; i++) {  // 예제3을 보면 n의 범위를 초과해서 리모컨 번호를 조합할 수 있다.
            int channel = i;
            int len = possible(channel);  // 채널길이만큼 버튼을 누른다.
            if (len > 0) {
                int press = n - channel;
                if (press < 0) press = -press;
                if (result > len + press) {  // 숫자 버튼 누를 수 있으면, 숫자 버튼과 +나- 버튼 최소 횟수 구한다
                    result = len + press;
                }
            }

        }
        System.out.println(result);
    }
}
