import java.util.ArrayDeque;
class Solution {
    public int solution(int[][] board, int[] moves) {
        ArrayDeque<Integer>[] stack = new ArrayDeque[board.length];
        int result = 0;
        
        for(int i = 0; i < board.length; i++){
            stack[i] = new ArrayDeque<>();
        }
        
        for(int i = board.length - 1; i >= 0; i--){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] > 0){
                    stack[j].push(board[i][j]);  // 0 ~ 4번 레일에 값 할당
                }
            }
        }
        
        
        ArrayDeque<Integer> resultStack = new ArrayDeque<Integer>();
        
        for(int move: moves){
            if(!stack[move - 1].isEmpty()){
                int doll = stack[move - 1].pop();
                
                // 결과 스택에 동일한 값이 top에 존재한다면
                if(!resultStack.isEmpty() && doll == resultStack.peek()){
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