import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] arr = new String[5][15];
        char[][] c = new char[5][15];

        for (int i = 0; i < 5; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < s.length(); j++) {
                c[i][j] = s.charAt(j);
            }
        }

        for (int j = 0; j < 15; j++) {
            for (int i = 0; i < 5; i++) {
                if (c[i][j] == '\u0000') continue;  // char형 배열은 null값을 가질 수 없다. '\u0000(널문자, Unicode 값 0)' 사용
                System.out.print(c[i][j]);
            }
        }
    }
}