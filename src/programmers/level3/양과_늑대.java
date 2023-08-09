package programmers.level3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class 양과_늑대 {
    public static void main(String[] args) {
        int[] info = {0,0,1,1,1,0,1,0,1,0,1,1};
        int[][] edges = {{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}};
        int answer = solution(info, edges);
        System.out.println(answer);
    }

    public static int solution(int[] info, int[][] edges) {
        if(info[0]==1) return 0;

        Map<Integer, Node> map = new HashMap<>();

        for(int i=0; i<info.length; i++){
            map.put(i, new Node(info[i]==0? Type.SHEEP : Type.WOLF));
        }

        for(int[] edge : edges){
            Node parent = map.get(edge[0]);
            Node child = map.get(edge[1]);

            parent.addNode(child);
            child.parent = parent;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(map.get(0));
        int sheepCount = 0;

        while(!queue.isEmpty()){
            Node temp = queue.poll();
            sheepCount++;
            temp.visit = true;

            Node leftNode = temp.left;
            Node rightNode = temp.right;

            if(leftNode!=null && leftNode.type==Type.SHEEP){
                queue.add(leftNode);
            }
            if(rightNode!=null && rightNode.type==Type.SHEEP){
                queue.add(rightNode);
            }
        }

        for(int key : map.keySet()){
            Node temp = map.get(key);

            if(temp.visit)  continue;

            if(temp.parent.type==Type.WOLF){
                queue.add(temp);
            }
        }



        return sheepCount;
    }

    static class Node{
        Node parent;
        Node left;
        Node right;
        Type type;
        boolean visit;

        public Node(Type type) {
            this.type = type;
        }

        public void addNode(Node node) {
            if(left==null){
                left = node;
            }else{
                right = node;
            }
        }


    }

    enum Type{
        SHEEP, WOLF;
    }
}
