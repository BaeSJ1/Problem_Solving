import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().toUpperCase();
        int[] arr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            if ('A' <= s.charAt(i) && s.charAt(i) <= 'Z') {
                arr[s.charAt(i) - 'A']++;
            }
        }

        int max = 0;
        int index = 0;
        boolean duplication = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                index = i;
                duplication = false;
            } else if (arr[i] == max) {
                duplication = true;
            }
        }
        System.out.println(duplication? "?" : (char)(index + 'A'));
    }
}
