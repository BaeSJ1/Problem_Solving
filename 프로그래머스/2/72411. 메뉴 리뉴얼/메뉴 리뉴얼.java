import java.util.*;

class Solution {
    // {코스 구성 개수 : {코스 구성 -> 주문이 들어온 횟수}}
    private static HashMap<Integer, HashMap<String, Integer>> courseMap;
    
    public String[] solution(String[] orders, int[] course) {
        courseMap = new HashMap<>();
        for(int c: course){
            courseMap.put(c, new HashMap<>());
        }
        
        for(String order: orders){
            // 배열로 넘겨야지 한글자씩 검사가능
            char[] orderArray = order.toCharArray();
            // AB = BA 같게 처리하기 위해서
            Arrays.sort(orderArray);
            combinations(0, orderArray, "");
        }
        
        ArrayList<String> result = new ArrayList<>();
        
        for(HashMap<String, Integer> count: courseMap.values()){
            count.values().stream()
                .max(Comparator.comparingInt(o -> o))
                .ifPresent(cnt -> count.entrySet().stream()
                          .filter(entry -> cnt.equals(entry.getValue()) && cnt > 1)
                          .forEach(entry -> result.add(entry.getKey())));
        }
        Collections.sort(result);
        return result.toArray(new String[0]);
    }
    
    private static void combinations(int idx, char[] order, String result){
        // courseMap의 Key는 구성하려는 코스 개수이다.
        // 구성하려는 코드 개수와 같다면 주문 몇번 들어온지 센다.
        if(courseMap.containsKey(result.length())){
            HashMap<String, Integer> map = courseMap.get(result.length());
            map.put(result, map.getOrDefault(result, 0) +1);
        }
        
        for(int i = idx; i < order.length; i++){
            combinations(i + 1, order, result + order[i]);
        }
    }
}