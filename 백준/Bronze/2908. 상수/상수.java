import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        int a = Integer.parseInt(new StringBuilder().append(s[0]).reverse().toString());
        int b = Integer.parseInt(new StringBuilder().append(s[1]).reverse().toString());

        System.out.println(a > b ? a : b);
    }
}
