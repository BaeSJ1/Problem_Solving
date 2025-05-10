import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        int n = Integer.parseInt(br.readLine());

        ArrayDeque<Character> leftStack = new ArrayDeque<>();
        ArrayDeque<Character> rightStack = new ArrayDeque<>();

        for(char c: str.toCharArray()){
            // 초기에 커서는 문자열의 가장 오른쪽에 존재한다.
            leftStack.push(c);
        }

        for(int i = 0; i < n; i++){
            String rule = br.readLine();
            char cmd = rule.charAt(0);

            switch(cmd){
                // 왼쪽으로 커서 옮김. 이미 가장 왼쪽이면 그냥 왼쪽 그대로
                case 'L':
                    if(!leftStack.isEmpty()){
                        rightStack.push(leftStack.pop());
                    }
                    break;
                // 오른쪽
                case 'D':
                    if(!rightStack.isEmpty()){
                        leftStack.push(rightStack.pop());
                    }
                    break;
                case 'B':
                    if(!leftStack.isEmpty()){
                        leftStack.pop();
                    }
                    break;
                case 'P':
                    leftStack.push(rule.charAt(2));
                    break;
            }
        }

        // 출력 순서대로 출력해야함.
        while(!leftStack.isEmpty()){
            sb.append(leftStack.removeLast());
        }
        while(!rightStack.isEmpty()){
            sb.append(rightStack.pop());
        }

        System.out.println(sb);
    }


}
