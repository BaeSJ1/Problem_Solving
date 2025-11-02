//13:39 - 14:17

import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> countMap = new HashMap<>();
        Map<String, List<int[]>> musicMap = new HashMap<>();
            
        /// 1. 가장 많이 재생된 장르를 계산한다.(내림차순)
        /// Map<장르, 재생수>
        for(int i = 0; i < genres.length; i++){
            String genre = genres[i];
            int play = plays[i];
            
            countMap.put(genre, countMap.getOrDefault(genre, 0) + play);
            musicMap.computeIfAbsent(genre, k -> new ArrayList<>()).add(new int[]{i, play});
        }
        
        // map 정렬은 list로 바꾸고 해야한다.
        List<String> genreOrder = new ArrayList<>(countMap.keySet());
        genreOrder.sort((a, b) -> countMap.get(b) - countMap.get(a));
        
        
        /// 2. 장르 내에 가장 많이 재생된 노래를 계산한다.(내림차순)
        /// - 재생횟수가 같은 노래는 인덱스가 더 작은걸 넣어야한다.
        /// - Map<장르, {인덱스, 재생횟수}>
        List<Integer> result = new ArrayList<>();
        
        for(String genre: genreOrder){
            List<int[]> songs = musicMap.get(genre);
            
            songs.sort((a, b) -> {
                if(a[1] == b[1]) return a[0] - b[0]; // 인덱스 기준 오름차순
                       return b[1] - a[1];
            });
            
            /// 3. 위에서 계산한걸 장르별로 2개씩! 담는다.
            result.add(songs.get(0)[0]);
            // 한 장르에 노래 1개 초과이면 1개 더 담아야함.
            if(songs.size() > 1){
                result.add(songs.get(1)[0]);
            }
        }
        
        // list -> int[] 로 변환
        return result.stream().mapToInt(i -> i).toArray();
    }
}