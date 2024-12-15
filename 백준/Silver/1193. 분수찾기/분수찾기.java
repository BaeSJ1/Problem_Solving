import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int a = 1;
        int b = 1;
        int count = 1;

        if (x == 1) {
            System.out.println(a + "/" + b);
        } else {
            boolean upgrade = false;
            while (true) {
                if (x == count) break;
                else {
                    if (a == 1) {
                        if (!upgrade) {
                            count++;
                            b += 1;
                            upgrade = true;
                        } else {
                            while(b != 1 && x != count){
                                if(upgrade == true) upgrade = false;
                                a++;
                                b--;
                                count++;
                            }
                        }
                    } else if (b == 1) {
                        if (!upgrade) {
                            count++;
                            a += 1;
                            upgrade = true;
                        } else {
                            while(a != 1 && x != count){
                                if(upgrade == true) upgrade = false;
                                a--;
                                b++;
                                count++;
                            }

                        }
                    }
                }

            }
            System.out.println(a + "/" + b);
        }
    }
}
