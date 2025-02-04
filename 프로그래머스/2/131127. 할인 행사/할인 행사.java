import java.util.HashMap;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        HashMap<String, Integer> wantMap = new HashMap<>();
        for(int i = 0; i < want.length; i++){
            wantMap.put(want[i], number[i]);
        }
        
        // 총 일수를 계산
        int count = 0;
        for(int i = 0; i < discount.length - 9; i++){
            HashMap<String,Integer> discount10d = new HashMap<>();
            
            for(int j = i; j < i + 10; j++){
                // 할인 상품이 사려는 품목(wantMap)에 존재한다면
                if(wantMap.containsKey(discount[j])){
                    // 할인상품을 hashmap에 추가한다. hashmap에 존재하지 않는다면, 0+1 = 1저장
                    // 이미 존재한다면, +1씩 누적
                    discount10d.put(discount[j], discount10d.getOrDefault(discount[j], 0) + 1);
                }
            }
            
            if(discount10d.equals(wantMap))
                count++;
        }
        return count;
    }
}