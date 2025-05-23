import java.util.*;
class Solution {
    private static class Node{
        // 노드의 좌표, 번호 저장
        int x, y, num;
        Node left, right;
        
        public Node(int num, int x, int y){
            this.num = num;
            this.x = x;
            this.y = y;
        }
        
    }
    
    // 이진 트리 생성 메서드
    private static Node makeBT(int[][] nodeinfo){
        Node[] nodes = new Node[nodeinfo.length];
        for(int i = 0; i < nodeinfo.length; i++){
            nodes[i] = new Node(i+1, nodeinfo[i][0], nodeinfo[i][1]);
        }
        
        // y 기준으로 내림차순 정렬, y가 같다면 x를 기준으로 오름차순 정렬
        Arrays.sort(nodes, (o1, o2) -> {
            if(o1.y == o2.y)
                return Integer.compare(o1.x, o2.x);
            return Integer.compare(o2.y, o1.y);
        });
        
        Node root = nodes[0];
        
        for(int i = 1; i < nodes.length; i++){
            Node parent = root;
            while(true){
                // 부모 노드의 x좌표가 더 크면 왼쪽으로
                if(nodes[i].x < parent.x){
                    if(parent.left == null){
                        parent.left = nodes[i];
                        break;
                    } else{
                        parent = parent.left;
                    }
                } else{ // 부모 노드의 x좌표가 더 작거나 같으면 오른쪽으로
                    if(parent.right == null){
                        parent.right = nodes[i];
                        break;
                    } else{
                        parent = parent.right;
                    }
                }
            }
        }
        
        return nodes[0];
    }
    
    // 전위 순회 메서드
    private static void preOrder(Node curr, ArrayList<Integer> result){
        if(curr == null){
            return;
        }
        result.add(curr.num);
        preOrder(curr.left, result);
        preOrder(curr.right, result);
    }
    
    // 후위 순회 메서드
    private static void postOrder(Node curr, ArrayList<Integer> result){
        if(curr == null){
            return;
        }
        postOrder(curr.left, result);
        postOrder(curr.right, result);
        result.add(curr.num);
    }
    
    public int[][] solution(int[][] nodeinfo) {
        Node root = makeBT(nodeinfo);  // 이진트리 생성
        ArrayList<Integer> preOrderList = new ArrayList<>();
        // 전위 순회
        preOrder(root, preOrderList);
        ArrayList<Integer> postOrderList = new ArrayList<>();
        // 후위 순회
        postOrder(root, postOrderList);
        
        int[][] result = new int[2][nodeinfo.length];
        result[0] = preOrderList.stream().mapToInt(Integer::intValue).toArray();
        result[1] = postOrderList.stream().mapToInt(Integer::intValue).toArray();
        
        return result;
    }
}