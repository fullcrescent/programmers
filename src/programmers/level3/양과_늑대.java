package programmers.level3;

import java.util.*;

public class 양과_늑대 {
    public static void main(String[] args) {
        int[] info = {0,1,0,1,1,0,1,0,0,0,0};
        int[][] edges = {{0,1},{0,2},{1,3},{1,4},{2,5},{2,6},{3,7},{4,8},{6,9},{9,10}};
        int answer = solution(info, edges);
        System.out.println(answer);
    }

    public static int solution(int[] info, int[][] edges) {
        if(info[0]==1) return 0;

        Map<Integer, Node> map = new HashMap<>();

        for(int i=0; i<info.length; i++){
            map.put(i, new Node(info[i]==0? Type.SHEEP : Type.WOLF, i));
        }

        for(int[] edge : edges){
            Node parent = map.get(edge[0]);
            Node child = map.get(edge[1]);

            parent.addNode(child);
            child.parent = parent;
        }

        int sheepCount = map.get(0).count();
        int wolfCount = 0;

        List<Node> list = new ArrayList<>();

        for(int key : map.keySet()){
            Node temp = map.get(key);

            if(!temp.visit && temp.type==Type.SHEEP && temp.parent.type==Type.WOLF){
                list.add(temp);
            }
        }

        while(wolfCount<=sheepCount){
            if(list.size()==0) return sheepCount;

            list.sort(Comparator.comparingInt(Node::find));

            Node temp = list.get(0);
            list.remove(0);

            wolfCount += temp.select();

            if(wolfCount>=sheepCount) return sheepCount;
            sheepCount += temp.count();
        }

        return sheepCount;
    }

    static class Node{
        Node parent;
        Node left;
        Node right;
        Type type;
        int id;
        boolean visit;

        public Node(Type type, int id) {
            this.type = type;
            this.id = id;
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

        public int select(){
            int count = 0;
            Node parent = this.parent;

            while(!parent.visit){
                parent.visit = true;
                if(parent.type==Type.WOLF){
                    count++;
                }

                parent = parent.parent;
            }

            return count;
        }
    }

    enum Type{
        SHEEP, WOLF
    }
}
