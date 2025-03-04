import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, HashMap<Integer, Integer>> genreMap = new HashMap<>();
        HashMap<String, Integer> totalMap = new HashMap<>();
        
        // 해시 값 채우기
        for(int i = 0; i < genres.length; i++){
            if(!genreMap.containsKey(genres[i])){  // HashMap안에 HashMap이 있는경우, 이 과정을 통해 NullException()을 방지해야한다.
                genreMap.put(genres[i], new HashMap<>());
            }
            genreMap.get(genres[i]).put(i, plays[i]);
            totalMap.put(genres[i], totalMap.getOrDefault(genres[i], 0) + plays[i]);
        }
        ArrayList<Integer> result = new ArrayList<>();
        
        ArrayList<String> sortedPlays = new ArrayList<>(totalMap.keySet());
        
        // 총 재생 수를 기준으로 정렬(HashMap은 순서가 보장되지 않으므로 List로 정렬 필요)
        // 총 재생 수가 가장 높은 장르부터 가장 늦은 장르로 내림차순 정렬이 되어있다.
        sortedPlays.sort((a, b) -> totalMap.get(b) - totalMap.get(a));
        
        // 총 재생 수가 가장 큰 장르부터 같은 장르별 내림차순으로 2개까지 저장
        for(String sortedPlay: sortedPlays){
            // 장르별 인덱스와 개수 필요(genreMap의 value값 가져옴(map의 객체가져옴 -> entrySet() 필요))
            ArrayList<Map.Entry<Integer, Integer>> playList = new ArrayList<>(genreMap.get(sortedPlay).entrySet());
            
            playList.sort((a, b) -> b.getValue() - a.getValue());
            
            // 최대 2곡 저장
            for(int i = 0; i < Math.min(2, playList.size()); i++){
                result.add(playList.get(i).getKey());  // getKey()까지하면 인덱스 값이 저장되는걸 인지해야한다.
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}