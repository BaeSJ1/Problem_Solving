import java.util.*;

class Solution {
    private static int board;
    private static boolean[] width;
    private static boolean[] diagonal1; // 오른쪽 위->왼쪽 아래
    private static boolean[] diagonal2; // 왼쪽 위->오른쪽 아래
    
    public int solution(int n) {
        board = n;
        width = new boolean[n];
        diagonal1 = new boolean[n * 2];
        diagonal2 = new boolean[n * 2];
        int result = queen(0);
        return result;
    }
    
    // 퀸이 서로 공격할 수 없는 위치에 놓이는 경우의 수를 구하는 함수
    private static int queen(int y){
        int result = 0;
        if(y == board) result++;
        else{
            // 현재 행에서 퀸이 놓일 수 있는 모든 위치를 시도
            for(int i = 0; i < board; i++){
                // 해당 위치에 이미 퀸이 있는 경우, 대각선상에 퀸이 있는 경우 스킵
                if(width[i] || diagonal1[i + y] || diagonal2[i - y + board]) continue;
                
                // 해당 위치에 퀸을 놓음
                width[i] = diagonal1[i + y] = diagonal2[i - y + board] = true;
                
                // 다음 행으로 이동
                result += queen(y + 1);
                
                width[i] = diagonal1[i + y] = diagonal2[i - y + board] = false;
            }
        }
        return result;    
    }
}