package programmers.level3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 양과_늑대 {
    public static void main(String[] args) {
        int[] info = {0,0,1,1,1,0,1,0,1,0,1,1};
        int[][] edges = {{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}};
        int answer = solution(info, edges);
        System.out.println(answer);
    }

    public static int solution(int[] info, int[][] edges) {
        Map<Integer, Node> map = new HashMap();

        for(int i=0; i<info.length; i++){
            map.put(i, new Node(i, info[i]==0 ? Type.SHEEP : Type.WOLF));
        }

        for(int[] edge : edges){
            Node parent = map.get(edge[0]);

            if(parent.left==null){
                parent.left = map.get(edge[1]);
            }else{
                parent.right = map.get(edge[1]);
            }
        }

        return 0;
    }

    static class Node{
        Node left;
        Node right;
        int value;
        Type type;

        public Node(int value, Type type) {
            this.value = value;
            this.type = type;
        }
    }

    static enum Type{
        SHEEP, WOLF;
    }
}
