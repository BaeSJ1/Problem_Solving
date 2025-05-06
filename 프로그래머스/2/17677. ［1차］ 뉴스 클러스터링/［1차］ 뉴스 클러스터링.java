/*
- 알파벳은 영문자만 허용, 특수문자는 허용되지 않는다.
- 자카드 유사도 =  (교집합 / 합집합) * 65536 -> 소수점 버리고 only 정수
- A, B 모두 공집합일 경우 자카드 유사도가 1이다.
- 다중집합도 고려해야함. (min, max 이용)
1. 입력
    1) 대문자 소문자 구분 없음(소문자 통일)
    2) 영문자가 아닌 문자 버리기
2. HashMap으로 알파벳별 작은 수 count
    1) 합집합은 각자 문자 수의 합이 될꺼고
    2) 교집합은 키 별로 min(str1, str2)이 될 것이다.
    3) 다중집합은 두글자씩 끊어서 다중집합 가능
    
    * 여기서 다중집합 특수문자 먼저 버려야되나?..
    -> ab+가 입력으로 들어오면 b+는 버림.
3. 출력
*/

import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        // 버릴 문자 얼마나 될지 모르니까 ArrayList
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        
        for(int i = 0; i < str1.length() - 1; i++){
            String pair = str1.substring(i, i + 2);
            if(pair.matches("[a-z]{2}")){
                list1.add(pair);
            }
        }
        
        for(int i = 0; i < str2.length() - 1; i++){
            String pair = str2.substring(i, i + 2);
            if(pair.matches("[a-z]{2}")){
                list2.add(pair);
            }
        }
        
        // 각 원소 수 세기
        // 원소, 원소 개수(min)
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        
        for(String s: list1){
            map1.put(s, map1.getOrDefault(s, 0) + 1);
        }
        
        for(String s: list2){
            map2.put(s, map2.getOrDefault(s, 0) + 1);
        }
        
        // 검색
        // 양쪽에 저장된 원소를 하나로 모아서 비교해야함.
        HashSet<String> allKeys = new HashSet<>();
        allKeys.addAll(map1.keySet());
        allKeys.addAll(map2.keySet());
        
        int intersection = 0;
        int union = 0;
        
        for(String key: allKeys){
            int count1 = map1.getOrDefault(key, 0);
            int count2 = map2.getOrDefault(key, 0);
            // 교집합은 min으로
            intersection += Math.min(count1, count2);
            union += Math.max(count1, count2);
        }
        
        // 둘다 공집합일 때 1
        if(union == 0) return 65536;
        
        return (int)((double)intersection / union * 65536);
    }
}