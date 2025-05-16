import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        HashMap<String, String> map = new HashMap<>();
        
        // 판매자, 추천자
        for(int i = 0; i < enroll.length; i++){
            map.put(enroll[i], referral[i]);
        }
        
        // 판매자, 이익
        HashMap<String, Integer> total = new HashMap<>();
        for(int i = 0; i < seller.length; i++){
            int money = amount[i] * 100;
            
            // 이익에 대한 사람 추적
            String person = seller[i];
                
            while(money >= 1 && !person.equals("-")){
                total.put(person, total.getOrDefault(person, 0) + money - money / 10);
                money /= 10;
                // 다음 추천인으로 이동
                person = map.get(person);
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