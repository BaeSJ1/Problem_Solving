import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        // 판매자, 추천자 
        HashMap<String, String> map = new HashMap<>(); 
        for(int i = 0; i < enroll.length; i++){
            map.put(enroll[i], referral[i]);
        }
        
        // 수익 계산
        // 판매자, 수익
        HashMap<String, Integer> total = new HashMap<>();
        for(int i = 0; i < seller.length; i++){
            int money = amount[i] * 100;
            String curName = seller[i];
            while(money > 0 && !curName.equals("-")){
                total.put(curName, total.getOrDefault(curName, 0) + money - (money / 10));
                curName = map.get(curName);
                // 추천자는 10%의 이익을 가져간다.
                money /= 10; 
            }
        }
        
        // 결과를 int배열로 반환
        ArrayList<Integer> result = new ArrayList<>();
        for(String e: enroll){
            result.add(total.getOrDefault(e, 0));
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}