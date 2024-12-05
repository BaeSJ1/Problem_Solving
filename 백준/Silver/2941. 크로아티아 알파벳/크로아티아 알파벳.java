import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            // 'c=' 또는 'c-'
            if (s.charAt(i) == 'c' && i + 1 < s.length()) {
                if (s.charAt(i + 1) == '=' || s.charAt(i + 1) == '-') {
                    i++;
                }
            }
            // 'dz=' 또는 'd-'
            else if (s.charAt(i) == 'd' && i + 1 < s.length()) {
                if (s.charAt(i + 1) == '-') {
                    i++;
                } else if (s.charAt(i + 1) == 'z' && i + 2 < s.length()) {
                    if (s.charAt(i + 2) == '=') {
                        i += 2;
                    }
                }
            }
            // 'lj' 또는 'nj'
            else if ((s.charAt(i) == 'l' || s.charAt(i) == 'n') && i + 1 < s.length()) {
                if (s.charAt(i + 1) == 'j') {
                    i++;
                }
            }
            // 's=' 또는 'z='
            else if ((s.charAt(i) == 's' || s.charAt(i) == 'z') && i + 1 < s.length()) {
                if (s.charAt(i + 1) == '=') {
                    i++;
                }
            }

            count++;
        }

        System.out.println(count);
    }
}
