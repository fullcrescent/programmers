package programmers.level3;

import java.util.*;

public class 길_찾기_게임 {
    public static void main(String[] args) {
        int[][] nodeInfo = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
        int[][] answer = solution(nodeInfo);
        Arrays.stream(answer)
                .forEach(i -> System.out.println(Arrays.toString(i)));
    }

    public static int[][] solution(int[][] nodeInfo) {
        Map<Integer, List<Info>> map = new HashMap<>();

        for(int i=0; i<nodeInfo.length; i++){
            List<Info> temp = map.getOrDefault(nodeInfo[i][1], new ArrayList<>());

            temp.add(new Info(nodeInfo[i][0], i+1));
            map.put(nodeInfo[i][1], temp);
        }

        int end = map.keySet().stream().max(Integer::compareTo).get();

        Node node = function1(map, end, -1, 100001);

        return nodeInfo;
    }

    private static Node function1(Map<Integer, List<Info>> map, int y, int start, int end) {
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
                node = new Node(info.value, function1(map, y - 1, start, x), function1(map, y - 1, x, end));
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
    }
}
