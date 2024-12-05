import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {1, 1, 2, 2, 2, 8};
        int[] n = new int[6];
        for(int i = 0; i < n.length; i++){
            n[i] = sc.nextInt();
        }

        for(int i = 0; i < n.length; i++){
            System.out.print(arr[i] - n[i] + " ");
        }
    }
}
