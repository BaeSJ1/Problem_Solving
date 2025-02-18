import java.util.*;
class Solution {
    private static boolean initValid(int nx, int ny){
        return 0 <= nx && nx < 11 && 0 <= ny && ny < 11;
    }
    public int solution(String dirs) {
        HashMap<Character, int[]> location = new HashMap<>();
        location.put('U', new int[]{0,1});
        location.put('D', new int[]{0,-1});
        location.put('R', new int[]{1,0});
        location.put('L', new int[]{-1,0});
        
        int x = 5, y = 5;
        HashSet<String> s = new HashSet<>();
        for(int i = 0; i < dirs.length(); i++){
            // 입력받은 값을 한글자씩 반환
            int[] offset = location.get(dirs.charAt(i));
            int nx = x + offset[0];
            int ny = y + offset[1];
            
            if(!initValid(nx, ny)) continue;
            
            s.add(x + " " + y + " " + nx + " " + ny);
            s.add(nx + " " + ny + " " + x + " " + y);
            
            x = nx;
            y = ny;
        }
        return s.size()/2;
    }
}