// 문자 조합 만들기
// 소수인지 판단
import java.util.*;

class Solution {
    
    static Set<Integer> set = new HashSet<>();
    static char[] arr;
    static boolean[] used;
        
    public int solution(String numbers) {
        arr = numbers.toCharArray();
        used = new boolean[numbers.length()];
        
        // 1자리 ~ numbers의 길이만큼 문자 만든다. 
        for(int i = 1; i <= numbers.length(); i++){
            dfs("", i);
        }
        
        int result = 0;
        // 소수인지 확인
        for(int num: set){
            if(isPrime(num)){
                result++;
            }
        }
        return result;
    }
    
    
    private void dfs(String cur, int targetLen){
        // 목표 자릿수면 set에 담음
        if(cur.length() == targetLen){
            set.add(Integer.parseInt(cur));
            return;
        }
        
        // 다음꺼 만들어서 dfs 해봐야함
        // 1,2,3 있을때 11같은거 만들어지면 안됨 -> 백트래킹 / 그러면 2에서 가지 뻗을때 이거 바로 직전 dfs used[] 안에 다 false로 되어야함
        for(int i = 0; i < arr.length; i++){
            // 방문하지 않은거면
            if(!used[i]){
                used[i] = true;
                dfs(cur + arr[i], targetLen);
                
                // 백트래킹
                used[i] = false;
            }
        }
    }
    
    private boolean isPrime(int num){
        // 에라토스테네스의 체
        if(num <= 1) return false;
        
        for(int i = 2; i * i <= num; i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}