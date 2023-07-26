package programmers.level3;

import java.util.*;

public class 길_찾기_게임 {
    public static void main(String[] args) {
        int[][] nodeInfo = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
        int[][] answer = solution(nodeInfo);
        Arrays.stream(answer)
                .forEach(i -> System.out.println(Arrays.toString(i)));

        int[][] nodeInfo1 = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
        int[][] answer1 = solution1(nodeInfo1);
        Arrays.stream(answer1)
                .forEach(i -> System.out.println(Arrays.toString(i)));
    }

    public static int[][] solution(int[][] nodeInfo) {
        Map<Integer, List<Info>> map = new HashMap<>();

        for(int i=0; i<nodeInfo.length; i++){
            List<Info> temp = map.getOrDefault(nodeInfo[i][1], new ArrayList<>());

            temp.add(new Info(nodeInfo[i][0], i+1));
            map.put(nodeInfo[i][1], temp);
        }

        int end = map.keySet().stream().max(Integer::compareTo).orElse(0);

        Node node = function(map, end, -1, 100001);

        if(node==null)  return new int[nodeInfo.length][2];

        return new int[][] {node.getPreOrderArray(), node.getPostOrderArray()};
    }

    private static Node function(Map<Integer, List<Info>> map, int y, int start, int end) {
        while(map.get(y)==null && -1<y){
            y--;
        }

        if(y<0){
            return null;
        }

        Node node = null;

        List<Info> list = map.get(y);

        for (Info info : list) {
            int x = info.x;

            if (start < x && x < end) {
                node = new Node(info.value, function(map, y - 1, start, x), function(map, y - 1, x, end));
            }
        }

        return node;
    }

    static class Info{
        int x;
        int value;

        public Info(int x, int value) {
            this.x = x;
            this.value = value;
        }
    }

    static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public List<Integer> getPreOrder() {
            List<Integer> list = new LinkedList<>();

            list.add(value);
            if(left!=null)  list.addAll(left.getPreOrder());
            if(right!=null) list.addAll(right.getPreOrder());

            return list;
        }

        public int[] getPreOrderArray(){
            return getPreOrder().stream().mapToInt(i -> i).toArray();
        }

        public List<Integer> getPostOrder() {
            List<Integer> list = new LinkedList<>();

            if(left!=null)  list.addAll(left.getPostOrder());
            if(right!=null) list.addAll(right.getPostOrder());
            list.add(value);

            return list;
        }

        public int[] getPostOrderArray(){
            return getPostOrder().stream().mapToInt(i -> i).toArray();
        }
    }

    /*다른 사람의 풀이 참고*/
    public static int[][] solution1(int[][] nodeInfo) {
        List<Node1> list = new ArrayList<>();

        for(int i=0; i<nodeInfo.length; i++){
            list.add(new Node1(nodeInfo[i][0], nodeInfo[i][1], i+1));
        }

        list.sort((i1, i2) -> {
            if(i1.y==i2.y)  return i1.x-i2.x;
            return i2.y-i1.y;
        });

        Tree tree = new Tree();

        for(Node1 node : list){
            tree.insert(node);
        }

        return new int[][] {tree.root.getPreOrderArray(), tree.root.getPostOrderArray()};
    }

    static class Node1 {
        int x;
        int y;
        int value;
        Node1 left;
        Node1 right;

        public Node1(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
            left = null;
            right = null;
        }

        public List<Integer> getPreOrder() {
            List<Integer> list = new LinkedList<>();

            list.add(value);
            if(left!=null)  list.addAll(left.getPreOrder());
            if(right!=null) list.addAll(right.getPreOrder());

            return list;
        }

        public int[] getPreOrderArray(){
            return getPreOrder().stream().mapToInt(i -> i).toArray();
        }

        public List<Integer> getPostOrder() {
            List<Integer> list = new LinkedList<>();

            if(left!=null)  list.addAll(left.getPostOrder());
            if(right!=null) list.addAll(right.getPostOrder());
            list.add(value);

            return list;
        }

        public int[] getPostOrderArray(){
            return getPostOrder().stream().mapToInt(i -> i).toArray();
        }
    }

    static class Tree{
        Node1 root = null;

        public void insert(Node1 node) {
            if(root==null) {
                root = node;
            }
            else{
                Node1 head = root;
                Node1 currentNode;

                while(true){
                    currentNode = head;

                    if(node.x<currentNode.x){
                        if(currentNode.left==null){
                            currentNode.left = node;
                            break;
                        }
                        else{
                            head = currentNode.left;
                        }
                    }
                    else{
                        if(currentNode.right==null){
                            currentNode.right = node;
                            break;
                        }
                        else{
                            head = currentNode.right;
                        }
                    }
                }
            }
        }
    }
}
