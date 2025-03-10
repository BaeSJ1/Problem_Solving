import java.util.*;
class Solution {
    // 트리 정보를 배열로 관리
    // 부모 노드를 저장하기 위한 배열
    private static int[] parent;
    
    private static int find(int x){
        if(parent[x] == x){  // 루트노드일때
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }
    
    private static void union(int x, int y){
        // 서로의 root 찾아서 root끼리 연결하기
        int root1 = find(x);
        int root2 = find(y);
        parent[root2] = root1;
    }
    
    public int solution(int n, int[][] costs) {
        // 통행 비용에 따라 오름차순 정렬
        Arrays.sort(costs, (o1, o2) -> Integer.compare(o1[2], o2[2]));
        
        parent = new int[n];
        
        // 노드가 0부터로 예시에 있기 때문에 맞춰서 적는게 편함.
        // 부모노드 초기화
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        
        // 다리 개수가 노드 개수(n) - 1만큼만 사용되어 연결된다.
        int edges = 0;
        // 총 통행 비용
        int result = 0;
        
        for(int i = 0; i < costs.length; i++){
            // 연결할 수 있는 다리 다 사용하면 멈춘다.
            if(edges == n - 1){
                break;
            }
            
            // 루트 노드가 같지 않으면, 사이클 생성 안되므로, 합치고 경로를 압축해야한다(union)
            if(find(costs[i][0]) != find(costs[i][1])){
                union(costs[i][0], find(costs[i][1]));
                edges++;
                result += costs[i][2];
            }
        }
        
        return result;
        
    }
}