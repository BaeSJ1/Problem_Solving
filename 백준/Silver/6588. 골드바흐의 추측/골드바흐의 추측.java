
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static final int MAX = 1000000;
    static boolean[] isPrime = new boolean[MAX + 1]; // 소수 여부 저장
    static ArrayList<Integer> primes = new ArrayList<>(); // 소수 리스트

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. 에라토스테네스의 체로 소수 생성
        generatePrimes();

        // 2. 입력 처리
        while (true) {
            int n = sc.nextInt();
            if (n == 0) { // 0 입력 시 종료
                break;
            }
            // 3. 골드바흐의 추측 결과 출력
            if (!goldbachConjecture(n)) {
                System.out.println("Goldbach's conjecture is wrong.");
            }
        }
    }

    // 에라토스테네스의 체
    static void generatePrimes() {
        for (int i = 2; i <= MAX; i++) {
            isPrime[i] = true; // 초기값 설정
        }

        for (int i = 2; i * i <= MAX; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= MAX; j += i) {
                    isPrime[j] = false; // 배수 제거
                }
            }
        }

        // 소수 리스트 저장
        for (int i = 2; i <= MAX; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
    }

    // 골드바흐의 추측 검증
    static boolean goldbachConjecture(int n) {
        for (int prime : primes) {
            if (prime >= n) break; // prime이 n 이상이면 탐색 종료
            int b = n - prime; // 두 번째 소수 계산
            if (isPrime[b]) { // b가 소수인지 확인
                System.out.println(n + " = " + prime + " + " + b);
                return true;
            }
        }
        return false; // 실패 시 false 반환
    }
}
