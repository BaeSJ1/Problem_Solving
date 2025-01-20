import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int solution(String dirs) {
        HashMap<Character, int[]> location = new HashMap<>();
        HashSet<String> result = new HashSet<>();
        
        location.put('U', new int[]{0, -1});
        location.put('D', new int[]{0, 1});
        location.put('R', new int[]{1, 0});
        location.put('L', new int[]{-1, 0});
        
        int x = 0; 
        int y = 0;
        
        for(int i = 0; i < dirs.length(); i++){
            int[] offset = location.get(dirs.charAt(i));
            
            int nx = x + offset[0];
            int ny = y + offset[1];
            
            if (-5 > nx || nx > 5 || -5 > ny || ny > 5) continue;
            
            result.add(nx + " " + ny + " " + x + " " + y);
            result.add(x + " " + y + " " + nx + " " + ny);
            
            x = nx;
            y = ny;
        }
        
        return result.size() / 2;
    }
}