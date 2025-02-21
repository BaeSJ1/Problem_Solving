import java.util.Arrays;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] clothes = new int[n + 1]; // 1번부터 n번까지 사용

        // 모든 학생이 기본적으로 1벌 가지고 있음
        Arrays.fill(clothes, 1);

        // 도난당한 학생은 0벌
        for (int l : lost) {
            clothes[l]--;
        }

        // 여벌이 있는 학생은 2벌
        for (int r : reserve) {
            clothes[r]++;
        }

        // 체육복 빌려주기
        for (int i = 1; i <= n; i++) {
            if (clothes[i] == 0) { // 체육복이 없는 경우
                if (i > 1 && clothes[i - 1] == 2) { // 앞 번호 학생이 2벌이면 빌려줌
                    clothes[i]++;
                    clothes[i - 1]--;
                } else if (i < n && clothes[i + 1] == 2) { // 뒷 번호 학생이 2벌이면 빌려줌
                    clothes[i]++;
                    clothes[i + 1]--;
                }
            }
        }

        // 체육복이 1벌 이상 있는 학생 수 계산
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (clothes[i] > 0) {
                answer++;
            }
        }

        return answer;
    }
}