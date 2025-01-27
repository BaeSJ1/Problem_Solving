import java.util.ArrayDeque;
class Solution {
    public int solution(int[][] board, int[] moves) {
        ArrayDeque<Integer>[] stack = new ArrayDeque[board.length];

        for (int i = 0; i < stack.length; i++) {
            stack[i] = new ArrayDeque<>();
        }

        // 2차원 배열 값 스택에 할당
        for (int i = board.length - 1; i >= 0; i--) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j] > 0){
                    stack[j].push(board[i][j]);
                }
            }
        }

        ArrayDeque<Integer> resultStack = new ArrayDeque<>();
        int result = 0;

        for(int move: moves){
            if(!stack[move - 1].isEmpty()){
                int doll = stack[move-1].pop();
                if(!resultStack.isEmpty() && resultStack.peek() == doll){
                    resultStack.pop();
                    result += 2;
                } else{
                    resultStack.push(doll);
                }
            }
        }
        return result;
    }
}