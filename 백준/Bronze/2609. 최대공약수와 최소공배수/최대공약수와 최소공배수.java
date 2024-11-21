import java.util.Scanner;

/*
    GCD(a, b) = GCD(b,r) //유클리드 호제법(재귀 OR while 쓰는 방법)
    lcm = r * (a/r) * (b/r)
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();  //24
        int b = sc.nextInt();  //18

        int gcd_value = gcd(a, b);
        int gcd_value2 = gcd2(a, b);

        int lcm_value = gcd_value * (a / gcd_value) * (b/ gcd_value);
        System.out.println(gcd_value);
        System.out.println(lcm_value);

    }

    private static int gcd(int a, int b) {
        while (b != 0){
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    private static int gcd2(int a, int b){
        if (b == 0){
            return a;
        } else{
            return gcd2(b, a%b);
        }
    }
}