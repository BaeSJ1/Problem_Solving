import java.util.*;

public class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, HashMap<Integer, Integer>> genreMap = new HashMap<>();
        Map<String, Integer> playMap = new HashMap<>();

        // ❶ 장르별 총 재생 횟수와 곡 정보 저장
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];

            // 장르별 총 재생 횟수 누적
            playMap.put(genre, playMap.getOrDefault(genre, 0) + play);

            // 장르별 (고유번호, 재생 횟수) 저장
            genreMap.computeIfAbsent(genre, k -> new HashMap<>()).put(i, play);
        }

        List<Integer> answer = new ArrayList<>();

        // ❷ 장르별 총 재생 횟수 기준으로 정렬
        List<String> sortedGenres = new ArrayList<>(playMap.keySet());
        sortedGenres.sort((a, b) -> playMap.get(b) - playMap.get(a));

        // ❸ 각 장르에서 재생 횟수 기준으로 최대 2곡 선택
        for (String genre : sortedGenres) {
            List<Map.Entry<Integer, Integer>> songs = new ArrayList<>(genreMap.get(genre).entrySet());
            songs.sort((a, b) -> b.getValue() - a.getValue()); // 재생 횟수 기준 내림차순 정렬

            // 최대 2곡 추가
            for (int i = 0; i < Math.min(2, songs.size()); i++) {
                answer.add(songs.get(i).getKey());  // 곡 고유번호 추가
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
