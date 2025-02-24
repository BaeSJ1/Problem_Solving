import java.util.*;
class Solution {
    private static HashMap<Integer, HashMap<String, Integer>> courseMap;
    
    public String[] solution(String[] orders, int[] course) {
        courseMap = new HashMap<>();
        for(int c : course){
            courseMap.put(c, new HashMap<>());
        }
        
        for(String order: orders){
            char[] orderArray = order.toCharArray();
            Arrays.sort(orderArray);
            combinations(0, orderArray, "");
        }
        
        ArrayList<String> answer = new ArrayList<>();
        
        for (HashMap<String, Integer> count : courseMap.values()) {
            count.values()
                    .stream()
                    .max(Comparator.comparingInt(o -> o)) // ❸ 가장 빈도수가 높은 코스를 찾음
                    .ifPresent(cnt -> count.entrySet() // ❹ 코스에 대한 메뉴 수가 가능할 때만
                            .stream()
                            // ❺ 최소 2명 이상의 손님으로부터 주문된 단품메뉴 조합에 대해서만
                            .filter(entry -> cnt.equals(entry.getValue()) && cnt > 1)
                            // ❻ 코스 메뉴만 answer 리스트에 추가
                            .forEach(entry -> answer.add(entry.getKey())));
        }
        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }
    
    public static void combinations(int idx, char[] order, String result){
        if(courseMap.containsKey(result.length())){
            HashMap<String, Integer> map = courseMap.get(result.length());
            map.put(result, map.getOrDefault(result, 0) + 1);
        }
        
        for(int i = idx; i < order.length; i++){
            combinations(i + 1, order, result + order[i]);
        }
    }
}