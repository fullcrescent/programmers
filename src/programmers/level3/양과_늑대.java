package programmers.level3;

import java.util.*;

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

        int answer = map.get(0).count();
        int wolfCount = 0;

        Queue<Node> queue = new PriorityQueue<>();

        for(int key : map.keySet()){
            Node temp = map.get(key);

            if(!temp.visit && temp.type==Type.SHEEP && temp.parent.type==Type.WOLF){
                queue.add(temp);
            }
        }

        while(!queue.isEmpty()){
            Node temp = queue.poll();


        }

        return answer;
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

        public int count() {
            if(visit || type==Type.WOLF) return 0;

            int sum = 1;

            visit = true;
            sum += left==null ? 0 : left.count();
            sum += right==null ? 0 : right.count();

            return sum;
        }

        public int find(){
            int count = 0;
            Node parent = this.parent;

            while(!parent.visit){
                if(parent.type==Type.WOLF){
                    count++;
                }

                parent = parent.parent;
            }

            return count;
        }
    }

    enum Type{
        SHEEP, WOLF;
    }
}
